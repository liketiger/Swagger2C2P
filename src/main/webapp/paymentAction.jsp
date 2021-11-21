<%@ page contentType = "text/html;charset=utf-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import="io.swagger.client.dto.*" %>
<%@ page import="io.swagger.client.model.PaymentActionRequest"%>
<%@ page import="io.swagger.client.util.PaymentActionUtil"%>
<%@ page import="io.swagger.client.ApiClient"%>
<%@ page import="io.swagger.client.ApiException"%>
<%@ page import="io.swagger.client.configurations.MerchantConfiguration"%>
<%@ page import="io.swagger.client.configurations.MerchantConfig"%>

<%@ page import="io.swagger.client.Configuration"%>

<%@ page import="io.swagger.client.api.PaymentActionApi"%>
<%@ page import="java.util.*" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<%
	
	String requestParameter = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
	System.out.println(requestParameter);
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
	

	try {
		PaymentActionUtil paymentActionUtil = new PaymentActionUtil();
		String encoded = paymentActionUtil.prepareMessage(paymentActionRequest);
		System.out.println(String.format("printing encoded:%s",encoded));
		MerchantConfiguration merchantConfiguration = new MerchantConfiguration();
		Properties merchantAPIProp = merchantConfiguration.getPaymentActionApiDetails();
		MerchantConfig merchantAPIConfig = new MerchantConfig(merchantAPIProp);
		System.out.println(merchantAPIConfig.getBaseUrl());
		ApiClient defaultClient = new ApiClient(merchantAPIConfig);
		PaymentActionApi paymentActionApi = new PaymentActionApi(defaultClient);
		String responsea = paymentActionApi.paymentAction(encoded);
		HashMap<String,String> xmlMap = paymentActionUtil.decodeMessage(responsea);
		Boolean valid = paymentActionUtil.checkValidity(xmlMap);

		if (valid){
			response.addHeader("Location","request_success.html");
		}
		else{
			response.addHeader("Location","request_fail.html");
		}
	} catch (ApiException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

 
%>