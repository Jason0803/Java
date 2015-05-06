import java.io.*;
import java.util.*;
import java.nio.charset.Charset;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

	/* 	LAST UPDATED: 06/05/2015 12:45PM 	*/
	/* 		Algorithm Updated 		*/
	/*		 Fastened Work			*/
/*
 * 
 *	This application is made for following purposes:
 *	1. Browse ".EXP" file(s) (now extension on progress)
 *	2. Find all of 'Segments'
 *	3. Find segments contain specific tag(s) e.g. <b> or <keyword>	(on progress to find multiple tags)
 *	4. Highlight the tags" <b> and </b> OR <keyword="blahh"></keyword>
 *
 */
//--------------------------------------------------------------------------------------------------------------------//
@SuppressWarnings("serial")
public class ReadAndHighlightTag extends JPanel
                             implements ActionListener 
{
	ArrayList<String> entire = new ArrayList<String>();
	ArrayList<Segment> segments = new ArrayList<Segment>();
    JButton openButton;
    JButton btnSearch;
    JFileChooser fc;
    JEditorPane txtpnabc;
    private JTextField textField;
    private JLabel lblTag;
    private JTextField txtTagtag;
    private static File file;
    private String tag;
    private String anotherTag;						// For extension: 'Searching 2 tags'
    private static final String seg = "<Segment>";
	private static final String src = "<Source>";
	private static final String  trg = "<Target>";
	Segment tmpSeg = new Segment();
	int segmentCount = 0;
    BufferedReader br;
    private final JScrollPane scrollPane = new JScrollPane();


// -------------------------------------------------------------------------------------------------------------------//
    public ReadAndHighlightTag()  // Constructor
    {
 
        //Create a file chooser
        fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".EXP Files", "EXP");
        fc.addChoosableFileFilter(filter);
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
        textField.setEditable(false);
        textField.setBounds(81, 6, 512, 17);
        buttonPanel.add(textField);
        textField.setColumns(10);
	        
        openButton = new JButton("Open a File...");
        openButton.setBounds(622, 4, 109, 23);
		buttonPanel.add(openButton);
		 
		lblTag = new JLabel("Tag");
		lblTag.setBounds(22, 50, 36, 19);
		buttonPanel.add(lblTag);
		                       
		txtTagtag = new JTextField();
		txtTagtag.setText("tag1,tag2, ...\r\n");
		txtTagtag.setBounds(83, 49, 510, 20);
		buttonPanel.add(txtTagtag);
		txtTagtag.setColumns(10);
		                       
		btnSearch = new JButton("Search");
		btnSearch.setBounds(622, 49, 109, 23);
		buttonPanel.add(btnSearch);
		                       
		openButton.addActionListener(this);
		btnSearch.addActionListener(this);
		                       
		JPanel panel = new JPanel();
		panel.setBounds(12, 137, 1029, 278);
		add(panel);
		panel.setLayout(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 1029, 278);
		panel.add(scrollPane);
		
		txtpnabc = new JEditorPane();
		txtpnabc.setContentType("text/html");
		scrollPane.setViewportView(txtpnabc);
		//txtpnabc.setText("<html><font color='red'><b></font>\uC77C\uBC18 \uAC80\uC0C9<font color='red'></b></font></html>");
        // to check whether HTML Source works
		
		
		JLabel lblResult = new JLabel("Result :");
		lblResult.setBounds(22, 109, 57, 15);
	    add(lblResult);        
    }
// -------------------------------------------------------------------------------------------------------------------//
    public void actionPerformed(ActionEvent e)
    {
        StyledDocument doc = (StyledDocument) txtpnabc.getDocument();

        //Handle open button action.
        if (e.getSource() == openButton)
        {
            int returnVal = fc.showOpenDialog(ReadAndHighlightTag.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) 
            {
                file = fc.getSelectedFile();
                if( file.getName().indexOf(".EXP") == -1 )
                {
                    JOptionPane.showMessageDialog(scrollPane, "You should choose .EXP File !", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
                //This is where a real application would open the file.
                textField.setText(file.getName());                
                
                try
                {
            		br = new BufferedReader(new InputStreamReader
            				(new FileInputStream(file.getPath()), Charset.forName("UTF-16")));
            		 
                		String line = br.readLine();
                		while( line != null )
                		{
                			entire.add(line);
                			line = br.readLine();
                		}
                		findSegment(entire);
                		
                		br.close();
                }
                catch(Exception error) { error.printStackTrace(); } 
            } 
            else 
            {
            	
            	textField.setText("File Choose Cancelled by user");
            }
        }
        else if(e.getSource() == btnSearch)
        {
        	try
        	{
        		int i = 0;
        		StringBuilder contents = new StringBuilder();
        		txtpnabc.setText("");
        		tag = txtTagtag.getText();
        		String _tag = "<" + tag;
        		
        		while(i < segments.size() )
        		{
        			if( segments.get(i).getSource().indexOf(_tag)!= -1 && segments.get(i).getTarget().indexOf(_tag) == -1)
        			{	
        				// tag in source, but not in target
        				contents.append("Segment: " + segments.get(i).getSegment() + "\n");
        				contents.append( "Source: " + segments.get(i).getSource() + "\n");
        				contents.append( "Target: " + segments.get(i).getTarget() + "\n\n");
        				
        				
        			}
        			else if( segments.get(i).getTarget().indexOf(_tag)!= -1 && segments.get(i).getSource().indexOf(_tag) == -1)
        			{
        				// tag in target, but not in source
        				contents.append("Segment: " +  segments.get(i).getSegment() + "\n");
        				contents.append(" Source: " + segments.get(i).getSource() + "\n");
        				contents.append(" Target: " + segments.get(i).getTarget() + "\n\n");
        				
        			}
        			else if( segments.get(i).getSource().indexOf(_tag)!= -1 &&
        					segments.get(i).getTarget().indexOf(_tag)!= -1)
        			{
        				// tag in both source and target
        				contents.append("Segment: " + segments.get(i).getSegment() + "\n");
        				contents.append(" Source: " + segments.get(i).getSource() + "\n");
        				contents.append(" Target: " + segments.get(i).getTarget()+ "\n\n");

        			}
        			i++;
        		} // End of While
        		doc.insertString(doc.getLength(), contents.toString(), null);		// put entire 'contents' on txtpnabc

	        	Document document = txtpnabc.getDocument();
	        	tagHighlighter(document);
        	}
        	catch( Exception error ) {error.printStackTrace();}
        }
    }
// -------------------------------------------------------------------------------------------------------------------//
	void tagHighlighter(Document document) {
	try 
	{
	    String find_1 = "<" +tag;
	    String find_2 = ">";
	    String find_3 = "</" + tag;
	    LOOP:
	    for (int index = 0; index + find_1.length() < document.getLength(); index++) 
	    {
	    	DefaultHighlighter.DefaultHighlightPainter highlightPainter =
	                new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
	        String match = document.getText(index, find_1.length());
	        if(find_1.equals(match)) 
	        {   
	        	int idx = index;												// From the beginning of tag to an end
	        	while(true)
	        	{
	        		match = document.getText(idx, find_2.length());
	        		if(find_2.equals(match)) 
	        		{
	        			txtpnabc.getHighlighter().addHighlight(index, idx+1, highlightPainter);
	        			break;
	        		}
	        		idx++;
	        	}
	        	int idx_2 = idx;

	        	while(true)														// From the beginning of closing tag to an end
	        	{
	        		match = document.getText(idx_2, find_3.length());
	        		if(find_3.equals(match))
	        		{
	        			int idx_3 = idx_2;
	        			while(true)
	        			{
	        				match = document.getText(idx_3, find_2.length());
	        				if(find_2.equals(match))
	        				{
	        					txtpnabc.getHighlighter().addHighlight(idx_2, idx_3+1, highlightPainter);
	        					continue LOOP;
	        				}
	        				idx_3++;
	        			}
	        		}
	        		idx_2++;
	        	}
	            //txtpnabc.getHighlighter().addHighlight(index, index + find_1.length(),
	            //        highlightPainter);
	        	
	        }
	       
	    }
	} 
	catch (BadLocationException ex) { ex.printStackTrace(); }
}
//--------------------------------------------------------------------------------------------------------------------//
    void appendString(String str) throws Exception
    {
        StyledDocument document = (StyledDocument) txtpnabc.getDocument();

 
        document.insertString(document.getLength(), str, null);
     }
// -------------------------------------------------------------------------------------------------------------------//
    public String tagColouring( String line, String tag ) 
    {
    	// This method is being used without 'tag' exists in the 'line'
    	// as this method will be used where already checked for that case
    	
    	StringBuilder sb = new StringBuilder();
    	String temp;
    	String result;
    	if( line.indexOf(tag) == 0 )																			// 1. In case the tag located at the beginning of the line
    	{	
    		sb.append("<html><font color='red'>");
    		temp = line.substring(0, line.indexOf(">")+1);														// Colouring opening tag
    		sb.append(temp + "</font></html>");
    		
    		temp = line.substring( line.indexOf(">")+1, line.indexOf( "</"+ tag ) );							// Content_1
    		sb.append(temp);
    		
    		temp = line.substring( line.indexOf( "</" + tag), line.indexOf(">", line.indexOf("</" + tag))+1 );	// Colouring closing tag
    		sb.append("<html><font color='red'>");
    		sb.append(temp);
    		sb.append("</font></html>");
    		
    		temp = line.substring( line.indexOf(">", line.indexOf("</" + tag)) );								// Content_2
    		sb.append(temp); // this could be just "" in case there is no more content in current line
    	}
    	else																									// 2. In case the tag located between contents of the line
    	{		
    		temp = line.substring(0, line.indexOf("<"+tag));													// Content_1				
    		sb.append(temp);
    		
    		temp = line.substring( line.indexOf("<"+tag), line.indexOf(">", line.indexOf(tag))+1 );				// Colouring opening tag
    		sb.append("<html><font color='red'>");
    		sb.append(temp);
    		sb.append("</font></html>");
    		
    		temp = line.substring( line.indexOf(">", line.indexOf(tag))+1, line.indexOf("</" + tag) );			// Content_2
    		sb.append(temp);
    		
    		temp = line.substring( line.indexOf("</" + tag), line.indexOf(">", line.indexOf("</"+tag))+1);		// Colouring closing tag
    		sb.append("<html><font color='red'>");
    		sb.append(temp);
    		sb.append("</font></html>");
    		
    		temp = line.substring( line.indexOf(">", line.indexOf("</"+tag))+1 );									// Content_3
    		sb.append(temp);
    	}
    	
    	result = sb.toString();
    	return result;
    }
// -------------------------------------------------------------------------------------------------------------------//   
    private static void createAndShowGUI() {
        //Create and set up the window.'
        JFrame frame = new JFrame("FileChooserDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add content to the window.
        frame.getContentPane().add(new ReadAndHighlightTag());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
// -------------------------------------------------------------------------------------------------------------------//   
    void findSegment(ArrayList<String> entire) throws Exception 
	{
    	/* FOUND THREATENING EXCEPTION !! */
    	/*
    	 * 
    	 *
    	 */
		Segment tempSeg = new Segment();
		StringBuilder sb = new StringBuilder();
		String temp;
		
		for (int i=0; i < entire.size(); i++)
		{
			if( entire.get(i).indexOf(seg) != -1 ) // a line with 'segment' found
			{
				tempSeg.setSegment( entire.get(i).substring(9));
				//find source and target
			}
			if( entire.get(i).indexOf(src) != -1 )
			{
				if( entire.get(i).indexOf("</Source>") != -1)
				{
					tempSeg.setSource( entire.get(i).substring(
							8, entire.get(i).indexOf("</Source>")));
				}
				else
				{
					int j = i;
					while(true)
					{
						if (entire.get(j).indexOf("</Source>") == -1)
						{
							sb.append(entire.get(j));
						}
						else if( entire.get(j).indexOf("</Source>") != -1)
						{
							sb.append(entire.get(j));
							break;
						}
						j++;
					}
					temp = sb.toString();
					tempSeg.setSource( temp.substring(8, temp.indexOf("</Source>")));
				}
			}
			if( entire.get(i).indexOf(trg) != -1 )
			{
				if( entire.get(i).indexOf("</Target>") != -1)
				{
					tempSeg.setTarget( entire.get(i).substring(
							8, entire.get(i).indexOf("</Target>")));
				}
				else
				{
					int j = i;
					while(true)
					{
						if (entire.get(j).indexOf("</Target>") == -1)
						{
							sb.append(entire.get(j));
						}
						else
						{
							sb.append(entire.get(j));
							break;
						}
						j++;
					}
					temp = sb.toString();
					tempSeg.setTarget( temp.substring(8, temp.indexOf("</Target>")));
				}
				segments.add(tempSeg);
				tempSeg = new Segment();
				sb = new StringBuilder();
				segments.get(segmentCount).printSegment();
				segmentCount++;
			}
		}
	}
// -------------------------------------------------------------------------------------------------------------------//   
    public static void main(String[] args) 
    {
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
// -------------------------------------------------------------------------------------------------------------------//   
}
