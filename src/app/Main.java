/**
 *
 */
package app;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import cipher.PrimeProcessor;

/**
 * @author Yopiyama
 *
 */
public class Main {

	/**
	 *
	 */
	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Test
		System.out.println(PrimeProcessor.generatePrime(2048));

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// window size
				frame.setSize(400, 300);
				AppPanel panel = new AppPanel();
				frame.getContentPane().add(panel);
				frame.setVisible(true);
			}
		});
	}
}
