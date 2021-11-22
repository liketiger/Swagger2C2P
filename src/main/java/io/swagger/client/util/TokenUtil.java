package io.swagger.client.util;

import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.*;

import com.auth0.jwt.interfaces.*;



import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;


public class TokenUtil {
    
    public String getJWToken(HashMap<String, Object> payload, String secretKey) {
		StringBuffer response = new StringBuffer();
		Algorithm algorithm = Algorithm.HMAC256(secretKey);
		response.append(JWT.create().withPayload(payload).sign(algorithm));           

		return response.toString();
	}

    public String getPaymentToken(String responsePayload, String secretKey) {
		StringBuffer response = new StringBuffer();
		try{
		    verifyToken(responsePayload, secretKey);

		    //decode encoded payload
		    Map<String, Claim> responseData = getDecodedJWT(responsePayload);
		    String paymentToken = responseData.get("paymentToken").toString();
		    String webPaymentUrl = responseData.get("webPaymentUrl").toString();
		    System.out.println("webPaymentUrl::"+webPaymentUrl);
		    
		    response.append(paymentToken);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return response.toString().substring(1,response.toString().length()-1);
	}
	
    public Map<String, Claim> getDecodedJWT(String responseToken) {
	    DecodedJWT jwt = JWT.decode(responseToken);
	    return jwt.getClaims();
	}

    public void verifyToken(String responseToken, String secretKey) {
			JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey)).build();
		    verifier.verify(responseToken);
	
	}

}
