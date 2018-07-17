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
	protected String[] panelNames = {"main", "menu", "login", "register", "editor"};
	protected MainPanel mainPanel = new MainPanel(this, panelNames[0]);
	protected MenuPanel menuPanel = new MenuPanel(this, panelNames[1]);
	protected LoginPanel loginPanel = new LoginPanel(this, panelNames[2]);
	protected RegisterPanel registerPanel = new RegisterPanel(this, panelNames[3]);
	protected EditorPanel editorPanel = new EditorPanel(this, panelNames[4]);
	protected MyDialog dialog = new MyDialog(this, false);
	/**
	 *
	 */
	public MainFrame() {
		setBounds(100, 100, 900, 600);
		setPanel(mainPanel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	public void setIdPassToPanels(String id, String pass) {
		menuPanel.setIdPass(id, pass);
		editorPanel.setIdPass(id, pass);
	}

	public void setPanel(JPanel panel){
		getContentPane().removeAll();
		add(panel);
		validate();
		repaint();
	}

}
