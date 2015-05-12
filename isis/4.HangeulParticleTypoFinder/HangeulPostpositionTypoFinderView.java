import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.awt.Dimension;


public class TagFinderWithCounts extends JPanel implements ActionListener{
	private static JFrame frame;
	private JPanel panel;
	private JLabel lblFile;
	private JLabel lblTagToFind;
	private JLabel lblTagCount;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnBrowse;
	private JSpinner spinner;
	private JButton btnFindLineNumber;
	private JScrollPane scrollPane;
	private JEditorPane editorPane;
	private JFileChooser fc;
	private File file;
	private BufferedReader br;
	public TagFinderWithCounts() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(460, 330));
		frame.setBounds(100, 100, 456, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 443, 173);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblFile = new JLabel("File : ");
		lblFile.setBounds(40, 35, 48, 20);
		panel.add(lblFile);
		
		lblTagToFind = new JLabel("Tag to find : ");
		lblTagToFind.setBounds(40, 77, 80, 20);
		panel.add(lblTagToFind);
		
		lblTagCount = new JLabel("Tag Occurence : ");
		lblTagCount.setBounds(40, 127, 105, 18);
		panel.add(lblTagCount);
		
		textField = new JTextField();
		textField.setBounds(122, 35, 175, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(122, 77, 105, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		spinner = new JSpinner();
		spinner.setBounds(165, 125, 62, 20);
		panel.add(spinner);
		
		btnBrowse = new JButton("Browse..");

		btnBrowse.setBounds(307, 34, 97, 23);
		panel.add(btnBrowse);
		
		btnFindLineNumber = new JButton("Search");
		btnFindLineNumber.setBounds(253, 77, 151, 72);
		panel.add(btnFindLineNumber);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 174, 443, 118);
		frame.getContentPane().add(scrollPane);
		
		editorPane = new JEditorPane();
		editorPane.setContentType("text/html\r\n");
		scrollPane.setViewportView(editorPane);
		
		fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(".dita Files", "dita");
	    fc.addChoosableFileFilter(filter);
	    
		btnBrowse.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if( e.getSource() == btnBrowse ){
				int returnVal = fc.showOpenDialog( TagFinderWithCounts.this);
	            if (returnVal == JFileChooser.APPROVE_OPTION){
	            	file = fc.getSelectedFile();
	                //This is where a real application would open the file.
	                textField.setText(file.getName());   
	            }
	            }
			}
		});
		
		btnFindLineNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tag = textField_1.getText().toString();
				int occurence = (int) spinner.getValue();
				
				
			}
		});
		
	}
	private static void createAndShowGUI(){
		        //Create and set up the window.'
		        frame = new JFrame("TagFinder");
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		        //Add content to the window.
		        frame.getContentPane().add(new TagFinderWithCounts());
		 
		        //Display the window.
		        frame.pack();
		        frame.setVisible(true);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					createAndShowGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
