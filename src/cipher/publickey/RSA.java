/**
 *
 */
package cipher.publickey;

/**
 * @author Yopiyama
 *
 */
public class RSA implements PublicKeyCrypto {
	protected int bit;

	public RSA(int bit) {
		// TODO Auto-generated constructor stub
		this.bit = bit;
	}

	@Override
	public String encode(String plainText) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decode(String cipherText) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateKey() {
		// TODO Auto-generated method stub
		System.out.println(this.bit);

		return null;
	}

}
