/**
 *
 */
package OriginalMath;

import java.math.BigInteger;
import java.util.Random;

/**
 * @author Yopiyama
 *
 */
public class General {

	final static BigInteger ZERO = BigInteger.ZERO;
	final static BigInteger ONE = BigInteger.ONE;
	final static BigInteger TWO = new BigInteger("2");

	/** ExEuclid(a, b)
	 * a * x + b * y = gcd(a,b)
	 * return y
	 */
	public static BigInteger exEuclid(BigInteger a, BigInteger b) {
		BigInteger r0 = a, x0 = ONE, y0 = ZERO;
		BigInteger r1 = b, x1 = ZERO, y1 = ONE;
		BigInteger r2, x2, y2, s0;

		while(!r1.equals(ZERO)) {
			r2 = r0.mod(r1);
			s0 = r0.divide(r1);
			x2 = x0.subtract(s0.multiply(x1));
			y2 = y0.subtract(s0.multiply(y1));
			r0 = r1;
			r1 = r2;
			x0 = x1;
			x1 = x2;
			y0 = y1;
			y1 = y2;
		}
		return y0.mod(a);
	}


	/**
	 * randint method return random number.
	 * range is 1 to n - 1.
	 */
	public static BigInteger randint(BigInteger n) {
		Random rand = new Random();
		BigInteger a = new BigInteger(n.bitLength(), rand).add(Prime.ONE);
		if(a.compareTo(n.subtract(Prime.ONE)) == 1) {
			a = a.subtract(n);
		}
		return a;
	}
}
