package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Information regarding payment code
 */
@Schema(description = "Information regarding payment code")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-11-21T23:50:31.361Z[GMT]")
public class PaymentRequestPaymentCode {
  @SerializedName("channelCode")
  private String channelCode = null;

  @SerializedName("agentCode")
  private String agentCode = null;

  @SerializedName("agentChannelCode")
  private String agentChannelCode = null;

  public PaymentRequestPaymentCode channelCode(String channelCode) {
    this.channelCode = channelCode;
    return this;
  }

   /**
   * Mandatory / Alpha-Numeric 10 / Payment Channel Code (Refer to Channel Matrix)
   * @return channelCode
  **/
  @Schema(required = true, description = "Mandatory / Alpha-Numeric 10 / Payment Channel Code (Refer to Channel Matrix)")
  public String getChannelCode() {
    return channelCode;
  }

  public void setChannelCode(String channelCode) {
    this.channelCode = channelCode;
  }

  public PaymentRequestPaymentCode agentCode(String agentCode) {
    this.agentCode = agentCode;
    return this;
  }

   /**
   * Conditional / Character 10 / Agent&#x27;s Code
   * @return agentCode
  **/
  @Schema(description = "Conditional / Character 10 / Agent's Code")
  public String getAgentCode() {
    return agentCode;
  }

  public void setAgentCode(String agentCode) {
    this.agentCode = agentCode;
  }

  public PaymentRequestPaymentCode agentChannelCode(String agentChannelCode) {
    this.agentChannelCode = agentChannelCode;
    return this;
  }

   /**
   * Conditional / Character 10 / Agent&#x27;s Channel Code
   * @return agentChannelCode
  **/
  @Schema(description = "Conditional / Character 10 / Agent's Channel Code")
  public String getAgentChannelCode() {
    return agentChannelCode;
  }

  public void setAgentChannelCode(String agentChannelCode) {
    this.agentChannelCode = agentChannelCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentRequestPaymentCode paymentRequestPaymentCode = (PaymentRequestPaymentCode) o;
    return Objects.equals(this.channelCode, paymentRequestPaymentCode.channelCode) &&
        Objects.equals(this.agentCode, paymentRequestPaymentCode.agentCode) &&
        Objects.equals(this.agentChannelCode, paymentRequestPaymentCode.agentChannelCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channelCode, agentCode, agentChannelCode);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentRequestPaymentCode {\n");
    
    sb.append("    channelCode: ").append(toIndentedString(channelCode)).append("\n");
    sb.append("    agentCode: ").append(toIndentedString(agentCode)).append("\n");
    sb.append("    agentChannelCode: ").append(toIndentedString(agentChannelCode)).append("\n");
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
