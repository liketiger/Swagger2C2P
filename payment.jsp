<%@ page language="java" contentType = "text/html;charset=utf-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import="java.io.swagger.client.Payment"%>
<%@ page import="java.io.swagger.client.dto.*" %>
<%@ page import="java.io.swagger.client.util.*" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>

<%	
	String requestParameter = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
	JSONParser jsonParser = new JSONParser();
	Object obj = jsonParser.parse(requestParameter);
	JSONObject jsonObj = (JSONObject) obj;
	
	String responseReturnUrl = "localhost:8080/test2c2p/success.jsp";
	
	List<Object> paymentChannel = Collections.singletonList(jsonObj.get("paymentChannel"));

	RequestDTO requestDTO =  new RequestDTO();
	requestDTO.setMerchantID(jsonObj.get("merchantID").toString());
	requestDTO.setInvoiceNo(jsonObj.get("invoiceNo").toString());
	requestDTO.setDescription(jsonObj.get("description").toString());
	requestDTO.setCurrencyCode(jsonObj.get("currencyCode").toString());
	requestDTO.setAmount(jsonObj.get("amount").toString());
	requestDTO.setResponseReturnUrl(responseReturnUrl);
	//requestDTO.setName(jsonObj.get("name").toString());
	//requestDTO.setEmail(jsonObj.get("email").toString());
	//requestDTO.setPhone(jsonObj.get("phone").toString());
	//requestDTO.setAccount(jsonObj.get("account").toString());
	//requestDTO.setPaymentChannel(paymentChannel);
	

	String redirectPaymentURL = new Payment().doPayment(requestDTO);
	System.out.println(redirectPaymentURL);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <link rel="stylesheet" href="assets/css/index.css">
</head>
<body>
<%
	response.sendRedirect(redirectPaymentURL);
%>
payment 페이지
</body>
</html>


