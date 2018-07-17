/**
 *
 */
package gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author Yopiyama
 *
 */
public class MyDialog extends JDialog {
	/*
	 *
	 */
	private JLabel label;
	/**
	 *
	 */
	private static final long serialVersionUID = 834508874623678309L;

	public MyDialog(MainFrame mf, boolean modal) {
		// TODO Auto-generated constructor stub
		super(mf, modal);

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		setBounds(450, 300, 200, 100);

	}

	public void setText(String text) {
		label.setText(text);
	}

	public void openDialog() {
		setVisible(true);
		System.out.println("Show Dialog");
	}

	public void closeDialog() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(false);
		System.out.println("Close Dialog");
	}
}
