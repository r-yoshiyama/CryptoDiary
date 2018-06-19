/**
 *
 */
package cipher.sharedkey;

import cipher.Cryptography;

/**
 * @author Yopiyama
 *
 */
public interface SharedKeyCrypto extends Cryptography{
	void generateKey(String code);
}
