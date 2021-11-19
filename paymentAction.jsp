<%@ page contentType = "text/html;charset=utf-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import="io.swagger.client.dto.*" %>
<%@ page import="io.swagger.client.model.PaymentActionRequest"%>
<%@ page import="io.swagger.client.util.PaymentActionUtil"%>
<%@ page import="io.swagger.client.ApiClient"%>
<%@ page import="io.swagger.client.ApiException"%>
<%@ page import="io.swagger.client.Configuration"%>
<%@ page import="io.swagger.client.api.PaymentActionApi"%>
<%@ page import="java.util.*" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<%
	/*
	String requestParameter = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
	JSONParser jsonParser = new JSONParser();
	Object obj = jsonParser.parse(requestParameter);
	JSONObject jsonObj = (JSONObject) obj;
	
	System.out.println();
	
	PaymentActionRequest paymentActionRequest = new PaymentActionRequest();
	
	paymentActionRequest.setMerchantID(jsonObj.get("merchantID").toString());
	paymentActionRequest.setProcessType(jsonObj.get("processType").toString());
	paymentActionRequest.setInvoiceNo(jsonObj.get("invoiceNo").toString());
	paymentActionRequest.setVersion(jsonObj.get("version").toString());
	paymentActionRequest.setActionAmount(jsonObj.get("actionAmount").toString());
	*/

	PaymentActionRequest curr = new PaymentActionRequest();
	curr.setMerchantID("702702000001670");
	curr.setInvoiceNo("SGD11038006");
	curr.setVersion("3.4");
	curr.setProcessType("V");
	System.out.println(curr.toString());

	try {
		PaymentActionUtil paymentActionUtil = new PaymentActionUtil();
		String encoded = paymentActionUtil.prepareMessage(curr);
		System.out.println(String.format("printing encoded:%s",encoded));
		ApiClient defaultClient = Configuration.getDefaultApiClient();
		PaymentActionApi paymentActionApi = new PaymentActionApi();
		String responsea = paymentActionApi.paymentAction(encoded);
		String responseDecoded = paymentActionUtil.decodeMessage(responsea);
		System.out.println(responseDecoded);
	} catch (ApiException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
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