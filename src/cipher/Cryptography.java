/**
 *
 */
package cipher;

/**
 * @author Yopiyama
 *
 */
public interface Cryptography {
	String encode(String plainText);
	String decode(String cipherText);
}
