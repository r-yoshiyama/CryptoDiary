/**
 *
 */
package OriginalMath;

import java.math.BigInteger;

/**
 * @author Yopiyama
 *
 */
public class General {

	final static BigInteger ZERO = BigInteger.ZERO;
	final static BigInteger ONE = BigInteger.ONE;
	final static BigInteger TWO = new BigInteger("2");

	/**
	 *
	 */
	public General() {
		// TODO Auto-generated constructor stub
	}

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
}