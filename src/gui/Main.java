/**
 *
 */
package gui;

import cipher.publickey.RSA;

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
		String plainText = "This is Test Message.";

		RSA rsa = new RSA(2048);
		rsa.generateKey();
		String cipherText = rsa.encode(plainText);
		String decodeText = rsa.decode(cipherText);

		System.out.println("\n" + plainText + "\n\n" + cipherText + "\n\n" + decodeText);

//		SwingUtilities.invokeLater(new Runnable() {
//			@Override
//			public void run() {
//				JFrame frame = new JFrame();
//				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				// window size
//				frame.setSize(400, 300);
//				AppPanel panel = new AppPanel();
//				frame.getContentPane().add(panel);
//				frame.setVisible(true);
//			}
//		});
	}
}
