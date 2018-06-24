/**
 *
 */
package cipher;

/**
 * @author Yopiyama
 *
 */
public interface Cryptography {
	public String encode(String plainText);
	public String decode(String cipherText);
	public int getBit();
	public void setKey(String[] keys);

}
