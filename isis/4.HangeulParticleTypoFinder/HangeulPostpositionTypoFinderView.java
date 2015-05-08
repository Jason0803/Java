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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;


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
    public HangeulPostpositionTypoFinderView(){ 
		frame = new JFrame();
		frame.setBounds(100, 100, 703, 472);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		browserPanel = new JPanel();
		browserPanel.setBounds(0, 0, 687, 74);
		frame.getContentPane().add(browserPanel);
		browserPanel.setLayout(null);
		
		lblFile = new JLabel("File");
		lblFile.setBounds(55, 24, 43, 22);
		browserPanel.add(lblFile);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(117, 25, 432, 21);
		browserPanel.add(textField);
		textField.setColumns(10);
		
		btnBrowse = new JButton("Browse");
		
		btnBrowse.setBounds(566, 24, 97, 23);
		browserPanel.add(btnBrowse);
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 75, 687, 54);
		frame.getContentPane().add(buttonPanel);
		buttonPanel.setLayout(null);
		
		btnRead = new JButton("Read");
	
		btnRead.setBounds(58, 15, 78, 23);
		buttonPanel.add(btnRead);
		
		btnCheckGrammar = new JButton("Check Grammar");
		btnCheckGrammar.setBounds(267, 15, 125, 23);
		buttonPanel.add(btnCheckGrammar);
		
		btnSaveFile = new JButton("Save File");
		btnSaveFile.setBounds(529, 15, 102, 23);
		buttonPanel.add(btnSaveFile);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 126, 687, 308);
		frame.getContentPane().add(scrollPane);
		
		editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
		
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
						while(line!=null){
							System.out.println(line);
							line = br.readLine();
						}
					}catch(Exception ex){ex.printStackTrace();}
				}
			}
		});

		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
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
