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

		setLayout(null);
		btn = new JButton(mf.panelNames[2] + "に移動");
		btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				mf.setPanel(mf.panels[2]);
			}
		});
		btn.setBounds(0, 0, 90, 20);
		this.add(btn);
	}

	public String getPanelName() {
		return this.name;
	}

}
