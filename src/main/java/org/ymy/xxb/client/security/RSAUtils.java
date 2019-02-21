package org.ymy.xxb.client.security;

import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.apache.commons.codec.binary.Base64;
public class RSAUtils {

	private static final int MAX_ENCRYPT_BLOCK = 117;

	private static final String KEY_ALGORITHM = "RSA";
	
	final static Base64 base64 = new Base64();

	public static String encryptByPublicKey(String data,String publicKey) throws Exception {
		return encryptByPublicKey(data, publicKey, "RSA/ECB/PKCS1Padding");
	}
	
	public static String encryptByPublicKey(String data,String publicKey,String fillMode) throws Exception {
		byte[] dataByte = data.getBytes();
		byte[] keyBytes = base64.decode(publicKey);
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicK = keyFactory.generatePublic(x509KeySpec);
		Cipher cipher = Cipher.getInstance(fillMode);
		cipher.init(Cipher.ENCRYPT_MODE, publicK);
		int inputLen = dataByte.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
				cache = cipher.doFinal(dataByte, offSet, MAX_ENCRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(dataByte, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_ENCRYPT_BLOCK;
		}
		byte[] encryptedData = out.toByteArray();
		out.close();
		return base64.encodeToString(encryptedData);
	}

}