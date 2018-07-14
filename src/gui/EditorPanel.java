/**
 *
 */
package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

/**
 * @author Yopiyama
 *
 */
public class EditorPanel extends JPanel {
	/**
	 *
	 */
	@SuppressWarnings("unused")
	private MainFrame mf;
	private String name;
	private JTextArea inputArea;
	private JScrollPane scrollPane;

	/*
	 *
	 */
	private static final long serialVersionUID = 1412769909205852904L;


	public EditorPanel(MainFrame mf, String name) {
		this.mf = mf;
		this.name = name;

		setLayout(null);

		inputArea = new JTextArea();
		inputArea.setLineWrap(true);
		inputArea.setTabSize(4);
		inputArea.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		scrollPane = new JScrollPane(inputArea);

//		inputArea.setBounds(100, 50, 700, 300);
//		this.add(inputArea);
		scrollPane.setBounds(100, 50, 700, 300);
		this.add(scrollPane);
	}

	public String getPanelName() {
		return this.name;
	}

}
