/**
 *
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import util.DataUtil;
import util.FileUtil;

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
	private JButton loginBtn;
	private JButton backBtn;
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

		loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String user = userId.getText();
				char[] passArray = password.getPassword();
				String pass = String.valueOf(passArray);
				if (inputChk(user, pass) == false || idPassChk(user, pass) == false) {
					password.setText("");
					return;
				} else {
					password.setText("");
					mf.setIdPassToPanels(user, pass);
					mf.setPanel(mf.menuPanel);
				}
			}
		});
		backBtn = new JButton("Go to " + mf.panelNames[0]);
		backBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				mf.setPanel(mf.mainPanel);
			}
		});

		idText.setBounds(xPos, 60, width, height);
		userId.setBounds(xPos, 100, width, height);
		passText.setBounds(xPos, 140, width, height);
		password.setBounds(xPos, 180, width, height);
		loginBtn.setBounds(xPos, 380, width, height);
		backBtn.setBounds(xPos, 500, width, height);

		this.add(idText);
		this.add(userId);
		this.add(passText);
		this.add(password);
		this.add(loginBtn);
		this.add(backBtn);
	}

	protected boolean idPassChk(String id, String pass) {
		String[] data = FileUtil.readFile("./.data/users");
		String[] idList = new String[data.length];
		String[] passList = new String[data.length];
		if(data.length > 0) {
			for(int i = 0; i < data.length; i++) {
				String[] tmp = data[i].split(", ");
				idList[i] = tmp[0];
				passList[i] = tmp[1];
			}
		} else {
			JOptionPane.showMessageDialog(this, "ID can't find.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		List<String> list = Arrays.asList(idList);
		int idIndex = list.indexOf(id);
		if(idIndex == -1) {
			JOptionPane.showMessageDialog(this, "ID can't find.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(!DataUtil.hashChk(id, pass, passList[idIndex])) {
			JOptionPane.showMessageDialog(this, "Password doesen't match.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			return true;
		}

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
