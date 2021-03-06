
package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.swagger.client.model.PaymentTokenAPIRequest;
import io.swagger.client.model.PaymentTokenAPIResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentTokenApi {
    private ApiClient apiClient;

    public PaymentTokenApi() {
        this(Configuration.getDefaultApiClient());
    }

    public PaymentTokenApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for paymentToken
     * @param body prepare an instance of PaymentTokenRequest, and use algorithm HMAC SHA256 to encode your PaymentTokenRequest instance. The encoded result will serve as the payload of the request body. See more at https://developer.2c2p.com/recipes/generate-jwt-token (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call paymentTokenCall(PaymentTokenAPIRequest body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/PaymentToken";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "bearerAuth" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call paymentTokenValidateBeforeCall(PaymentTokenAPIRequest body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling paymentToken(Async)");
        }
        
        com.squareup.okhttp.Call call = paymentTokenCall(body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Generate Payment Token
     * 
     * @param body prepare an instance of PaymentTokenRequest, and use algorithm HMAC SHA256 to encode your PaymentTokenRequest instance. The encoded result will serve as the payload of the request body. See more at https://developer.2c2p.com/recipes/generate-jwt-token (required)
     * @return PaymentTokenAPIResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PaymentTokenAPIResponse paymentToken(PaymentTokenAPIRequest body) throws ApiException {
        ApiResponse<PaymentTokenAPIResponse> resp = paymentTokenWithHttpInfo(body);
        return resp.getData();
    }

    /**
     * Generate Payment Token
     * 
     * @param body prepare an instance of PaymentTokenRequest, and use algorithm HMAC SHA256 to encode your PaymentTokenRequest instance. The encoded result will serve as the payload of the request body. See more at https://developer.2c2p.com/recipes/generate-jwt-token (required)
     * @return ApiResponse&lt;PaymentTokenAPIResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<PaymentTokenAPIResponse> paymentTokenWithHttpInfo(PaymentTokenAPIRequest body) throws ApiException {
        com.squareup.okhttp.Call call = paymentTokenValidateBeforeCall(body, null, null);
        Type localVarReturnType = new TypeToken<PaymentTokenAPIResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Generate Payment Token (asynchronously)
     * 
     * @param body prepare an instance of PaymentTokenRequest, and use algorithm HMAC SHA256 to encode your PaymentTokenRequest instance. The encoded result will serve as the payload of the request body. See more at https://developer.2c2p.com/recipes/generate-jwt-token (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call paymentTokenAsync(PaymentTokenAPIRequest body, final ApiCallback<PaymentTokenAPIResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = paymentTokenValidateBeforeCall(body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PaymentTokenAPIResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
