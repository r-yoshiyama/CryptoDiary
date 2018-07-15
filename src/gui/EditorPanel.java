/**
 *
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

import cipher.publickey.RSA;
import util.FileUtil;

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
	private JButton saveBtn;
	private String fileName;
	private String id;
	@SuppressWarnings("unused")
	private String pass;

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

		saveBtn = new JButton("save");
		saveBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				saveFile();
				mf.setPanel(mf.menuPanel);
			}
		});

		scrollPane.setBounds(100, 50, 700, 300);
		saveBtn.setBounds(700, 500, 120, 40);
		this.add(scrollPane);
		this.add(saveBtn);
	}

	public void saveFile() {
		String text = inputArea.getText();
		String[] keys = FileUtil.readFile("./data/pass/" + this.id);
		RSA rsa = new RSA(RSA.BIT1024);
		rsa.setKeys(keys);
		text = rsa.encode(text);
		Path path = Paths.get(fileName);
		FileUtil.writeFile(path.toString(), text.split("\n"), false);
		JOptionPane.showMessageDialog(this, "Save completed", "Complete", JOptionPane.INFORMATION_MESSAGE);
	}

	public String getPanelName() {
		return this.name;
	}

	public void setFile(String fileName) {
		this.fileName = fileName;
		String[] keys = FileUtil.readFile("./data/pass/" + this.id);
		RSA rsa = new RSA(RSA.BIT1024);
		rsa.setKeys(keys);
		String text = String.join("\n", FileUtil.readFile(this.fileName));
		if(!text.isEmpty()) {
			inputArea.setText(rsa.decode(text));
		} else {
			inputArea.setText("");
		}

	}

	public void setIdPass(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}

}
