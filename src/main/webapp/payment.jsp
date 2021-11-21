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
	String frontendReturnUrl = "http://localhost:8080/success.jsp";

	PaymentTokenRequest paymentTokenRequest = new PaymentTokenRequest();
	paymentTokenRequest.setMerchantID(request.getParameter("merchantID"));
	paymentTokenRequest.setInvoiceNo(request.getParameter("invoiceNo"));
	paymentTokenRequest.setDescription(request.getParameter("description"));
	paymentTokenRequest.setCurrencyCode(request.getParameter("currencyCode"));
	paymentTokenRequest.setAmount(request.getParameter("amount"));
	paymentTokenRequest.setFrontendReturnUrl(frontendReturnUrl);

	PaymentRequestPaymentData paymentRequestPaymentData = new PaymentRequestPaymentData();
	paymentRequestPaymentData.setName(request.getParameter("name"));
	paymentRequestPaymentData.setEmail(request.getParameter("email"));

	PaymentRequestPaymentCode paymentRequestPaymentCode = new PaymentRequestPaymentCode();
	paymentRequestPaymentCode.setChannelCode("ALIPAY");
	//paymentRequestPaymentCode.setChannelCode(request.getParameter("channelCode"));

	try {
		Payment payment = new Payment();

		String JWToken = payment.prepareMessage(paymentTokenRequest);
		ApiClient defaultClient = Configuration.getDefaultApiClient();

		PaymentTokenAPIRequest paymentTokenAPIRequest = new PaymentTokenAPIRequest();
		paymentTokenAPIRequest.setPayload(JWToken);
		PaymentTokenAPIResponse paymentTokenAPIResponse = new PaymentTokenApi().paymentToken(paymentTokenAPIRequest);


		String payload = paymentTokenAPIResponse.getPayload();
		String token = payment.generateToken(payload);
		PaymentRequest paymentRequest = new PaymentRequest();
		paymentRequest.setPaymentToken(token);

		PaymentRequestPayment paymentRequestPayment = new PaymentRequestPayment();
		paymentRequestPayment.setData(paymentRequestPaymentData);
		paymentRequestPayment.setCode(paymentRequestPaymentCode);
		paymentRequest.setPayment(paymentRequestPayment);
		

		PaymentResponse paymentResponse = new PaymentResponse();
		paymentResponse =  new PaymentApi().payment(paymentRequest);
		String redirectPaymentURL = paymentResponse.getData();
		response.sendRedirect(redirectPaymentURL);

		System.out.println("ResponseCode ::"+paymentResponse.getRespCode());
		System.out.println("ResponseDesc ::"+paymentResponse.getRespDesc());
		System.out.println("WebPaymentUrl ::"+paymentResponse.getData());
		
	} catch (ApiException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
%>





