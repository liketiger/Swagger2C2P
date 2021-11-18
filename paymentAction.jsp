<%@ page contentType = "text/html;charset=utf-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import="java.io.swagger.client.util.*"%>
<%@ page import="java.io.swagger.client.dto.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<%
	String requestParameter = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
	JSONParser jsonParser = new JSONParser();
	Object obj = jsonParser.parse(requestParameter);
	JSONObject jsonObj = (JSONObject) obj;
	
	System.out.println();
	
	PaymentActionRequestDTO paymentActionDTO = new PaymentActionRequestDTO();
	
	paymentActionDTO.setMerchantID(jsonObj.get("merchantID").toString());
	paymentActionDTO.setProcessType(jsonObj.get("processType").toString());
	paymentActionDTO.setInvoiceNo(jsonObj.get("invoiceNo").toString());
	paymentActionDTO.setVersion(jsonObj.get("version").toString());
	paymentActionDTO.setActionAmount(jsonObj.get("actionAmount").toString());
	
	
	
	HashMap<String,String> paymentActionResult = new PaymentAction().doPaymentAction(paymentActionDTO);
	
	System.out.println(paymentActionResult);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-16LE">
<title>Insert title here</title>
</head>
<body>

</body>
</html>