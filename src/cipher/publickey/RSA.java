/**
 *
 */
package cipher.publickey;


import java.math.BigInteger;

import OriginalMath.General;
import OriginalMath.Prime;

/**
 * @author Yopiyama
 *
 */
public class RSA implements PublicKeyCrypto {

	private int bit;
	private BigInteger N;
	private BigInteger e;
	private BigInteger d;

	final static BigInteger ZERO = BigInteger.ZERO;
	final static BigInteger ONE = BigInteger.ONE;
	final static BigInteger TWO = new BigInteger("2");

	public RSA(int bit) {
		this.bit = bit;
	}

	@Override
	public String encode(String plainText) {
		BigInteger m = new BigInteger(plainText.getBytes());
		BigInteger c = m.modPow(this.e, this.N);
		return new String(c.toString(16));
	}

	@Override
	public String decode(String cipherText) {
		BigInteger c = new BigInteger(cipherText, 16);
		BigInteger m = c.modPow(this.d, this.N);
		return new String(m.toByteArray());
	}


	/*
	 * generateKey method.
	 * return {N, e, d}
	 */
	@Override
	public String[] generateKey() {
		BigInteger p, q, phi;

		System.out.println("generateKey method started. Key Size is " + this.bit + " bit.\n");
		System.out.println("Generate two big prime number p & q.");
		p = Prime.generatePrime(this.bit);
		q = Prime.generatePrime(this.bit);

		System.out.println("\nCalculation N = p * q and phi = (p-1) * (q-1).\ne is 65537(0x10001).");
		this.N = p.multiply(q);
		phi = p.subtract(ONE).multiply(q.subtract(ONE));

		this.e = new BigInteger("10001", 16);

		System.out.println("\nCalculation d (e * d = 1 mod phi).\n");
		this.d = General.exEuclid(phi, this.e);
//		System.out.println("e.modInverse(phi).equals(d) = " + this.e.modInverse(phi).equals(d));

		System.out.println("\nGenerating keys are complete.");

		System.out.println("Public Key N is " + this.N.toString(16));
		System.out.println("Public Key e is " + this.e.toString(16));
		System.out.println("Secret Key d is " + this.d.toString(16));

		return new String[] {this.N.toString(16), this.e.toString(16)};
	}


	@Override
	public int getBit() {
		return this.bit;
	}

	/*
	 * (non-Javadoc)
	 * @see cipher.Cryptography#setKey(java.lang.String[])
	 * setKey({N, e, d});
	 */
	@Override
	public void setKey(String[] keys) {
		this.N = new BigInteger(keys[0]);
		this.e = new BigInteger(keys[1]);
		this.d = new BigInteger(keys[2]);

	}

}
