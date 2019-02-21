package org.ymy.xxb.client.factory;

import java.util.HashMap;
import java.util.Map;
import org.ymy.xxb.client.bean.FactoryBean;
import org.ymy.xxb.client.constant.ClientConfigConstant;
import org.ymy.xxb.client.security.RSAUtils;
import org.ymy.xxb.client.support.SpiClientSupport;
import com.alibaba.fastjson.JSON;

public class YmySpiClientFactory implements SpiClientFactory{
	
	@Override
	public SpiClient configuration(String requestURL, Map<String, Object> request, String accessToken) {
		String appId = ClientConfigConstant.appId;
		String secretKey = ClientConfigConstant.secretKey;
		String publicKey = ClientConfigConstant.publicKey;
		String charSet = ClientConfigConstant.charSet;
		String format = ClientConfigConstant.format;
		String signType = ClientConfigConstant.signType;
		String timestamp = ClientConfigConstant.timestamp;
		String salt = ClientConfigConstant.salt;
		String version = ClientConfigConstant.version;
		String buildSignOriginal = buildSignOriginal(appId, salt, timestamp, JSON.toJSONString(request));
		String sign = signOriginalEncrypt(buildSignOriginal, publicKey);
		Map<String,String> params = new HashMap<String,String>();
		params.put("appId", appId);
		params.put("secretKey", secretKey);
		params.put("charSet", charSet);
		params.put("format", format);
		params.put("signType", signType);
		params.put("timestamp", timestamp);
		params.put("salt", salt);
		params.put("version", version);
		params.put("bizContent", JSON.toJSONString(request)); // bizContent不允许为null,否则会提示授权失败，因为这个参数统一通过JSON.toJSONString获取
		params.put("sign", sign);
		FactoryBean factoryBean = new FactoryBean(requestURL, accessToken, params);
		return new SpiClientSupport(factoryBean);
	}
	
    
	public static String buildSignOriginal(String appId , String salt , String timestamp , String biz) {
		StringBuffer signOriginal = new StringBuffer();
		signOriginal = signOriginal.append("appId=").append(appId)
				.append("&salt=").append(salt)
				.append("&timestamp=").append(timestamp)
				.append("&biz=").append(biz);
		
		return signOriginal.toString();
	}
	
	public static String signOriginalEncrypt(String original , String publicKey) {
		try {
			String encryptByPublicKey = RSAUtils.encryptByPublicKey(original, publicKey);
			return encryptByPublicKey;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
