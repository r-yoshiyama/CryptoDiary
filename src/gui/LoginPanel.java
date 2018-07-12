/**
 *
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author Yopiyama
 *
 */
public class LoginPanel extends JPanel{
	/*
	 *
	 */
	@SuppressWarnings("unused")
	private MainFrame mf;
	private String name;
	private JButton btn;
	private JLabel idText;
	private JTextField userId;
	private JLabel passText;
	private JPasswordField password;
	private int xPos = 390;
	private int width = 120;
	private int height = 40;

	/**
	 *
	 */
	private static final long serialVersionUID = -6208210502987410541L;

	/*
	 *
	 */
	public LoginPanel(MainFrame mf, String name) {
		this.mf = mf;
		this.name = name;

		setLayout(null);

		idText = new JLabel("ID");
		userId = new JTextField("");
		passText = new JLabel("Password");
		password = new JPasswordField("");

		btn = new JButton("Login");
		btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String user = userId.getText();
				char[] passArray = password.getPassword();
				String pass = String.valueOf(passArray);
				boolean chk = inputChk(user, pass);
				if (chk == false) {
					password.setText("");
					return;
				} else {
					mf.setPanel(mf.panels[0]);
				}
			}
		});
		idText.setBounds(xPos, 60, width, height);
		userId.setBounds(xPos, 100, width, height);
		passText.setBounds(xPos, 140, width, height);
		password.setBounds(xPos, 180, width, height);
		btn.setBounds(xPos, 300, width, height);

		this.add(idText);
		this.add(userId);
		this.add(passText);
		this.add(password);
		this.add(btn);
	}


	protected boolean inputChk(String id, String pass) {
		boolean flag = true;
		if("".equals(id)) {
			JOptionPane.showMessageDialog(this, "ID is required", "Error", JOptionPane.ERROR_MESSAGE);
			flag = false;
		}
		if("".equals(pass)) {
			JOptionPane.showMessageDialog(this, "Password is required", "Error", JOptionPane.ERROR_MESSAGE);
			flag = false;
		}
		return flag;
	}


	public String getPanelName() {
		return this.name;
	}
}
