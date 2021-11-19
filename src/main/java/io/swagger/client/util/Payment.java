package io.swagger.client.util;

import java.util.HashMap;
import java.util.Map;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import io.swagger.client.dto.RequestDTO;

import com.auth0.jwt.*;
import com.auth0.jwt.algorithms.*;
import com.auth0.jwt.interfaces.*;



import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;


public class Payment {
	

	public String tooString() {
		return ("wtf"); 
	}
	
	public String doPayment(RequestDTO request) throws Exception {
		
		//0.Prepare Secret Key & endPoint
		String secretKey = "62994BE2F50E0B01B79EDA3FFFFA25DCDEED2491472DFC9510DD2AD9165EC861";
		String endPointForPaymentToken = "https://sandbox-pgw.2c2p.com/payment/4.1/paymentToken";
		String endPointForPayment = "https://sandbox-pgw.2c2p.com/payment/4.1/payment";
		
		//1.Prepare Payload Data 
		HashMap<String, Object> payload = makePayload(request);
		System.out.println("1.payload::"+payload);
		
		//2.Generate JWToken
		String JWToken = getJWToken(payload, secretKey);
		System.out.println("2.JWToken::"+JWToken);
		
		//3.Send JWToken to API
		String requestPayload = sendRequest(JWToken, endPointForPaymentToken);
		System.out.println("3.requestPayload::"+requestPayload);
		
		//4.Generate paymentToken 
		String paymentToken = getPaymentToken(requestPayload, secretKey);
		System.out.println("4.paymentToken"+paymentToken);

		//5.Request Payment to API
		String result = sendPayment(paymentToken, endPointForPayment, request);
		System.out.println("5. result::"+result);
		
		//6.Set redirectPaymentURL
		JSONParser parser = new JSONParser();
	    JSONObject responseJSON = (JSONObject) parser.parse(result);
	    String redirectPaymentURL = responseJSON.get("data").toString();
		
		return redirectPaymentURL;
	}
	
	private String sendPayment(String paymentToken, String endPoint, RequestDTO request) throws Exception {

	    JSONObject requestData = new JSONObject();
	    requestData.put("paymentToken",paymentToken.substring(1,paymentToken.length()-1));

	    JSONObject customer = new JSONObject();
	    //customer.put("channelCode", request.getPaymentChannel().get(0));
	    customer.put("channelCode", "ALIPAY");
	    
	    JSONObject data = new JSONObject();
	    data.put("name", request.getName());
	    data.put("email",request.getEmail());

	    JSONObject payment = new JSONObject();
	    payment.put("code",customer);
	    payment.put("data",data);
	    requestData.put("payment",payment);
	    requestData.put("responseReturnUrl",request.getResponseReturnUrl());
	    

	    return getConnection(requestData, endPoint);
	}
	
	
	private String getPaymentToken(String responsePayload, String secretKey) {
		StringBuffer response = new StringBuffer();
		try{
			JSONParser parser = new JSONParser();
		    JSONObject responseJSON = (JSONObject) parser.parse(responsePayload);
		    String responseToken = responseJSON.get("payload").toString();
		    
		    //verify signature
		    verifyToken(responseToken, secretKey);

		    //decode encoded payload
		    Map<String, Claim> responseData = getDecodedJWT(responseToken);
		    String paymentToken = responseData.get("paymentToken").toString();
		    String webPaymentUrl = responseData.get("webPaymentUrl").toString();
		    System.out.println("webPaymentUrl::"+webPaymentUrl);
		    
		    response.append(paymentToken);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return response.toString();
	}
	
	private void verifyToken(String responseToken, String secretKey) {
		try {
			JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey)).build();
		    verifier.verify(responseToken);
		}catch(JWTVerificationException e){
			//Invalid signature/claims
			e.printStackTrace();
		}
	}

	private Map<String, Claim> getDecodedJWT(String responseToken) {
	    DecodedJWT jwt = JWT.decode(responseToken);
	    return jwt.getClaims();
	}

	
	private HashMap<String, Object> makePayload(RequestDTO request) {
		HashMap<String, Object> payload = new HashMap<>();
		payload.put("merchantID", request.getMerchantID());
		payload.put("invoiceNo",  request.getInvoiceNo());
		payload.put("description",request.getDescription());
		payload.put("amount", request.getAmount());
		payload.put("currencyCode",request.getCurrencyCode());
	
        
        return payload;
    }
	
	private String sendRequest(String token, String endPoint) throws Exception {
	    JSONObject requestData = new JSONObject();
	    requestData.put("payload", token);
	    return getConnection(requestData, endPoint);
	}
	
	private String getJWToken(HashMap<String, Object> payload, String secretKey) {
		StringBuffer response = new StringBuffer();
		try {
			  Algorithm algorithm = Algorithm.HMAC256(secretKey);
			  response.append(JWT.create().withPayload(payload).sign(algorithm));           
			 
			} catch (JWTCreationException | IllegalArgumentException e){
			  //Invalid Signing configuration / Couldn't convert Claims.
			  e.printStackTrace();

			}
		return response.toString();
	}
	
	
	private String getConnection(JSONObject requestData,String endPoint) throws Exception {
		StringBuffer response = new StringBuffer();
        try {
            URL obj = new URL(endPoint);
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/*+json");
            con.setRequestProperty("Accept", "text/plain");

            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(requestData.toString());
            wr.flush();
            wr.close();


            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            }catch(Exception e){
            e.printStackTrace(); 
            }
        return response.toString();
    }

}
