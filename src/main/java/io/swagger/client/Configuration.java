
package io.swagger.client;

import java.util.Properties;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-11-18T05:35:09.941Z[GMT]")public class Configuration {
    private static ApiClient defaultApiClient = new ApiClient();

    /**
     * Get the default API client, which would be used when creating API
     * instances without providing an API client.
     *
     * @return Default API client
     */
    public static ApiClient getDefaultApiClient() {
        return defaultApiClient;
    }

    /**
     * Set the default API client, which would be used when creating API
     * instances without providing an API client.
     *
     * @param apiClient API client
     */
    public static void setDefaultApiClient(ApiClient apiClient) {
        defaultApiClient = apiClient;
    }



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
