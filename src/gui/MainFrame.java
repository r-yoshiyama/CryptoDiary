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
	protected JPanel[] panels = {mainPanel, menuPanel};
	/**
	 *
	 */
	public MainFrame() {
		this.setBounds(10, 10, 900, 600);
		setPanel(mainPanel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	public void setPanel(JPanel panel){
		getContentPane().removeAll();
		add(panel);
		validate();
		repaint();
	}

}
