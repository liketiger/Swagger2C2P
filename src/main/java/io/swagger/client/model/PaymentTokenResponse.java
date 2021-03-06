
package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * PaymentTokenResponse
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-11-19T09:49:57.264Z[GMT]")
public class PaymentTokenResponse {
  @SerializedName("paymentToken")
  private String paymentToken = null;

  @SerializedName("webPaymentUrl")
  private String webPaymentUrl = null;

  @SerializedName("respCode")
  private String respCode = null;

  @SerializedName("respDesc")
  private String respDesc = null;

  public PaymentTokenResponse paymentToken(String paymentToken) {
    this.paymentToken = paymentToken;
    return this;
  }

   /**
   * Get paymentToken
   * @return paymentToken
  **/
  @Schema(description = "")
  public String getPaymentToken() {
    return paymentToken;
  }

  public void setPaymentToken(String paymentToken) {
    this.paymentToken = paymentToken;
  }

  public PaymentTokenResponse webPaymentUrl(String webPaymentUrl) {
    this.webPaymentUrl = webPaymentUrl;
    return this;
  }

   /**
   * Get webPaymentUrl
   * @return webPaymentUrl
  **/
  @Schema(description = "")
  public String getWebPaymentUrl() {
    return webPaymentUrl;
  }

  public void setWebPaymentUrl(String webPaymentUrl) {
    this.webPaymentUrl = webPaymentUrl;
  }

  public PaymentTokenResponse respCode(String respCode) {
    this.respCode = respCode;
    return this;
  }

   /**
   * Get respCode
   * @return respCode
  **/
  @Schema(description = "")
  public String getRespCode() {
    return respCode;
  }

  public void setRespCode(String respCode) {
    this.respCode = respCode;
  }

  public PaymentTokenResponse respDesc(String respDesc) {
    this.respDesc = respDesc;
    return this;
  }

   /**
   * Get respDesc
   * @return respDesc
  **/
  @Schema(description = "")
  public String getRespDesc() {
    return respDesc;
  }

  public void setRespDesc(String respDesc) {
    this.respDesc = respDesc;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentTokenResponse paymentTokenResponse = (PaymentTokenResponse) o;
    return Objects.equals(this.paymentToken, paymentTokenResponse.paymentToken) &&
        Objects.equals(this.webPaymentUrl, paymentTokenResponse.webPaymentUrl) &&
        Objects.equals(this.respCode, paymentTokenResponse.respCode) &&
        Objects.equals(this.respDesc, paymentTokenResponse.respDesc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentToken, webPaymentUrl, respCode, respDesc);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentTokenResponse {\n");
    
    sb.append("    paymentToken: ").append(toIndentedString(paymentToken)).append("\n");
    sb.append("    webPaymentUrl: ").append(toIndentedString(webPaymentUrl)).append("\n");
    sb.append("    respCode: ").append(toIndentedString(respCode)).append("\n");
    sb.append("    respDesc: ").append(toIndentedString(respDesc)).append("\n");
    sb.append("}");
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
