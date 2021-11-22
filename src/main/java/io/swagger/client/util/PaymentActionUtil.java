package io.swagger.client.util;

import java.util.HashMap;
import io.swagger.client.model.PaymentActionRequest;
import io.swagger.client.model.PaymentProcessRequest;

import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.w3c.dom.*;


public class PaymentActionUtil {

    private String selectMerchant(String invoiceNo){
        int invoiceStart = 0;
        int invoiceEnd = 3;
        String country = invoiceNo.substring(invoiceStart,invoiceEnd);
        String merchantID;
        switch (country) {
            case "SGD":
              merchantID = "702702000001670";
              break;
            case "PHP":
              merchantID = "608608000000685";
              break;
            case "MYR":
              merchantID = "458458000001107";
              break;
            case "MMK":
              merchantID = "104104000000550";
              break;
            case "THB":
              merchantID = "764764000009889";
              break;
            case "VND":
              merchantID = "704704000000046";
              break;

            //defaults to Singapore Merchant ID;
            default:
                merchantID ="702702000001670";
        }
        return merchantID;
    }

    public String prepareMessage(PaymentActionRequest paymentActionRequest){
        String invoiceNo = paymentActionRequest.getInvoiceNo();
        String version = paymentActionRequest.getVersion();
        String processType = paymentActionRequest.getProcessType();
        String actionAmount = paymentActionRequest.getActionAmount();
        String jsMerchantID = paymentActionRequest.getMerchantID();
        String merchantID = selectMerchant(invoiceNo);

        //https://developer.2c2p.com/docs/status-inquiry 

        PaymentProcessRequest paymentProcessRequest = new PaymentProcessRequest();
        paymentProcessRequest.setVersion(version);
        paymentProcessRequest.setProcessType(processType);
        paymentProcessRequest.setInvoiceNo(invoiceNo);
        paymentProcessRequest.setActionAmount(actionAmount);
        paymentProcessRequest.setMerchantID(merchantID);

        String hashed = new CodecUtil().hashHMAC(paymentProcessRequest.toHash());
        paymentProcessRequest.setHashValue(hashed);
        String xml = paymentProcessRequest.toXML();
        System.out.println(String.format("xml string is :%s",xml));
        return  new CodecUtil().encodeString(xml);
    }

    public Boolean checkValidity(HashMap<String,String> xmlMap){
        CodecUtil codecService = new CodecUtil();
        String resVersion = xmlMap.get("version") == null ? "" : xmlMap.get("version");
        String resRespCode = xmlMap.get("respCode") == null ? "" : xmlMap.get("respCode");
        String resProcessType = xmlMap.get("processType") == null ? "" : xmlMap.get("processType");
        String resInvoiceNo = xmlMap.get("invoiceNo") == null ? "" : xmlMap.get("invoiceNo");
        String resAmount = xmlMap.get("amount") == null ? "" : xmlMap.get("amount");
        String resStatus = xmlMap.get("status") == null ? "" : xmlMap.get("status");
        String resApprovalCode = xmlMap.get("approvalCode") == null ? "" : xmlMap.get("approvalCode");
        String resReferenceNo = xmlMap.get("referenceNo") == null ? "" : xmlMap.get("referenceNo");
        String resTransactionDateTime = xmlMap.get("transactionDateTime") == null ? "" : xmlMap.get("transactionDateTime");
        String resPaidAgent = xmlMap.get("paidAgent") == null ? "" : xmlMap.get("paidAgent");
        String resPaidChannel = xmlMap.get("paidChannel") == null ? "" : xmlMap.get("paidChannel");
        String resMaskedPan = xmlMap.get("maskedPan") == null ? "" : xmlMap.get("maskedPan");
        String resEci = xmlMap.get("eci") == null ? "" : xmlMap.get("eci");
        String resPaymentScheme = xmlMap.get("paymentScheme") == null ? "" : xmlMap.get("paymentScheme");
        String resProcessBy = xmlMap.get("processBy") == null ? "" : xmlMap.get("processBy");
        String resRefundReferenceNo = xmlMap.get("refundReferenceNo") == null ? "" : xmlMap.get("refundReferenceNo");
        String resUserDefined1 = xmlMap.get("userDefined1") == null ? "" : xmlMap.get("userDefined1");
        String resUserDefined2 = xmlMap.get("userDefined2") == null ? "" : xmlMap.get("userDefined2");
        String resUserDefined3 = xmlMap.get("userDefined3") == null ? "" : xmlMap.get("userDefined3");
        String resUserDefined4 = xmlMap.get("userDefined4") == null ? "" : xmlMap.get("userDefined4");
        String resUserDefined5 = xmlMap.get("userDefined5") == null ? "" : xmlMap.get("userDefined5");

        String newToHash = resVersion + resRespCode + resProcessType + resInvoiceNo + resAmount + resStatus + resApprovalCode + resReferenceNo + resTransactionDateTime + resPaidAgent + resPaidChannel + resMaskedPan + resEci + resPaymentScheme + resProcessBy + resRefundReferenceNo + resUserDefined1 + resUserDefined2 + resUserDefined3 + resUserDefined4 +resUserDefined5;

        String newHashed = codecService.hashHMAC(newToHash);
        return (newHashed.toLowerCase().equals(xmlMap.get("hashValue")) &&
                (xmlMap.get("respCode").equals("00")));

    }

    public HashMap<String,String> decodeMessage (String response){
        String decodedResponse = new CodecUtil().decodeString(response);

        HashMap<String,String> xmlMap = new HashMap<String,String>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(decodedResponse)));
            document.getDocumentElement().normalize();
            NodeList nList = document.getElementsByTagName("*");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (!nNode.getNodeName().equals("PaymentProcessResponse")){
                    xmlMap.put(nNode.getNodeName(), nNode.getTextContent());

                }
            } 
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return xmlMap;
    }
}
