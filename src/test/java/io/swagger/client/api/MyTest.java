package io.swagger.client.api;

import java.util.HashMap;
import java.util.Map;

import io.swagger.client.ApiException;
import io.swagger.client.model.PaymentAction;
import io.swagger.client.util.PaymentActionUtil;

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.PaymentApi;

import java.io.File;
import java.util.*;

public class MyTest {

    public static void main(String[] args) {

        PaymentActionRequest curr = new PaymentActionRequest();
        curr.setMerchantID("702702000001670");
        curr.setInvoiceNo("SGD11038006");
        curr.setVersion("3.4");
        curr.setProcessType("V");

        

        System.out.println(curr.toString());
        try {
            PaymentActionUtil paymentActionUtil = new PaymentActionUtil();
            String encoded = paymentActionUtil.prepareMessage(curr);
            System.out.println(String.format("printing encoded:%s",encoded));
            ApiClient defaultClient = Configuration.getDefaultApiClient();
            PaymentActionApi paymentActionApi = new PaymentActionApi();
            String response = paymentActionApi.paymentAction(encoded);
            String responseDecoded = paymentActionUtil.decodeMessage(response);
            System.out.println(responseDecoded);
        } catch (ApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

