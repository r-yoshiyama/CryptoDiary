/**
 *
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JOptionPane;
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
	private JButton editBtn;
	private String id;
	@SuppressWarnings("unused")
	private String pass;
	private int xPos = 390;
	private int width = 120;
	private int height = 40;

	/**
	 *
	 */
	private static final long serialVersionUID = -2224859379095514692L;


	public MenuPanel(MainFrame mf, String name) {
		this.mf = mf;
		this.name = name;

		setLayout(null);

		btn = new JButton("Logout");
		btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				mf.setPanel(mf.mainPanel);
			}
		});

		editBtn = new JButton("Edit File");
		editBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String value = selectFile();
				if(!nameChk(value)) {
					return;
				} else {
					mf.editorPanel.setFile(value);
					mf.setPanel(mf.editorPanel);
				}

			}
		});

		editBtn.setBounds(xPos, 200, width, height);
		btn.setBounds(xPos, 400, width, height);

		this.add(btn);
		this.add(editBtn);
	}

	/*
	 *
	 */
	public String selectFile() {
		/* Use JFileChooser Version */
		//		JFileChooser fileChooser = new JFileChooser("./data/");
		//
		//		int selected = fileChooser.showOpenDialog(this);
		//		if (selected == JFileChooser.APPROVE_OPTION){
		//			return fileChooser.getSelectedFile().getPath();
		//
		//		}else if (selected == JFileChooser.CANCEL_OPTION){
		//			JOptionPane.showMessageDialog(this, "Canceled", "Error", JOptionPane.ERROR_MESSAGE);
		//			return null;
		//		}else if (selected == JFileChooser.ERROR_OPTION){
		//			JOptionPane.showMessageDialog(this, "Error", "Error", JOptionPane.ERROR_MESSAGE);
		//			return null;
		//		}
		//		return null;

		File dir = new File("./diary/" + id + "/");
		String[] fileList = dir.list();
		String value = "";
		if(fileList == null) {
			value = JOptionPane.showInputDialog(this, "Enter file name.");
		} else {
			for(int i = 0; i < fileList.length; i++) {
				fileList[i] = fileList[i].replace(".txt", "");
			}
			value = JOptionPane.showInputDialog(this,"File List\n* " + String.join("\n* ", fileList) + "\n\nEnter file name.");
		}
		if(value != null) {
			return "./diary/" + id + "/" + value + ".txt";
		} else {
			return "";
		}
	}

	public boolean nameChk(String name) {
		if(name.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please enter filename", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			System.out.println(name);
		}
		return true;
	}

	public void setIdPass(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}

	public String getPanelName() {
		return this.name;
	}

}
