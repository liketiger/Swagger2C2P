package io.swagger.client.util;

import java.util.HashMap;


import org.json.simple.JSONObject;

import io.swagger.client.model.PaymentTokenRequest;
import io.swagger.client.dto.RequestDTO;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;



public class Payment {

	public String tooString() {
		return ("wtf"); 
	}

	public String doesPayment(RequestDTO request) throws Exception {
		TokenUtil tokenUtil = new TokenUtil();
		//0.Prepare Secret Key & endPoint
		String secretKey = "62994BE2F50E0B01B79EDA3FFFFA25DCDEED2491472DFC9510DD2AD9165EC861";
		String endPointForPaymentToken = "https://sandbox-pgw.2c2p.com/payment/4.1/paymentToken";
		String endPointForPayment = "https://sandbox-pgw.2c2p.com/payment/4.1/payment";
		
		//1.Prepare Payload Data 
		HashMap<String, Object> payload = makePayloadTemp(request);
		System.out.println("1.payload::"+payload);
		
		//2.Generate JWToken
		String JWToken = tokenUtil.getJWToken(payload, secretKey);
		System.out.println("2.JWToken::"+JWToken);
		
		//3.Send JWToken to API
		String requestPayload = sendRequest(JWToken, endPointForPaymentToken);
		System.out.println("3.requestPayload::"+requestPayload);
		return requestPayload;
	}

	private HashMap<String, Object> makePayloadTemp(RequestDTO request) {
		HashMap<String, Object> payload = new HashMap<>();
		payload.put("merchantID", request.getMerchantID());
		payload.put("invoiceNo",  request.getInvoiceNo());
		payload.put("description",request.getDescription());
		payload.put("amount", request.getAmount());
		payload.put("currencyCode",request.getCurrencyCode());
		payload.put("frontendReturnUrl","http://localhost:8080/success.jsp");
        
        return payload;
    }

		
	private HashMap<String, Object> makePayload(PaymentTokenRequest request) {
		HashMap<String, Object> payload = new HashMap<>();
		payload.put("merchantID", request.getMerchantID());
		payload.put("invoiceNo",  request.getInvoiceNo());
		payload.put("description",request.getDescription());
		payload.put("amount", request.getAmount());
		payload.put("currencyCode",request.getCurrencyCode());
		payload.put("frontendReturnUrl","http://localhost:8080/success.jsp");
        return payload;
    }
	


	public String generateToken(String requestPayload) throws Exception{
		TokenUtil tokenUtil = new TokenUtil();
		String secretKey = "62994BE2F50E0B01B79EDA3FFFFA25DCDEED2491472DFC9510DD2AD9165EC861";
		String paymentToken = tokenUtil.getPaymentToken(requestPayload, secretKey);
		System.out.println("4.paymentToken"+paymentToken);
		return paymentToken;
	}
	
	
	public String prepareMessage(PaymentTokenRequest paymentTokenRequest) throws Exception {
		
		TokenUtil tokenUtil = new TokenUtil();
		//0.Prepare Secret Key & endPoint
		String secretKey = "62994BE2F50E0B01B79EDA3FFFFA25DCDEED2491472DFC9510DD2AD9165EC861";
		String endPointForPaymentToken = "https://sandbox-pgw.2c2p.com/payment/4.1/paymentToken";
		String endPointForPayment = "https://sandbox-pgw.2c2p.com/payment/4.1/payment";
		
		//1.Prepare Payload Data 
		HashMap<String, Object> payload = makePayload(paymentTokenRequest);
		System.out.println("1.payload::"+payload);
		
		//2.Generate JWToken
		String JWToken = tokenUtil.getJWToken(payload, secretKey);
		System.out.println("2.JWToken::"+JWToken);

		return JWToken;
	

		
		/*
		//3.Send JWToken to API
		String requestPayload = sendRequest(JWToken, endPointForPaymentToken);
		System.out.println("3.requestPayload::"+requestPayload);
		
		//4.Generate paymentToken 
		String paymentToken = tokenUtil.getPaymentToken(requestPayload, secretKey);
		System.out.println("4.paymentToken"+paymentToken);

		//5.Request Payment to API
		String result = sendPayment(paymentToken, endPointForPayment, request);
		System.out.println("5. result::"+result);
		
		//6.Set redirectPaymentURL
		JSONParser parser = new JSONParser();
	    JSONObject responseJSON = (JSONObject) parser.parse(result);
	    String redirectPaymentURL = responseJSON.get("data").toString();
		
		return redirectPaymentURL;
		*/
	}
	/*
	private String sendPayment(String paymentToken, String endPoint, PaymentTokenRequest request) throws Exception {

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
	    

	    return getConnection(requestData, endPoint);
	}
	
	*/


	private String sendRequest(String token, String endPoint) throws Exception {
	    JSONObject requestData = new JSONObject();
	    requestData.put("payload", token);
	    return getConnection(requestData, endPoint);
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
