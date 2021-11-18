# PaymentActionApi

All URIs are relative to *https://sandbox-pgw.2c2p.com/payment/4.1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**paymentAction**](PaymentActionApi.md#paymentAction) | **POST** /PaymentProcess.aspx | Get Status on Payment Transaction

<a name="paymentAction"></a>
# **paymentAction**
> String paymentAction(paymentRequest)

Get Status on Payment Transaction

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.PaymentActionApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();


PaymentActionApi apiInstance = new PaymentActionApi();
String paymentRequest = "paymentRequest_example"; // String | 
try {
    String result = apiInstance.paymentAction(paymentRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentActionApi#paymentAction");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **paymentRequest** | **String**|  |

### Return type

**String**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: text/plain

