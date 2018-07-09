/**
 *
 */
package OriginalMath;

import java.math.BigInteger;
import java.util.Random;

/**
 * @author Yopiyama
 * method: isPrime(BigInteger, int)
 *       : generatePrime(int)
 *       : randint(BigInteger)
 */
public class Prime {

	final static BigInteger ZERO = BigInteger.ZERO;
	final static BigInteger ONE = BigInteger.ONE;
	final static BigInteger TWO = new BigInteger("2");

	/**
	 *
	 */

	/**
	 * This method is Miller-Rabin primality test.
	 * isPrime requires target number (num) and parameter (k).
	 */
	@SuppressWarnings("unlikely-arg-type")
	public static boolean isPrime(BigInteger num, int k) {
		BigInteger d, a, t, x;

		if (num.equals(2)) {
			return true;
		}else if(num.compareTo(ONE) == -1 || num.and(ONE).equals(ZERO)) {
			return false;
		}

		d = num.subtract(ONE).shiftRight(1);
		while(d.and(ONE).equals(ZERO)) {
			d = d.shiftRight(1);
		}

		for(int i = 0; i < k; i++) {
			a = General.randint(num);
			t = d;
			x = a.modPow(t, num);

			while(!t.equals(num.subtract(ONE)) && !x.equals(ONE) && !x.equals(num.subtract(ONE))) {
				x = x.modPow(x, num);
				t = t.shiftLeft(1);
			}

			if(!x.equals(num.subtract(ONE)) && t.and(ONE).equals(ZERO)) {
				return false;
			}
		}
		return true;

	}


	/**
	 * generatePrime method return (probably)Prime number.
	 */
	public static BigInteger generatePrime(int bit) {
		Random rand = new Random();
		int l = 10;
		BigInteger a;
		BigInteger b = new BigInteger(bit-l-1, rand).subtract(ONE);
		BigInteger p = new BigInteger("4");

		while (!isPrime(p, 30)){
			a = new BigInteger(l, rand).subtract(ONE);
			p = TWO.pow(bit-1).multiply(a).add(TWO.multiply(b)).add(ONE);
		}
		return p;

	}

}
