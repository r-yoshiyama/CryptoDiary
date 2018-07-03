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
public class MenuPanel extends JPanel{

	/*
	 *
	 */
	@SuppressWarnings("unused")
	private MainFrame mf;
	private String name;
	private JButton btn;

	/**
	 *
	 */
	private static final long serialVersionUID = -2224859379095514692L;


	public MenuPanel(MainFrame mf, String name) {
		this.mf = mf;
		this.name = name;
		btn = new JButton(mf.panelNames[0] + "に移動");
		btn.setBounds(20, 50, 150, 40);
		btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				mf.changePanel(mf.panelNames[0], mf.panelNames[0]);
			}
		});
		this.add(btn);
	}

	public String getPanelName() {
		return this.name;
	}

}
