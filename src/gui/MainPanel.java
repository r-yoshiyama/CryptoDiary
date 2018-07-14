/**
 *
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Yopiyama
 *
 */
public class MainPanel extends JPanel{

	/**
	 *
	 */
	@SuppressWarnings("unused")
	private MainFrame mf;
	private String name;
	private JButton loginBtn;
	private JButton registerBtn;
	private int xPos = 390;
	private int width = 120;
	private int height = 40;
	/*
	 *
	 */
	private static final long serialVersionUID = -2338264669378462369L;


	public MainPanel(MainFrame mf, String name) {
		this.mf = mf;
		this.name = name;

		setLayout(null);

		loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				mf.setPanel(mf.panels[2]);
			}
		});

		registerBtn = new JButton("Register");
		registerBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				mf.setPanel(mf.panels[3]);
			}
		});


		loginBtn.setBounds(xPos, 100, width, height);
		registerBtn.setBounds(xPos, 160, width, height);

		this.add(loginBtn);
		this.add(registerBtn);
	}

	public String getPanelName() {
		return this.name;
	}
}
