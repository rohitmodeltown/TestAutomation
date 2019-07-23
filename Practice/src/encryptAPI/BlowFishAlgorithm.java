package encryptAPI;

import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class BlowFishAlgorithm {

	static String IV = "12345678";
	static String key = "3a9af99ad084a3d5";

	public BlowFishAlgorithm() {
	}

// Encryption logic

	public static String Encrypt(String key, String plainText) throws Exception {
		SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "Blowfish");
		Cipher cipher = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");
		cipher.init(1, keySpec, new IvParameterSpec(IV.getBytes()));
		byte[] encoding = cipher.doFinal(plainText.getBytes());
		return new String(java.util.Base64.getEncoder().encode(encoding));
	}

// Decryption logic

	public static String Decrypt(String key, String cipherText) throws Exception {
		SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "Blowfish");
		Cipher cipher = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");
		byte[] cipherTextBytes = java.util.Base64.getDecoder().decode(cipherText);
		cipher.init(2, keySpec, new IvParameterSpec(IV.getBytes()));
		byte[] message = cipher.doFinal(cipherTextBytes);
		return new String(message);
	}

	public static String readFileAsString(String fileName) throws Exception {
		String data = "";
		data = new String(Files.readAllBytes(Paths.get(fileName)));
		return data;
	}

	public static void main(String[] args) throws Exception {

		String request = readFileAsString("D:\\Airtel\\API Specs\\encrypt.txt");

		System.out.println(Encrypt(key, request));

		
		 String request1 = readFileAsString("D:\\Airtel\\API Specs\\decrypt.txt");
		  
		  System.out.println(Decrypt(key, request));
		 
	}
}
