import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JEditorPane;


public class TagFinderWithCounts {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField lineNumberField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TagFinderWithCounts window = new TagFinderWithCounts();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TagFinderWithCounts() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 564, 336);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 543, 173);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblFile = new JLabel("File : ");
		lblFile.setBounds(40, 35, 48, 20);
		panel.add(lblFile);
		
		JLabel lblTagToFind = new JLabel("Tag to find : ");
		lblTagToFind.setBounds(40, 77, 80, 20);
		panel.add(lblTagToFind);
		
		JLabel lblTagCount = new JLabel("Tag Occurence");
		lblTagCount.setBounds(239, 80, 91, 17);
		panel.add(lblTagCount);
		
		textField = new JTextField();
		textField.setBounds(122, 35, 175, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(122, 77, 105, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(342, 77, 62, 20);
		panel.add(spinner);
		
		JButton btnBrowse = new JButton("Browse..");
		btnBrowse.setBounds(307, 34, 97, 23);
		panel.add(btnBrowse);
		
		JButton btnFindLineNumber = new JButton("Find Line Number");
		btnFindLineNumber.setBounds(40, 119, 151, 28);
		panel.add(btnFindLineNumber);
		
		lineNumberField = new JTextField();
		lineNumberField.setBounds(324, 121, 80, 26);
		panel.add(lineNumberField);
		lineNumberField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 174, 543, 124);
		frame.getContentPane().add(scrollPane);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setContentType("text/html\r\n");
		scrollPane.setViewportView(editorPane);
	}
}
