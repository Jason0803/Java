import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.text.Normalizer;
import java.awt.Color;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class HangeulPostpositionTypoFinderView extends JPanel implements ActionListener {
	private static JFrame frame;
	private JLabel lblFile;
	private JTextField textField;
    private static File file; 
    private JPanel browserPanel;
    private JButton btnBrowse;
    private JPanel buttonPanel;
    private JButton btnRead;
    private JButton btnCheckGrammar;
    private JButton btnSaveFile;
    private JScrollPane scrollPane;
    private JEditorPane editorPane;
    private JFileChooser fc;
    private BufferedReader br;
    private BufferedWriter bw;
	ArrayList<String> entire = new ArrayList<String>();
	StyledDocument doc;
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    public HangeulPostpositionTypoFinderView(){ 
    	
    	final String[] particle_1 = {"은 ","을 ","이 ","과 "};
    	//= { "U+C740", "U+C744", "U+C774", "U+ACFC", "U+C774 U+B791" };															// "은-을-이-과-이랑"
    	final String[] particle_2 = {"는 ","를 ","가 ","와 "};
    	//= { "U+B294", "U+B97C", "U+AC00", "U+C640", "U+B791"};																	// "는-를-가-와-랑"
    	final String[] finals = { "U+11A8", "U+11A9", "U+11AA", "U+11AB", "U+11AC", "U+11AD", "U+11AE", "U+11AF", "U+11B0",
    							  "U+11B1", "U+11B2", "U+11B3", "U+11B4", "U+11B5", "U+11B6", "U+11B7", "U+11B8", "U+11B9",
    							  "U+11BA", "U+11BB", "U+11BC", "U+11BD", "U+11BE", "U+11BF", "U+11C0", "U+11C1", "U+11C2"};																	// finals

    	final String[] charsetsToBeTested = {"UTF-8", "UTF-16","windows-1253", "ISO-8859-7"};
    	
		frame = new JFrame();
		frame.setResizable(false);
		frame.setMinimumSize(new Dimension(605, 515));
		frame.setBounds(100, 100, 605, 513);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		browserPanel = new JPanel();
		browserPanel.setBounds(0, 0, 588, 74);
		frame.getContentPane().add(browserPanel);
		browserPanel.setLayout(null);
		
		lblFile = new JLabel("File");
		lblFile.setBounds(30, 24, 43, 22);
		browserPanel.add(lblFile);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(85, 25, 331, 21);
		browserPanel.add(textField);
		textField.setColumns(10);
		
		btnBrowse = new JButton("Browse");
		
		btnBrowse.setBounds(466, 24, 97, 23);
		browserPanel.add(btnBrowse);
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 75, 588, 51);
		frame.getContentPane().add(buttonPanel);
		buttonPanel.setLayout(null);
		
		btnRead = new JButton("Read");
	
		btnRead.setBounds(85, 10, 78, 23);
		buttonPanel.add(btnRead);
		
		btnCheckGrammar = new JButton("Check Grammar");

		btnCheckGrammar.setBounds(232, 10, 125, 23);
		buttonPanel.add(btnCheckGrammar);
		
		btnSaveFile = new JButton("Save File");

		btnSaveFile.setBounds(468, 8, 97, 26);
		buttonPanel.add(btnSaveFile);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 126, 588, 347);
		frame.getContentPane().add(scrollPane);
		
		editorPane = new JEditorPane();
		editorPane.setContentType("text/html");
		editorPane.setBackground(Color.WHITE);
		editorPane.setEditable(false);
		scrollPane.setViewportView(editorPane);
		doc = (StyledDocument) editorPane.getDocument();
		final Style style = doc.addStyle("StyleName", null);
	    StyleConstants.setForeground(style, Color.red);
		
		fc = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt Files", "txt");
	    fc.addChoosableFileFilter(filter);
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( e.getSource() == btnBrowse ){
		            int returnVal = fc.showOpenDialog(HangeulPostpositionTypoFinderView.this);
		            if (returnVal == JFileChooser.APPROVE_OPTION){
		            	file = fc.getSelectedFile();
		                //This is where a real application would open the file.
		                textField.setText(file.getName());   
		            }
				}
			}
		});
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( e.getSource() == btnRead ){
					try{
						
						CharsetDetector cd = new CharsetDetector();
				        Charset charset = cd.detectCharset(file, charsetsToBeTested);
				 
				        if (charset != null) {
				        	InputStreamReader reader = new InputStreamReader(new FileInputStream(file), getFileEncoding(file));
				        	br = new BufferedReader(reader);				 
				        }else{
				            System.out.println("Unrecognized charset.");
				        }
						String line = br.readLine();
						int i = 0;
						while(line!=null){
							entire.add(line);
							doc.insertString(doc.getLength(), entire.get(i).toString()+"\n", null);
							line = br.readLine();
							i++;
						}
						i = 0;
					}catch(Exception ex){ex.printStackTrace();}
				}
			}
		});
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
		btnCheckGrammar.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				if( e.getSource() == btnCheckGrammar ){
					try{
						//editorPane.setText("");
						for(int index = 0; index + 1 < doc.getLength(); index++){
							String match = doc.getText(index, 2);
							for(int i = 0; i < particle_1.length; i++){
								if( match.equals(particle_1[i]) ){ //one of particles should be followed by final
									String nfd = Normalizer.normalize(doc.getText(index-1,1), Normalizer.Form.NFD); 		// Convert a letter before 'match' to NFD
									
									StringBuilder check = new StringBuilder();
									int n =0;
									for(n = 0; n < nfd.length(); n++)
										check.append(String.format("U+%04X ", nfd.codePointAt(n))); 
//										
//									if( check!=null){
//										if( n < 2 && ( doc.getText(index-1, 1).equals("까")==false )){
//											doc.remove(index, 2);
//											doc.insertString(index, particle_2[i], style);
//										}
//									}
									
									if( check.toString() != null && (doc.getText(index-1, 1).equals(" ")==false) && (doc.getText(index-1, 1).equals("마")==false)){
										int found = 0;		
										for(int idx=0; idx < finals.length; idx++){
											if( check.toString().indexOf(finals[idx]) != -1 ){
												found++;
											}
										}
										if( found == 0 && ( doc.getText(index-1, 1).equals("까")==false ) ){
											doc.remove(index, 2);
											doc.insertString(index, particle_2[i], style);
										}
									}
								}
								else if( match.equals(particle_2[i]) ){ //one of particles should NOT be followed by final
									String nfd = Normalizer.normalize(doc.getText(index-1,1), Normalizer.Form.NFD); 		// Convert a letter before 'match' to NFD
									StringBuilder check = new StringBuilder();
									
									int n =0;
									for(n = 0; n < nfd.length(); n++)
										check.append( String.format("U+%04X", nfd.codePointAt(n)) ); 
									if( check.toString() != null){
										if( n > 2 && (doc.getText(index-1,1).equals("없")==false ) && (doc.getText(index-1, 1).equals("있")==false ) ) {
											doc.remove(index, 2);
											doc.insertString(index, particle_1[i], style);
										}
//										int found = 0;
//										for(int idx =0; idx<finals.length; idx++){
//											if( check.equals(finals[idx])){
//												found++;
//											}
//										}
//										if( found != 0 && (doc.getText(index-1,1).equals("없")==false ) && (doc.getText(index-1, 1).equals("있")==false ) ) ){
//											doc.remove(index, 2);
//											doc.insertString(index, particle_1[i], style);
//										}
											
									}
								}
							}
							match = null;
						}
					}catch(Exception ex) {ex.printStackTrace();}

				}
			}
		});
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
		btnSaveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( e.getSource() == btnSaveFile ){
					try{
						//bw = new BufferedWriter(new );
					}catch(Exception ex) {ex.printStackTrace();}
				}
			}
		});
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	public void findTypo(Document document){
		String find; 
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	public String getFileEncoding(File f){
		try{
			FileInputStream fis = new FileInputStream(f);
			
			byte[] BOM = new byte[4];
			fis.read(BOM,0,4);
			fis.close();
			if((BOM[0] & 0xFF) == 0XEF && (BOM[1] & 0xFF) == 0xBB && (BOM[2] & 0xFF) == 0xBF )
				return "UTF-8";
			else if((BOM[0] & 0xFF) == 0xFE && (BOM[1] & 0xFF) == 0xFF )
				return "UTF-16BE";
			else if((BOM[0] & 0xFF) == 0xFF && (BOM[1] & 0xFF) == 0xFE )
				return "UTF-16";
			else
				return "EUC-KR";			
		}catch(Exception e) {e.printStackTrace(); return null;} 
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    private static void createAndShowGUI() 
    {
        //Create and set up the window.'
        frame = new JFrame("Highlighter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add content to the window.
        frame.getContentPane().add(new HangeulPostpositionTypoFinderView());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					HangeulPostpositionTypoFinderView window = new HangeulPostpositionTypoFinderView();
//					window.frame.setVisible(true);
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    createAndShowGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
