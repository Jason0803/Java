import java.io.*;
import java.nio.charset.Charset;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.filechooser.*;
 

public class FileChooserDemo extends JPanel
                             implements ActionListener 
{
    static private final String newline = "\n";
    JButton openButton;
    JButton btnSearch;
    JFileChooser fc;
    private JTextField textField;
    private JLabel lblTag;
    private JTextField textField_1;
    private JTextArea textArea;
    private JScrollBar bar;
    private static File file;
    private String tag;
    
    BufferedReader br;
    private final JScrollPane scrollPane = new JScrollPane();
    
    public FileChooserDemo() {
 
        //Create a file chooser
        fc = new JFileChooser();
        setLayout(null);
 

        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(12, 14, 773, 85);
        buttonPanel.setLayout(null);
 
        //Add the buttons and the log to this panel.
        add(buttonPanel);
        
        JLabel lblFile = new JLabel("File");
        lblFile.setBounds(22, 4, 36, 20);
        buttonPanel.add(lblFile);
        
        textField = new JTextField();
        textField.setBounds(81, 6, 512, 17);
        buttonPanel.add(textField);
        textField.setColumns(10);
        
                       openButton = new JButton("Open a File...");
                       openButton.setBounds(622, 4, 109, 23);
                       buttonPanel.add(openButton);
                       
                       lblTag = new JLabel("Tag");
                       lblTag.setBounds(22, 50, 36, 19);
                       buttonPanel.add(lblTag);
                       
                       textField_1 = new JTextField();
                       textField_1.setBounds(81, 50, 512, 18);
                       buttonPanel.add(textField_1);
                       textField_1.setColumns(10);
                       
                       btnSearch = new JButton("Search");
                      
                       btnSearch.setBounds(622, 49, 109, 23);
                       buttonPanel.add(btnSearch);
                       
                       openButton.addActionListener(this);
                       btnSearch.addActionListener(this);
                       
                       JPanel panel = new JPanel();
                       panel.setBounds(12, 137, 758, 207);
                       add(panel);
                       panel.setLayout(null);
                       scrollPane.setBounds(0, 0, 758, 207);
                       panel.add(scrollPane);
                       
                       textArea = new JTextArea();
                       textArea.setEditable(false);
                       scrollPane.setViewportView(textArea);
                       
                       JLabel lblResult = new JLabel("Result :");
                       lblResult.setBounds(22, 109, 57, 15);
                       add(lblResult);
                       
    }
 
    public void actionPerformed(ActionEvent e) 
    {
        //Handle open button action.
        if (e.getSource() == openButton)
        {
            int returnVal = fc.showOpenDialog(FileChooserDemo.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) 
            {
                file = fc.getSelectedFile();         
                //This is where a real application would open the file.
                textField.setText(file.getName());
            } 
            else 
            {
                //log.append("Open command cancelled by user." + newline);
            	textField.setText("File Choose Cancelled by user");
            }
        }
        else if(e.getSource() == btnSearch)
        {
        	try
        	{
        		int segmentCount = 0;
        		textArea.setText("");
        		tag = textField_1.getText() ;
        		
        		br = new BufferedReader(new InputStreamReader
    				(new FileInputStream(file.getPath()), Charset.forName("UTF-16")));
        		
        		String line = br.readLine();
        		while( line != null )
        		{
        			if( line.indexOf("<Segment>")!= -1 ) // for each segment
        			{
        				segmentCount++;

        				while( line.indexOf("</Target") == -1 )
        				{
	        				if( (line.indexOf("<" + tag + ">") != -1) || (line.indexOf("</" + tag + ">")!= -1) )
		        			{
		        				textArea.append(line + newline);
		        			}
	        				line = br.readLine();
        				}
        			}
        			line = br.readLine(); 
        		}
        	}
        	catch( Exception error ) {error.printStackTrace();}
        }
    }
 
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("FileChooserDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add content to the window.
        frame.getContentPane().add(new FileChooserDemo());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	try {
            		//Windows UI
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    createAndShowGUI();
            	} catch(Exception e) {
            		e.printStackTrace();
            	}
            }
        });
    }
}
