package Util;

import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

public class Encrypt {

	public static String pubKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnsUrIe1pCJLoggVpXwd3GWeoX+Fc6uAYUkPrgrewiXh8995uTPVKzfJAy5ioqFmOfpXKIuaFGd4wS/BraLlHxtM+/qvAkreDKmLaBYqn0p3EaEwKUIPXx4LATA9Uip3WZMmZ08ToHwJY8pCkDqWLyHJt45f6j2WLPwom45e+bO7UvUv1lhSxWCNuD8KbwPrhwKUOiY5PL+PSMgSyMnTVOMQICF5X8JSRFzTdwbNls/LFrDqBOxjj26QvL2oo9IYWsClrfupILFl5M6exxY2QATqF8En/LnD4eiow1I4Wt8scYmvplS22Upbwartf/9MB0gufXriA2vEl+QaB+j46OQIDAQAB";
	static String transformation = "RSA/ECB/PKCS1Padding";
	public static final String RSA = "RSA";
	public static final String UTF8 = "UTF-8";

	public static String[] encrypt(String data) {
		try {
			String secretKey = UUID.randomUUID().toString().substring(0, 24);
			String encryptedData = tripleDES(data, secretKey);
			String encryptedKey = encryptKey(secretKey);
			return new String[] { encryptedData, encryptedKey };
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String[] simpleEncrypt(String data) throws Exception {
		try {
			String secretKey = UUID.randomUUID().toString().substring(0, 24);
			String encryptedData = des(data, secretKey);
			String encryptedTime = des(String.valueOf(System.currentTimeMillis()), secretKey);
			String encryptedKey = encryptKey(secretKey);
			return new String[] { encryptedData, encryptedKey, encryptedTime };
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static String encryptKey(String key) throws Exception {
		byte[] publicKey = Base64.decodeBase64(pubKey);
		Cipher cipher = Cipher.getInstance(transformation);
		cipher.init(Cipher.ENCRYPT_MODE, KeyFactory.getInstance(RSA).generatePublic(new X509EncodedKeySpec(publicKey)));
		return Base64.encodeBase64String(cipher.doFinal(key.getBytes(UTF8))).trim().replaceAll(" ", "").replaceAll("\r\n", "");
	}

	public static String tripleDES(String data, String phrase) throws Exception {
		if (StringUtils.isBlank(data)) return null;
		byte[] passPhrase = new byte[24];
		if (phrase == null) {
			new Random().nextBytes(passPhrase);
		} else {
			System.arraycopy(phrase.getBytes(), 0, passPhrase, 0, 24);
		}
		DESedeKeySpec keySpec = new DESedeKeySpec(passPhrase);
		SecretKey key = SecretKeyFactory.getInstance("DESede").generateSecret(keySpec);
		Cipher ecipher = Cipher.getInstance(key.getAlgorithm());
		ecipher.init(1, key);
		return Base64.encodeBase64String(ecipher.doFinal(data.getBytes("UTF8"))).trim().replaceAll(" ", "").replaceAll("\r\n", "");
	}

	private static String des(String str, String passPhrase) throws Exception {
		byte[] salt = { (byte) 0xA8, (byte) 0x9B, (byte) 0xC8, (byte) 0x32, (byte) 0x56, (byte) 0x34, (byte) 0xE3, (byte) 0x03 };
		int iterationCount = 20;
		KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), salt, iterationCount);
		SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
		Cipher ecipher = Cipher.getInstance(key.getAlgorithm());
		AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);
		ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
		return Base64.encodeBase64String(ecipher.doFinal(str.getBytes("UTF8"))).trim().replaceAll(" ", "").replaceAll("\r\n", "");
	}
	
	    public  String generateSha512Hash(String message) throws NoSuchAlgorithmException {
	        MessageDigest md;
	        String out = "";
	        try {
	            md= MessageDigest.getInstance("SHA-512");

	            md.update(message.getBytes());
	            byte[] mb = md.digest();
	            for (int i = 0; i < mb.length; i++) {
	                byte temp = mb[i];
	                String s = Integer.toHexString(new Byte(temp));
	                while (s.length() < 2) {
	                    s = "0" + s;
	                }
	                s = s.substring(s.length() - 2);
	                out += s;
	            }
	            System.out.println(out.length());
	            System.out.println("CRYPTO: " + out);

	        } catch (NoSuchAlgorithmException e) {
	            System.out.println("ERROR: " + e.getMessage());
	        }
	        return out;
	}
	
}
