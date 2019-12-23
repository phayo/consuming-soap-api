package com.ebuka.soap_api;

import com.dataaccess.webservicesserver.NumberToWordsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@SpringBootApplication
public class SoapApiApplication implements CommandLineRunner {
    private Logger log = LoggerFactory.getLogger(SoapApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SoapApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        NumberClient numberClient = new NumberClient();

        //create and setup marshaller
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

        //Providing location to the objectFactory
        marshaller.setContextPath("com.dataaccess.webservicesserver");

        //Set marshaller and unmarshaller to NumberClient class (ass a result of the WebServiceGatewaySupport extended)
        numberClient.setMarshaller(marshaller);
        numberClient.setUnmarshaller(marshaller);

        //retrieve the word format of a number
        int randomNumber = (int)(Math.random()*9000)+1000;
        log.info("Random Number generated is : " + randomNumber);
        NumberToWordsResponse response = numberClient.getWords(String.valueOf(randomNumber));

        log.info("Generated Number in words for " +
                "generated random number "+ randomNumber +" is: " + response.getNumberToWordsResult());

    }
}
