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
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.awt.Dimension;

import javax.swing.JCheckBox;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class SummaryParser extends JPanel implements ActionListener{
	private static JFrame frmSummaryFinder;
	private JScrollPane panel;
	private JLabel lblFile;
	private JEditorPane textField;
	private JButton btnBrowse;
	private static JButton btnSearch;
	private JScrollPane scrollPane;
	private JEditorPane editorPane;
	private JFileChooser fc;
	private File file;
	private File[] files;
	private BufferedReader br;
	private StringBuilder sb;
	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	
	public SummaryParser() {
		frmSummaryFinder = new JFrame();
		frmSummaryFinder.setResizable(false);
		frmSummaryFinder.setTitle("Summary Finder");
		frmSummaryFinder.setMinimumSize(new Dimension(450, 320));
		frmSummaryFinder.setBounds(100, 100, 455, 324);
		frmSummaryFinder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSummaryFinder.getContentPane().setLayout(null);
		
		panel = new JScrollPane();
		panel.setBounds(0, 0, 443, 118);
		frmSummaryFinder.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblFile = new JLabel("File(s) : ");
		lblFile.setSize(new Dimension(49, 25));
		lblFile.setPreferredSize(new Dimension(49, 25));
		lblFile.setMinimumSize(new Dimension(49, 40));
		lblFile.setMaximumSize(new Dimension(49, 50));
		lblFile.setBounds(40, 35, 48, 20);
		panel.add(lblFile);
		
		textField = new JEditorPane();
		textField.setContentType("text/html");
		textField.setEditable(false);
		textField.setBounds(122, 35, 173, 62);
		panel.add(textField);
		
		btnBrowse = new JButton("Browse..");

		btnBrowse.setBounds(307, 34, 97, 23);
		panel.add(btnBrowse);
		
		btnSearch = new JButton("Search");

		btnSearch.setBounds(307, 76, 97, 21);
		panel.add(btnSearch);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 115, 443, 177);
		frmSummaryFinder.getContentPane().add(scrollPane);
		
		editorPane = new JEditorPane();
		editorPane.setContentType("text/html\r\n");
		scrollPane.setViewportView(editorPane);
		
		fc = new JFileChooser();
		fc.setMultiSelectionEnabled(true);
		FileNameExtensionFilter filter = new FileNameExtensionFilter(".dita Files", "dita");
	    fc.addChoosableFileFilter(filter);
	    
		btnBrowse.addActionListener(new ActionListener() {
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			if( e.getSource() == btnBrowse ){
				int returnVal = fc.showOpenDialog( SummaryParser.this);
	            if (returnVal == JFileChooser.APPROVE_OPTION){
	            	files = fc.getSelectedFiles();
	                //This is where a real application would open the file.
	            	String fileList = "";
	                for(int i=0; i<files.length; i++){
	                	fileList += (files[i].getName() + "\n");
	                }
	                textField.setText(fileList);
	            }
	            }
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( e.getSource() == btnSearch ) {
					sb = new StringBuilder();
					for( int i=0; i < files.length; i++ ){
						try{
							InputStreamReader is = new InputStreamReader(new FileInputStream(files[i]), "UTF-8");
							br = new BufferedReader(is);
							String line = br.readLine();
							while(line!=null){
								if(line.indexOf("<summary")!= -1){
									while(true){
										line = br.readLine();
										
										if(line.indexOf("</summary>")!=-1) {
											break;
										} else {
											sb.append(line.substring( line.indexOf("type") ,line.indexOf("/>")-1 ) +"\n");
										}
									}
								}
								line = br.readLine();
							}
							editorPane.setText(editorPane.getText() + files[i].getName() +"\n\n" + sb.toString() + "\n");
							
						} catch( Exception ex ) {ex.printStackTrace();}
					}
					
					// CREATE NEW EXCEL FILE
					workbook = new HSSFWorkbook();
					sheet = workbook.createSheet("SHIT");
					
					
				}
			}
		});
		
	}
	private static void createAndShowGUI(){
		        //Create and set up the window.'
		        frmSummaryFinder = new JFrame("Summary Finder");
		        frmSummaryFinder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		        //Add content to the window.
		        frmSummaryFinder.getContentPane().add(new SummaryParser());
		 
		        //Display the window.
		        frmSummaryFinder.pack();
		        frmSummaryFinder.setVisible(true);
		 }
	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
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
