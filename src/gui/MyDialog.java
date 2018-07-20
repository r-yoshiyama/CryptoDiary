/**
 *
 */
package gui;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Yopiyama
 *
 */
public class MyDialog extends JDialog {
	/*
	 *
	 */
	private MainFrame mf;
	private JLabel label;
	private JPanel panel;
	/**
	 *
	 */
	private static final long serialVersionUID = 834508874623678309L;

	public MyDialog(MainFrame mf, boolean modal) {
		super(mf, modal);
		this.mf = mf;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

//		getContentPane().setLayout(null);
		label = new JLabel("");
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setBounds(0, 0, 120, 40);
		panel = new JPanel();
		panel.setLayout(null);
		panel.add(label);
		getContentPane().add(panel, BorderLayout.CENTER);

		setBounds(450, 300, 200, 100);

	}

	public void setText(String text) {
		label.setText(text);
	}

	public void openDialog(String title, String text) {
		setTitle(title);
		label.setText(text);
		panel.setVisible(true);
		setVisible(true);
		System.out.println("Show Dialog");
	}

	public void closeDialog() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panel.setVisible(false);
		setVisible(false);
		System.out.println("Close Dialog");
	}
}
