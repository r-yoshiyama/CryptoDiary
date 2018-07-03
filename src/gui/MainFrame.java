/**
 *
 */
package gui;

import javax.swing.JFrame;

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
	MainPanel mainPanel = new MainPanel(this, panelNames[0]);
	MenuPanel menuPanel = new MenuPanel(this, panelNames[1]);

	/**
	 *
	 */
	public MainFrame() {

		this.add(mainPanel);
		mainPanel.setVisible(true);

		this.add(menuPanel);
		menuPanel.setVisible(false);

		this.setBounds(10, 10, 1000, 800);
	}

	public void changePanel(String nowPanel, String nextPanel){
		if(nowPanel.equals(panelNames[0])) {
			mainPanel.setVisible(false);
		} else if(nowPanel.equals(panelNames[1])) {
			menuPanel.setVisible(false);
		}

		if(nextPanel.equals(panelNames[0])) {
			mainPanel.setVisible(true);
		} else if(nextPanel.equals(panelNames[1])) {
			menuPanel.setVisible(true);
		}
	}

}
