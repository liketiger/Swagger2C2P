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

public class TokenUtil {
    


    public String getJWToken(HashMap<String, Object> payload, String secretKey) {
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
		try {
			JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey)).build();
		    verifier.verify(responseToken);
		}catch(JWTVerificationException e){
			//Invalid signature/claims
			e.printStackTrace();
		}
	}





}
