package io.swagger.client.util;

import java.util.HashMap;
import io.swagger.client.model.PaymentTokenRequest;

public class Payment {

	public String prepareMessage(PaymentTokenRequest paymentTokenRequest) throws Exception {
		String secretKey = "62994BE2F50E0B01B79EDA3FFFFA25DCDEED2491472DFC9510DD2AD9165EC861";
		HashMap<String, Object> payload = makePayload(paymentTokenRequest);
		return new TokenUtil().getJWToken(payload, secretKey);
	}

	public String generateToken(String requestPayload) throws Exception{
		TokenUtil tokenUtil = new TokenUtil();
		String secretKey = "62994BE2F50E0B01B79EDA3FFFFA25DCDEED2491472DFC9510DD2AD9165EC861";
		String paymentToken = tokenUtil.getPaymentToken(requestPayload, secretKey);
		return paymentToken;
	}
	
	private HashMap<String, Object> makePayload(PaymentTokenRequest request) {
		HashMap<String, Object> payload = new HashMap<>();
		payload.put("merchantID", request.getMerchantID());
		payload.put("invoiceNo",  request.getInvoiceNo());
		payload.put("description",request.getDescription());
		payload.put("amount", request.getAmount());
		payload.put("currencyCode",request.getCurrencyCode());
		payload.put("frontendReturnUrl",request.getFrontendReturnUrl());
        return payload;
    }

}
