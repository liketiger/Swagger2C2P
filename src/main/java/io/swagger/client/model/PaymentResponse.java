package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * PaymentResponse
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-11-19T10:50:59.400Z[GMT]")
public class PaymentResponse {
  @SerializedName("channelCode")
  private String channelCode = null;

  @SerializedName("data")
  private String data = null;

  @SerializedName("respCode")
  private String respCode = null;

  @SerializedName("respDesc")
  private String respDesc = null;

  public PaymentResponse channelCode(String channelCode) {
    this.channelCode = channelCode;
    return this;
  }

   /**
   * Get channelCode
   * @return channelCode
  **/
  @Schema(description = "")
  public String getChannelCode() {
    return channelCode;
  }

  public void setChannelCode(String channelCode) {
    this.channelCode = channelCode;
  }

  public PaymentResponse data(String data) {
    this.data = data;
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @Schema(description = "")
  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public PaymentResponse respCode(String respCode) {
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

  public PaymentResponse respDesc(String respDesc) {
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
    PaymentResponse paymentResponse = (PaymentResponse) o;
    return Objects.equals(this.channelCode, paymentResponse.channelCode) &&
        Objects.equals(this.data, paymentResponse.data) &&
        Objects.equals(this.respCode, paymentResponse.respCode) &&
        Objects.equals(this.respDesc, paymentResponse.respDesc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channelCode, data, respCode, respDesc);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentResponse {\n");
    
    sb.append("    channelCode: ").append(toIndentedString(channelCode)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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
