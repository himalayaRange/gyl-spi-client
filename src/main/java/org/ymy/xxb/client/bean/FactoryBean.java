package org.ymy.xxb.client.bean;

import java.io.Serializable;
import java.util.Map;
/**
 * @author wangyi
 * @date 2019-1-6
 */
public class FactoryBean implements Serializable{
	
	private static final long serialVersionUID = 3747529765188766618L;

	private String requestURL;
	
	private String accessToken;
	
	private Map<String,String> params;

	public FactoryBean(String requestURL, String accessToken, Map<String, String> params) {
		super();
		this.requestURL = requestURL;
		this.accessToken = accessToken;
		this.params = params;
	}

	public String getRequestURL() {
		return requestURL;
	}

	public void setRequestURL(String requestURL) {
		this.requestURL = requestURL;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "FactoryBean [requestURL=" + requestURL + ", accessToken=" + accessToken + ", params=" + params + "]";
	}
	
	
}
