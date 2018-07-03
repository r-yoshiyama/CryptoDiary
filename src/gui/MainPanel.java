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
	private JButton btn;

	/*
	 *
	 */
	private static final long serialVersionUID = -2338264669378462369L;


	public MainPanel(MainFrame mf, String name) {
		this.mf = mf;
		this.name = name;
		btn = new JButton(mf.panelNames[1] + "に移動");
		btn.setBounds(20, 50, 150, 40);
		btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				mf.changePanel(mf.panelNames[1], mf.panelNames[0]);
			}
		});
		this.add(btn);
	}

	public String getPanelName() {
		return this.name;
	}
}
