# PaymentTokenApi

All URIs are relative to *https://sandbox-pgw.2c2p.com/payment/4.1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**paymentToken**](PaymentTokenApi.md#paymentToken) | **POST** /PaymentToken | Generate Payment Token

<a name="paymentToken"></a>
# **paymentToken**
> PaymentTokenResponse paymentToken(body)

Generate Payment Token

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.PaymentTokenApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


PaymentTokenApi apiInstance = new PaymentTokenApi();
PaymentTokenRequest body = new PaymentTokenRequest(); // PaymentTokenRequest | Request body
try {
    PaymentTokenResponse result = apiInstance.paymentToken(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentTokenApi#paymentToken");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PaymentTokenRequest**](PaymentTokenRequest.md)| Request body |

### Return type

[**PaymentTokenResponse**](PaymentTokenResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

