package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
/**
 * PaymentProcessRequest
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-11-22T00:42:30.251Z[GMT]")
public class PaymentProcessRequest {
  @SerializedName("version")
  private String version = null;

  @SerializedName("timeStamp")
  private String timeStamp = null;

  @SerializedName("merchantID")
  private String merchantID = null;

  @SerializedName("processType")
  private String processType = null;

  @SerializedName("invoiceNo")
  private String invoiceNo = null;

  @SerializedName("actionAmount")
  private String actionAmount = null;

  @SerializedName("bankCode")
  private String bankCode = null;

  @SerializedName("accountName")
  private String accountName = null;

  @SerializedName("accountNumber")
  private String accountNumber = null;

  @SerializedName("subMerchantList")
  private List<SubMerchant> subMerchantList = null;

  @SerializedName("notifyURL")
  private String notifyURL = null;

  @SerializedName("hashValue")
  private String hashValue = null;

  public PaymentProcessRequest version(String version) {
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @Schema(required = true, description = "")
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public PaymentProcessRequest timeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
    return this;
  }

   /**
   * Get timeStamp
   * @return timeStamp
  **/
  @Schema(description = "")
  public String getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
  }

  public PaymentProcessRequest merchantID(String merchantID) {
    this.merchantID = merchantID;
    return this;
  }

   /**
   * Get merchantID
   * @return merchantID
  **/
  @Schema(required = true, description = "")
  public String getMerchantID() {
    return merchantID;
  }

  public void setMerchantID(String merchantID) {
    this.merchantID = merchantID;
  }

  public PaymentProcessRequest processType(String processType) {
    this.processType = processType;
    return this;
  }

   /**
   * Get processType
   * @return processType
  **/
  @Schema(required = true, description = "")
  public String getProcessType() {
    return processType;
  }

  public void setProcessType(String processType) {
    this.processType = processType;
  }

  public PaymentProcessRequest invoiceNo(String invoiceNo) {
    this.invoiceNo = invoiceNo;
    return this;
  }

   /**
   * Get invoiceNo
   * @return invoiceNo
  **/
  @Schema(required = true, description = "")
  public String getInvoiceNo() {
    return invoiceNo;
  }

  public void setInvoiceNo(String invoiceNo) {
    this.invoiceNo = invoiceNo;
  }

  public PaymentProcessRequest actionAmount(String actionAmount) {
    this.actionAmount = actionAmount;
    return this;
  }

   /**
   * Get actionAmount
   * @return actionAmount
  **/
  @Schema(description = "")
  public String getActionAmount() {
    return actionAmount;
  }

  public void setActionAmount(String actionAmount) {
    this.actionAmount = actionAmount;
  }

  public PaymentProcessRequest bankCode(String bankCode) {
    this.bankCode = bankCode;
    return this;
  }

   /**
   * Get bankCode
   * @return bankCode
  **/
  @Schema(description = "")
  public String getBankCode() {
    return bankCode;
  }

  public void setBankCode(String bankCode) {
    this.bankCode = bankCode;
  }

  public PaymentProcessRequest accountName(String accountName) {
    this.accountName = accountName;
    return this;
  }

   /**
   * Get accountName
   * @return accountName
  **/
  @Schema(description = "")
  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public PaymentProcessRequest accountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

   /**
   * Get accountNumber
   * @return accountNumber
  **/
  @Schema(description = "")
  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public PaymentProcessRequest subMerchantList(List<SubMerchant> subMerchantList) {
    this.subMerchantList = subMerchantList;
    return this;
  }

  public PaymentProcessRequest addSubMerchantListItem(SubMerchant subMerchantListItem) {
    if (this.subMerchantList == null) {
      this.subMerchantList = new ArrayList<SubMerchant>();
    }
    this.subMerchantList.add(subMerchantListItem);
    return this;
  }

   /**
   * Get subMerchantList
   * @return subMerchantList
  **/
  @Schema(description = "")
  public List<SubMerchant> getSubMerchantList() {
    return subMerchantList;
  }

  public void setSubMerchantList(List<SubMerchant> subMerchantList) {
    this.subMerchantList = subMerchantList;
  }

  public PaymentProcessRequest notifyURL(String notifyURL) {
    this.notifyURL = notifyURL;
    return this;
  }

   /**
   * Get notifyURL
   * @return notifyURL
  **/
  @Schema(description = "")
  public String getNotifyURL() {
    return notifyURL;
  }

  public void setNotifyURL(String notifyURL) {
    this.notifyURL = notifyURL;
  }

  public PaymentProcessRequest hashValue(String hashValue) {
    this.hashValue = hashValue;
    return this;
  }

   /**
   * Get hashValue
   * @return hashValue
  **/
  @Schema(required = true, description = "")
  public String getHashValue() {
    return hashValue;
  }

  public void setHashValue(String hashValue) {
    this.hashValue = hashValue;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentProcessRequest paymentProcessRequest = (PaymentProcessRequest) o;
    return Objects.equals(this.version, paymentProcessRequest.version) &&
        Objects.equals(this.timeStamp, paymentProcessRequest.timeStamp) &&
        Objects.equals(this.merchantID, paymentProcessRequest.merchantID) &&
        Objects.equals(this.processType, paymentProcessRequest.processType) &&
        Objects.equals(this.invoiceNo, paymentProcessRequest.invoiceNo) &&
        Objects.equals(this.actionAmount, paymentProcessRequest.actionAmount) &&
        Objects.equals(this.bankCode, paymentProcessRequest.bankCode) &&
        Objects.equals(this.accountName, paymentProcessRequest.accountName) &&
        Objects.equals(this.accountNumber, paymentProcessRequest.accountNumber) &&
        Objects.equals(this.subMerchantList, paymentProcessRequest.subMerchantList) &&
        Objects.equals(this.notifyURL, paymentProcessRequest.notifyURL) &&
        Objects.equals(this.hashValue, paymentProcessRequest.hashValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(version, timeStamp, merchantID, processType, invoiceNo, actionAmount, bankCode, accountName, accountNumber, subMerchantList, notifyURL, hashValue);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentProcessRequest {\n");
    
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    timeStamp: ").append(toIndentedString(timeStamp)).append("\n");
    sb.append("    merchantID: ").append(toIndentedString(merchantID)).append("\n");
    sb.append("    processType: ").append(toIndentedString(processType)).append("\n");
    sb.append("    invoiceNo: ").append(toIndentedString(invoiceNo)).append("\n");
    sb.append("    actionAmount: ").append(toIndentedString(actionAmount)).append("\n");
    sb.append("    bankCode: ").append(toIndentedString(bankCode)).append("\n");
    sb.append("    accountName: ").append(toIndentedString(accountName)).append("\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    subMerchantList: ").append(toIndentedString(subMerchantList)).append("\n");
    sb.append("    notifyURL: ").append(toIndentedString(notifyURL)).append("\n");
    sb.append("    hashValue: ").append(toIndentedString(hashValue)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  public String toHash(){
    if (processType.equals("R")){
      return version + merchantID + processType + invoiceNo + actionAmount;
    }
    else{
      return version + merchantID + processType + invoiceNo;
    }
  }

  
  public String toXML(){
    StringBuilder sb = new StringBuilder();
    sb.append("<PaymentProcessRequest>");
    if (version != null) sb.append(String.format("<version>%s</version>",version));
    if (timeStamp != null) sb.append(String.format("<timeStamp>%s</timeStamp>",timeStamp));
    if (merchantID != null) sb.append(String.format("<merchantID>%s</merchantID>",merchantID));
    if (processType != null) sb.append(String.format("<processType>%s</processType>",processType));
    if (invoiceNo != null) sb.append(String.format("<invoiceNo>%s</invoiceNo>",invoiceNo));
    if (actionAmount != null && Double.parseDouble(actionAmount) > 0) sb.append(String.format("<actionAmount>%s</actionAmount>",actionAmount));
    if (bankCode != null) sb.append(String.format("<bankCode>%s</bankCode>",bankCode));
    if (accountName != null) sb.append(String.format("<accountName>%s</accountName>",accountName));
    if (accountNumber != null) sb.append(String.format("<accountNumber>%s</accountNumber>",accountNumber));
    if (subMerchantList != null){
      for (SubMerchant subMerchant: subMerchantList){
        sb.append(String.format("<subMerchant subMID=\"%s\" subAmount=\"%s\" />",subMerchant.getSubMID(),subMerchant.getSubAmount()));
      }
    }
    if (notifyURL != null) sb.append(String.format("<notifyURL>%s</notifyURL>",notifyURL));
    if (hashValue != null) sb.append(String.format("<hashValue>%s</hashValue>",hashValue));
    sb.append("</PaymentProcessRequest>");
    
    return sb.toString();
  }




  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
