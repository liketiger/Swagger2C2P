package io.swagger.client.util;


import org.apache.commons.codec.binary.Hex;

import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64.Encoder;
import java.util.Base64.Decoder;

public class CodecUtil {
    private Encoder encoder = Base64.getEncoder();
    private Decoder decoder = Base64.getDecoder(); 

    private String secretKey = "62994BE2F50E0B01B79EDA3FFFFA25DCDEED2491472DFC9510DD2AD9165EC861";

    public String hashHMAC(String toHash){
        try{
            byte[] keyBytes = secretKey.getBytes();      
            SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(toHash.getBytes());
            byte[] hexBytes = new Hex().encode(rawHmac);
            return new String(hexBytes, "UTF-8").toUpperCase();
    
        }
        catch (Exception e){
            e.printStackTrace();
            return "No Algorithm Found";
        }

    }   

    public String encodeString (String toEncode){
        byte[] encodedBytes = encoder.encode(toEncode.getBytes());
        return new String(encodedBytes);
    }

    public String decodeString(String toDecode){
        byte[] decodedBytes = decoder.decode(toDecode);
        return new String(decodedBytes);
    }

}
