package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.client.model.PaymentRequestPayment;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;

/**
 * PaymentActionRequest
 */

public class PaymentActionRequest {
    @SerializedName("invoiceNo")
    private String invoiceNo = null;

    @SerializedName("version")
    private String version = null;

    @SerializedName("processType")
    private String processType = null;

    @SerializedName("merchantID")
    private String merchantID = null;

    @SerializedName("actionAmount")
    private String actionAmount = "0.00";


    public PaymentActionRequest invoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
        return this;
    }
    /**
     * Get invoiceNo
     * @return invoiceNo
     **/
    @Schema(required = true,description ="")
    public String getInvoiceNo(){
        return invoiceNo;
    }
    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public PaymentActionRequest version(String version) {
        this.version = version;
        return this;
    }
    /**
     * Get version
     * @return version
     **/
    @Schema(required = true,description ="")
    public String getVersion(){
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }

    public PaymentActionRequest processType(String processType) {
        this.processType = processType;
        return this;
    }
    /**
     * Get processType
     * @return processType
     **/
    @Schema(required = true,description ="")
    public String getProcessType(){
        return processType;
    }
    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public PaymentActionRequest merchantID(String merchantID) {
        this.merchantID = merchantID;
        return this;
    }
    /**
     * Get merchantID
     * @return merchantID
     **/
    @Schema(required = true,description ="")
    public String getMerchantID(){
        return merchantID;
    }
    public void setMerchantID(String merchantID) {
        this.merchantID = merchantID;
    }

    
    public PaymentActionRequest actionAmount(String actionAmount) {
        this.actionAmount = actionAmount;
        return this;
    }
    /**
     * Get actionAmount
     * @return actionAmount
     **/
    @Schema(required = true,description ="")
    public String getActionAmount(){
        return actionAmount;
    }
    public void setActionAmount(String actionAmount) {
        this.actionAmount = actionAmount;
    }

    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      PaymentActionRequest paymentActionRequest = (PaymentActionRequest) o;
      return Objects.equals(this.invoiceNo, paymentActionRequest.invoiceNo) &&
          Objects.equals(this.version, paymentActionRequest.version) &&
          Objects.equals(this.processType, paymentActionRequest.processType) &&
          Objects.equals(this.merchantID, paymentActionRequest.merchantID) &&
          Objects.equals(this.actionAmount, paymentActionRequest.actionAmount);
    }


    @Override
    public int hashCode() {
      return Objects.hash(invoiceNo, version, processType, merchantID, actionAmount);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PaymentActionRequest {\n");
      
      sb.append("    invoiceNo: ").append(toIndentedString(invoiceNo)).append("\n");
      sb.append("    version: ").append(toIndentedString(version)).append("\n");
      sb.append("    processType: ").append(toIndentedString(processType)).append("\n");
      sb.append("    merchantID: ").append(toIndentedString(merchantID)).append("\n");
      sb.append("    actionAmount: ").append(toIndentedString(actionAmount)).append("\n");
      sb.append("}");
      return sb.toString();
    }

    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
          return "null";
        }
        return o.toString().replace("\n", "\n    ");
      }
  

}
    


  