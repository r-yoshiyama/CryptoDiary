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
	private JButton btn1;
	private JButton btn2;
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
		btn1 = new JButton("Login");
		btn1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				mf.setPanel(mf.panels[2]);
			}
		});
		btn2 = new JButton("Register");
		btn2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				mf.setPanel(mf.panels[3]);
			}
		});
		btn1.setBounds(xPos, 100, width, height);
		btn2.setBounds(xPos, 160, width, height);

		this.add(btn1);
		this.add(btn2);
	}

	public String getPanelName() {
		return this.name;
	}
}
