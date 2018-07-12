/**
 *
 */
package util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.xml.bind.DatatypeConverter;

/**
 * @author Yopiyama
 *
 */
public class DataUtil {
	/*
	 *
	 */

	/*
	 *
	 */
	public static String idPassToHash(String id, String pass) {
		SecureRandom rand = new SecureRandom();
		int saltLength = 20;
		int stretch = 2;
		String hashText = "";
		String returnText = "";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		byte saltBytes[] = new byte[saltLength/2];
		rand.nextBytes(saltBytes);

		String salt = id + DatatypeConverter.printHexBinary(saltBytes);
		for(int i = 0; i < stretch; i++) {
			byte[] result = md.digest(new String(hashText + salt + pass).getBytes());
			hashText = String.format("%040x", new BigInteger(1, result));;
		}
		returnText = "$?" + "$" + salt + "$" + hashText;
		return returnText;
	}
}
