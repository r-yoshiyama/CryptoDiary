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
	private final static int STRETCH = 100;
	private final static String HASH_ALGO = "SHA-256";
	/*
	 *
	 */
	public static String idPassToHash(String id, String pass) {
		SecureRandom rand = new SecureRandom();
		int saltLength = 20;

		String hashText = "";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(HASH_ALGO);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte saltBytes[] = new byte[saltLength/2];
		rand.nextBytes(saltBytes);

		String salt = id + DatatypeConverter.printHexBinary(saltBytes);
		for(int i = 0; i < STRETCH; i++) {
			byte[] result = md.digest(new String(hashText + salt + pass).getBytes());
			hashText = String.format("%040x", new BigInteger(1, result));;
		}
		return "$1" + "$" + salt + "$" + hashText + "\n";
	}

	public static boolean hashChk(String id, String pass, String hashText) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(HASH_ALGO);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		String[] hashList = hashText.split("\\$");
		String salt = hashList[2];
		String chkHash = "";
		for(int i = 0; i < STRETCH; i++) {
			byte[] result = md.digest(new String(chkHash + salt + pass).getBytes());
			chkHash = String.format("%040x", new BigInteger(1, result));;
		}
		return hashList[3].equals(chkHash);
	}
}
