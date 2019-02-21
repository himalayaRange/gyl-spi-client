package org.ymy.xxb.client.factory;

import java.util.Map;

public interface SpiClientFactory {

	public SpiClient configuration(String requestURL , Map<String,Object> request , String accessToken);
	
}
