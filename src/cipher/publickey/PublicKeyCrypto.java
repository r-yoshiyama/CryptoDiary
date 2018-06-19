/**
 *
 */
package cipher.publickey;

import cipher.Cryptography;

/**
 * @author Yopiyama
 *
 */
public interface PublicKeyCrypto extends Cryptography {
	String[] generateKey();
}
