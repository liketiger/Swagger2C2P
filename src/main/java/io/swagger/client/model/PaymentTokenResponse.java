/*
 * 2c2p API
 * API implementation
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * PaymentTokenResponse
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-11-18T05:35:09.941Z[GMT]")
public class PaymentTokenResponse {
  @SerializedName("payload")
  private String payload = null;

  @SerializedName("respCode")
  private String respCode = null;

  @SerializedName("respDesc")
  private String respDesc = null;

  public PaymentTokenResponse payload(String payload) {
    this.payload = payload;
    return this;
  }

   /**
   * Get payload
   * @return payload
  **/
  @Schema(description = "")
  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
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
    return Objects.equals(this.payload, paymentTokenResponse.payload) &&
        Objects.equals(this.respCode, paymentTokenResponse.respCode) &&
        Objects.equals(this.respDesc, paymentTokenResponse.respDesc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(payload, respCode, respDesc);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentTokenResponse {\n");
    
    sb.append("    payload: ").append(toIndentedString(payload)).append("\n");
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
