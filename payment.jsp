<%@ page language="java" contentType = "text/html;charset=utf-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import="io.swagger.client.util.Payment"%>
<%@ page import="io.swagger.client.dto.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<%	
	
	String responseReturnUrl = "localhost:8080/test2c2p/success.jsp";
	
	RequestDTO requestDTO =  new RequestDTO();
	requestDTO.setMerchantID(request.getParameter("merchantID"));
	requestDTO.setInvoiceNo(request.getParameter("invoiceNo"));
	requestDTO.setDescription(request.getParameter("description"));
	requestDTO.setCurrencyCode(request.getParameter("currencyCode"));
	requestDTO.setAmount(request.getParameter("amount"));
	requestDTO.setResponseReturnUrl(responseReturnUrl);
	
	String redirectPaymentURL = new Payment().doPayment(requestDTO);
	System.out.println(redirectPaymentURL);
	
	response.sendRedirect(redirectPaymentURL);
%>





