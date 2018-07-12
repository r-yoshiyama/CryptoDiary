/**
 *
 */
package gui;

import util.DataUtil;

/**
 * @author Yopiyama
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Test
//		String[] text =  {"This is test text.", "Hello"};
//		FileUtil.writeFile("test.txt", text);
//		String[] str = FileUtil.readFile("test.txt");
//		for(int i = 0; i < str.length; i++) System.out.println(str[i]);
//
//		String plainText = "This is Test Message.";
//		RSA rsa = new RSA(512);
//		rsa.generateKey();
//		String cipherText = rsa.encode(plainText);
//		String decodeText = rsa.decode(cipherText);
//		System.out.println("\n" + plainText + "\n\n" + cipherText + "\n\n" + decodeText);
		System.out.println(DataUtil.idPassToHash("test", "pass"));
//		new MainFrame();
	}
}
