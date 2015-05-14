
import java.awt.Color;
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
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.awt.Dimension;
import java.lang.*;
import javax.swing.SpinnerNumberModel;


public class TagFinderWithCounts extends JPanel implements ActionListener{
	private static JFrame frmJasonsTagFinder;
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
	private ArrayList<String> entire;
	private ArrayList<String> result;
	private ArrayList<Integer> lineNumber;
	private StyledDocument doc;
	private Style style;
	private ProcessBuilder process;
	private Runtime runTime;
	public TagFinderWithCounts() {
		frmJasonsTagFinder = new JFrame();
		frmJasonsTagFinder.setResizable(false);
		frmJasonsTagFinder.setTitle("Jason's Tag Finder");
		frmJasonsTagFinder.setMinimumSize(new Dimension(460, 330));
		frmJasonsTagFinder.setBounds(100, 100, 456, 330);
		frmJasonsTagFinder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJasonsTagFinder.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 454, 174);
		frmJasonsTagFinder.getContentPane().add(panel);
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
		textField.setEditable(false);
		textField.setBounds(122, 35, 142, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(122, 77, 142, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner.setBounds(202, 126, 62, 20);
		panel.add(spinner);
		
		btnBrowse = new JButton("Browse..");

		btnBrowse.setBounds(310, 34, 97, 23);
		panel.add(btnBrowse);
		
		btnFindLineNumber = new JButton("Search");
		btnFindLineNumber.setBounds(310, 80, 97, 65);
		panel.add(btnFindLineNumber);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 174, 454, 128);
		frmJasonsTagFinder.getContentPane().add(scrollPane);
		
		editorPane = new JEditorPane();
		editorPane.setDragEnabled(true);
		editorPane.setEditable(false);
		editorPane.setContentType("text/html");
		scrollPane.setViewportView(editorPane);
		
		doc = (StyledDocument) editorPane.getDocument();
		style = doc.addStyle("error",null);
		StyleConstants.setForeground(style, Color.red);
		
		fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(".dita Files", "dita");
	    fc.addChoosableFileFilter(filter);
	    
	    /* BROWSE FILE */
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
		
		/* SEARCH SPECIFIC TAG */
		btnFindLineNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					// OPEN UP THE FILE THROUGH EDIT PLUS
					String tag = textField_1.getText().toString();
					int occurence = (int) spinner.getValue();
					entire = new ArrayList<String>();
					result = new ArrayList<String>();
					lineNumber = new ArrayList<Integer>();
					InputStreamReader is = new InputStreamReader(new FileInputStream(file), "UTF-8");
					br = new BufferedReader(is);
					
					/* Read all the lines from given file */
					String line = br.readLine();
					while( line != null ){
						entire.add(line);
						line = br.readLine();
					}
					
					/* Find specific line that contains the tag user specified */
					for(int i = 0; i < entire.size(); i++ ){
						if( entire.get(i).indexOf("<"+tag)!= -1 ){
							result.add( (i+1) + ": " + entire.get(i));
							lineNumber.add(i+1);
						}
					}
					
					/* Find specific line that contains the tag & matches occerence number */
							//System.out.println(result.get(occurence-1));  --> WORKS FOR TAG OCCURRED ONCE IN A LINE
					int j;
					int count = 0;
					FORLOOP:
					for(j = 0; j < result.size(); j++){
						int idx = 0;
							
						while ((idx = result.get(j).indexOf("<"+tag, idx)) != -1){
							idx++;
							count++;
							if( count == occurence ){
								break FORLOOP;
							}
					    }
					}
					if( occurence > count ){
						/* TO CATCH AN EXCEPTION OCCURRED WHEN 'SPINNER VALUE' IS HIGHER THAN ACTUAL COUNTS OF THE TAG */
						doc.insertString(doc.getLength()," ' " + tag + " ' "+" Occurred less than " + occurence +", " +
															"Actually Occured: " + count + "times" +"\n\n", style);
					}else{
						runTime = Runtime.getRuntime();
						process = new ProcessBuilder("C:/Program Files (x86)/EditPlus 3/editplus.exe", file.getPath(), "-cursor", lineNumber.get(j).toString());
						process.start();
							
							
						doc.insertString(doc.getLength(), result.get(j) + "\n\n", null);
					}
				}catch(Exception ex){ ex.printStackTrace(); }
			}
		});
		
	}
	private static void createAndShowGUI(){
		        //Create and set up the window.'
		        frmJasonsTagFinder = new JFrame("TagFinder");
		        frmJasonsTagFinder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		        //Add content to the window.
		        frmJasonsTagFinder.getContentPane().add(new TagFinderWithCounts());
		 
		        //Display the window.
		        frmJasonsTagFinder.pack();
		        frmJasonsTagFinder.setVisible(true);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					createAndShowGUI();
				} catch (Exception e) {e.printStackTrace();}
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
