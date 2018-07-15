/**
 *
 */
package cipher;

/**
 * @author Yopiyama
 *
 */
public interface Cryptography {
	/*
	 *
	 */
	int BIT512 = 512;
	int BIT1024 = 1024;
	int BIT2048 = 2048;
	/*
	 *
	 */
	public String encode(String plainText);
	public String decode(String cipherText);
	public int getBit();
	public void setKeys(String[] keys);
	public String[] getKeys();

}
