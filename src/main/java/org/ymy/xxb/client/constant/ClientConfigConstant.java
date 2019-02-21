package org.ymy.xxb.client.constant;

import java.text.SimpleDateFormat;
import java.util.Date;
public class ClientConfigConstant {
	public static final String appId = "2019010100007148";
	public static final String secretKey = "w3T68hHvytgmu2qrwDdrpIHYvJKJwPMau81nc7wNEEZGnq7BwnbOYNZiH5OBdxHBUs461oGiLPbBijXFTBOP1w==";
	public static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCb/Yg7QpGFQYEHIg+CYs0LLh1tntcKOO0OGLukfnTmy9WOaZj0jXKSJN2yLMDgVJUefIWtisjU9g2SEIcglquA+XRfjaXNC3KzNOCl5W1LUaY+tQ8PG4F9uV/5KSOXLxPOJUbxuBGC7cWTO30sG3OJx+swyynkDBYmzys3wo3DwwIDAQAB";
	public static final String charSet = "UTF-8";
	public static final String format = "JSON";
	public static final String signType = "RSA2";
	public static final String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	public static final String salt = String.valueOf((int)(Math.random()*9+1)*1000);
	public static final String version = "1.0";
}
