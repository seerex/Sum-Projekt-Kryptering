package model;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionString {
	public static String encryptWithKey(String text, String key) {
		// Create key and cipher
		SecretKeySpec aesKey = new SecretKeySpec(key.getBytes(), "AES");
		Cipher cipher;
		
		// Encrypt the String given in
		try {
			cipher = Cipher.getInstance("AES");
			
			// Encrypt
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
			byte[] encrypted = cipher.doFinal(text.getBytes());
			
			// Return as a string
			return new String(encrypted);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	
	public static String decryptWithKey(String encryptedText, String key) {
		// Create key and cipher
		SecretKeySpec aesKey = new SecretKeySpec(key.getBytes(), "AES");
		Cipher cipher;
				
		try {
			 cipher = Cipher.getInstance("AES");
			 
			 // Decrypt
			 cipher.init(Cipher.DECRYPT_MODE, aesKey);
			 String decrypted = new String(cipher.doFinal(encryptedText.getBytes()));
			 
			 return decrypted;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
}
