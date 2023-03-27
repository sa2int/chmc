package io.bigtreelab.rndbox.api.utils;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AES256Security {

	@Value("${spring.aes.alg}")
	private String alg;
	@Value("${spring.aes.key}")
	private String key;

	public String encrypt(String text) throws Exception {
		Cipher cipher = Cipher.getInstance(alg);
		String iv = key.substring(0, 16);
		SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
		IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);

		byte[] encrypted = cipher.doFinal(text.getBytes("UTF-8"));
		return Base64.getEncoder().encodeToString(encrypted);
	}

	public String decrypt(String cipherText) throws Exception {
		Cipher cipher = Cipher.getInstance(alg);
		String iv = key.substring(0, 16);
		SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
		IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParamSpec);

		byte[] decodedBytes = Base64.getDecoder().decode(cipherText);
		byte[] decrypted = cipher.doFinal(decodedBytes);
		return new String(decrypted, "UTF-8");
	}

}
