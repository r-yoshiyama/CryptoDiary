/**
 *
 */
package gui;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

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
	private JButton exitBtn;
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
				mf.setPanel(mf.loginPanel);
			}
		});

		registerBtn = new JButton("Register");
		registerBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				mf.setPanel(mf.registerPanel);
			}
		});

		exitBtn = new JButton("Exit");
		exitBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Component c = (Component)e.getSource();
				Window w = SwingUtilities.getWindowAncestor(c);
				w.dispose();
				System.exit(0);
			}
		});


		loginBtn.setBounds(xPos, 100, width, height);
		registerBtn.setBounds(xPos, 160, width, height);
		exitBtn.setBounds(xPos, 500, width, height);
		this.add(loginBtn);
		this.add(registerBtn);
		this.add(exitBtn);
	}

	public String getPanelName() {
		return this.name;
	}
}
