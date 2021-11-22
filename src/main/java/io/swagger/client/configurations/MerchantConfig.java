package io.swagger.client.configurations;

import java.util.Properties;

public class MerchantConfig {

    private Properties props;
    
    /***
	 * merchant ID
	 */
	private String merchantID;

    /***
	 * The secret key
	 */
	private String secretKey;

    /***
	 * Base URL
	 */
	private String baseUrl;


	public MerchantConfig(Properties _props) throws ConfigException {
		if (_props != null) {
			this.setProps(_props);
			setMerchantDetails();
		}
	}

    public void setMerchantDetails() throws ConfigException {
        if (this.getProps().getProperty("merchantID") == null) {
            throw new ConfigException("Merchant Id is mandatory");
        }
        this.setMerchantID(this.getProps().getProperty("merchantID").trim());

        if (this.getProps().getProperty("secretKey") == null) {
            throw new ConfigException("Secret Key is mandatory");
        }
        this.setSecretKey(this.getProps().getProperty("secretKey").trim());

        if (this.getProps().getProperty("baseUrl") == null) {
            throw new ConfigException("baseUrl is mandatory");
        }
        this.setBaseUrl(this.getProps().getProperty("baseUrl").trim());
             
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public String getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(String merchantID) {
        this.merchantID = merchantID;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
  
    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
  
}
