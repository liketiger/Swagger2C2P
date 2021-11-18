# PaymentApi

All URIs are relative to *https://sandbox-pgw.2c2p.com/payment/4.1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**payment**](PaymentApi.md#payment) | **POST** /Payment | Do Payment

<a name="payment"></a>
# **payment**
> PaymentResponse payment(body)

Do Payment

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.PaymentApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


PaymentApi apiInstance = new PaymentApi();
PaymentRequest body = new PaymentRequest(); // PaymentRequest | Request body
try {
    PaymentResponse result = apiInstance.payment(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentApi#payment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PaymentRequest**](PaymentRequest.md)| Request body |

### Return type

[**PaymentResponse**](PaymentResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

