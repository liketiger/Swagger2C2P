package io.swagger.client.configurations;

import java.util.Properties;

public class MerchantConfiguration {

    private static Properties getMerchantDetails() {
        Properties props = new Properties();

        //Merchant Info
        props.setProperty("merchantID", "702702000001670");
        props.setProperty("secretKey", "62994BE2F50E0B01B79EDA3FFFFA25DCDEED2491472DFC9510DD2AD9165EC861");
        return props;   
    }

    public static Properties getPaymentApiDetails(){
        Properties props = new Properties();

        //Merchant Info
        props = getMerchantDetails();

        //API Base URL info
        props.setProperty("baseUrl", "https://sandbox-pgw.2c2p.com/payment/4.1");

        return props;   
    }

    public static Properties getPaymentActionApiDetails() {
        Properties props = new Properties();

        //Merchant Info
        props = getMerchantDetails();

        //Payment Action API Base URL info
        props.setProperty("baseUrl", "https://demo2.2c2p.com/2C2PFrontend/PaymentActionV2");

        return props;   
    }
}