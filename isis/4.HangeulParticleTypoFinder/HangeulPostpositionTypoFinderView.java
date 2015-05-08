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
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Document;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;


@SuppressWarnings("serial")
public class HangeulPostpositionTypoFinderView extends JPanel implements ActionListener {
	private JFrame frame;
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
	Document doc;
    public HangeulPostpositionTypoFinderView(){ 
    	
    	String[] particle_1 = {"은 ","을 ","이 ","과 ","이랑 "};
    	//= { "U+C740", "U+C744", "U+C774", "U+ACFC", "U+C774 U+B791" };								// "은-을-이-과-이랑"
    	String[] particle_2 = {"는 ","를 ","가 ","와 ","랑 "};
    	//= { "U+B294", "U+B97C", "U+AC00", "U+C640", "U+B791"};										// "는-를-가-와-랑"
    	String[] finalls = { "U+11A8", "U+11A9", "U+11AA", "U+11AB", "U+11AC", "U+11AD", "U+11AE", "U+11AF", "U+11B0", 
    			"U+11B1", "U+11B2", "U+11B3", "U+11B4", "U+11B5", "U+11B6","U+11D9" ,"U+11B7", "U+11B8", "U+11B9", 
    			"U+11BA", "U+11BB", "U+11BC", "U+3148", "U+314A", "U+11BD", "U+11BF", "U+11C0", "U+11B5", "U+11C2" };				// finalls

		frame = new JFrame();
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
		scrollPane.setViewportView(editorPane);
		doc = editorPane.getDocument();
		
		fc = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt Files", "txt");
	    fc.addChoosableFileFilter(filter);


		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( e.getSource() == btnBrowse ){
		            int returnVal = fc.showOpenDialog(HangeulPostpositionTypoFinderView.this);
		            if (returnVal == JFileChooser.APPROVE_OPTION){
		            	file = fc.getSelectedFile();
		            	if( file.getName().indexOf(".txt") == -1 ){
		                    JOptionPane.showMessageDialog(scrollPane, "You should choose .txt File !", "Warning",
		                            JOptionPane.WARNING_MESSAGE);
		                    System.exit(0);
		                }
		                //This is where a real application would open the file.
		                textField.setText(file.getName());   
		            }
				}
			}
		});
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( e.getSource() == btnRead ){
					try{
						
						br = new BufferedReader(new InputStreamReader
            				(new FileInputStream(file.getPath()), Charset.forName("UTF-8")));
						String line = br.readLine();
						int i = 0;
						while(line!=null){
							System.out.println(line);
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
		
		btnCheckGrammar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( e.getSource() == btnCheckGrammar ){
					//bw = new BufferedWriter(new );
				}
			}
		});
		
		btnSaveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( e.getSource() == btnSaveFile ){
					
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void findTypo(Document document){
		String find; 
	}
	public void hasFinal(String s){
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HangeulPostpositionTypoFinderView window = new HangeulPostpositionTypoFinderView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
