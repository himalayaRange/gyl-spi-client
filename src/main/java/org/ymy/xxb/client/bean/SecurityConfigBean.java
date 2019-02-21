package org.ymy.xxb.client.bean;

import java.io.Serializable;
public class SecurityConfigBean extends SecurityConfigMechantBean implements Serializable{
	private static final long serialVersionUID = -6474077990563871477L;
	// 商户ID
	private String appId;
	// 商户秘钥
	private String secretKey;
	// 加密解密公钥
	private String publicKey;
	// 加密解密私钥
	private String privateKey;
	// 编码
	private String charSet;
	// 支持格式
	private String format;
	// 签名类型
	private String signType;
	// 签名字符串
	private String sign;
	// 时间戳，用于bizContent验签 yyyy-MM-dd HH:mm:ss
	private String timestamp;
	// 盐值，4位的随机数，也进行验签
	private String salt;
	// 版本号
	private String version;
	// 交易内容
	private String bizContent;

	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	public String getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
	public String getPrivateKey() {
		return privateKey;
	}
	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}
	
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getCharSet() {
		return charSet;
	}
	public void setCharSet(String charSet) {
		this.charSet = charSet;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getSignType() {
		return signType;
	}
	public void setSignType(String signType) {
		this.signType = signType;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getBizContent() {
		return bizContent;
	}
	public void setBizContent(String bizContent) {
		this.bizContent = bizContent;
	}

	@Override
	public String toString() {
		return "SecurityConfigBean [appId=" + appId + ", secretKey=" + secretKey + ", publicKey=" + publicKey
				+ ", privateKey=" + privateKey + ", charSet=" + charSet + ", format=" + format + ", signType="
				+ signType + ", sign=" + sign + ", timestamp=" + timestamp + ", salt=" + salt + ", version=" + version
				+ ", bizContent=" + bizContent + "]";
	}
	
	
}
