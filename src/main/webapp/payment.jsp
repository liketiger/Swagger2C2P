<%@ page language="java" contentType = "text/html;charset=utf-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import="io.swagger.client.util.Payment"%>
<%@ page import="io.swagger.client.model.PaymentTokenAPIRequest"%>
<%@ page import="io.swagger.client.model.PaymentTokenRequest"%>
<%@ page import="io.swagger.client.model.PaymentTokenAPIResponse"%>
<%@ page import="io.swagger.client.model.PaymentTokenResponse"%>
<%@ page import="io.swagger.client.model.PaymentRequest"%>
<%@ page import="io.swagger.client.model.PaymentResponse"%>
<%@ page import="io.swagger.client.model.PaymentRequestPayment"%>
<%@ page import="io.swagger.client.model.PaymentRequestPaymentCode"%>
<%@ page import="io.swagger.client.model.PaymentRequestPaymentData"%>
<%@ page import="io.swagger.client.ApiClient"%>
<%@ page import="io.swagger.client.ApiException"%>
<%@ page import="io.swagger.client.Configuration"%>
<%@ page import="io.swagger.client.api.PaymentApi"%>
<%@ page import="io.swagger.client.api.PaymentTokenApi"%>
<%@ page import="io.swagger.client.dto.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.stream.Collectors" %>

<%	


	String frontendReturnUrl = "http://localhost:8080/success.jsp/";

	PaymentTokenRequest paymentTokenRequest = new PaymentTokenRequest();
	paymentTokenRequest.setMerchantID(request.getParameter("merchantID"));
	paymentTokenRequest.setInvoiceNo(request.getParameter("invoiceNo"));
	paymentTokenRequest.setDescription(request.getParameter("description"));
	paymentTokenRequest.setCurrencyCode(request.getParameter("currencyCode"));
	paymentTokenRequest.setAmount(request.getParameter("amount"));
	paymentTokenRequest.setFrontendReturnUrl(frontendReturnUrl);
	Payment payment = new Payment();
	

	try {
		String JWToken = payment.prepareMessage(paymentTokenRequest);
		ApiClient defaultClient = Configuration.getDefaultApiClient();
		PaymentTokenApi paymentTokenApi = new PaymentTokenApi();

		PaymentTokenAPIRequest paymentTokenAPIRequest = new PaymentTokenAPIRequest();
		paymentTokenAPIRequest.setPayload(JWToken);

		PaymentTokenAPIResponse paymentTokenAPIResponse = paymentTokenApi.paymentToken(paymentTokenAPIRequest);
		System.out.println(paymentTokenAPIResponse.toString());

		String payload = paymentTokenAPIResponse.getPayload();
		String token = payment.generateToken(payload);

		PaymentRequest paymentRequest = new PaymentRequest();
		paymentRequest.setPaymentToken(token);

		PaymentRequestPayment paymentRequestPayment = new PaymentRequestPayment();

		PaymentRequestPaymentData paymentRequestPaymentData = new PaymentRequestPaymentData();
		paymentRequestPaymentData.setName("Liz");
		paymentRequestPaymentData.setEmail("s_holmes25@naver.com");
		PaymentRequestPaymentCode paymentRequestPaymentCode = new PaymentRequestPaymentCode();
		paymentRequestPaymentCode.setChannelCode("ALIPAY");

		paymentRequestPayment.setData(paymentRequestPaymentData);
		paymentRequestPayment.setCode(paymentRequestPaymentCode);
		paymentRequest.setPayment(paymentRequestPayment);
		
		System.out.println(paymentRequest.toString());
		PaymentResponse paymentResponse = new PaymentResponse();
		PaymentApi paymentApi = new PaymentApi();
		paymentResponse = paymentApi.payment(paymentRequest);
		System.out.println("---------------------------------------------");
		System.out.println(paymentResponse.getRespCode());
		System.out.println(paymentResponse.getRespDesc());
		System.out.println(paymentResponse.getData());
		String redirectPaymentURL = paymentResponse.getData();
		response.sendRedirect(redirectPaymentURL);


	} catch (ApiException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
%>





