package io.bigtreelab.rndbox.api.utils;

public class Aes256Test {

	public static void main(String[] args) throws Exception {


		AES256Security aes256 = new AES256Security();
		String text = "!! Hello World !!";


		String cipherText = aes256.encrypt(text);
		System.out.println(text);
		System.out.println(cipherText);
		System.out.println(aes256.decrypt(cipherText));

	}

}

