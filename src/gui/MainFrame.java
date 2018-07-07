/**
 *
 */
package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Yopiyama
 *
 */
public class MainFrame extends JFrame{

	/**
	 *
	 */
	private static final long serialVersionUID = -8026416994513756565L;
	protected String[] panelNames = {"main","menu"};
	protected MainPanel mainPanel = new MainPanel(this, panelNames[0]);
	protected MenuPanel menuPanel = new MenuPanel(this, panelNames[1]);

	/**
	 *
	 */
	public MainFrame() {
		changePanel((JPanel)mainPanel);
		this.setBounds(10, 10, 1000, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);


	}

	public void changePanel(JPanel panel){
		getContentPane().removeAll();
		super.add(panel);
		validate();
		repaint();
	}

}
