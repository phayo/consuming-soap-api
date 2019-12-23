package com.ebuka.soap_api;

import com.dataaccess.webservicesserver.NumberToWords;
import com.dataaccess.webservicesserver.NumberToWordsResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.math.BigInteger;

public class NumberClient extends WebServiceGatewaySupport {

    public NumberToWordsResponse getWords(String number){
        //publicly accessible SOAP service
        String uri = "https://www.dataaccess.com/webservicesserver/NumberConversion.wso";

        // setting the request
        NumberToWords numberRequest = new NumberToWords();
        numberRequest.setUbiNum(new BigInteger(number));

        //calling api and returning response
        NumberToWordsResponse response =
                (NumberToWordsResponse) getWebServiceTemplate().marshalSendAndReceive(uri, numberRequest);

        return response;

    }
}
