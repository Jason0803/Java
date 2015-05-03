import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
//---------------------------------------------------------------------------------------//
public class TargetExcluded 
{
	static ArrayList<String> entire = new ArrayList<String>();
	ArrayList<Segment> segments = new ArrayList<Segment>();
    private static final String newline = "\n";
    private static File file;
    private static final String seg = "<Segment>";
	private static final String src = "<Source>";
	private static final String  trg = "<Target>";
    Segment tmpSeg = new Segment();
	int segmentCount = 0;
	
    static BufferedReader br;
//---------------------------------------------------------------------------------------//
	public static void main(String args[])
	{
		try
		{
			file = new File("//Users//Jason//Desktop//DMO15AED002.EXP");
			br = new BufferedReader(new InputStreamReader
    				(new FileInputStream(file.getPath()), Charset.forName("UTF-16")));

			String line = br.readLine();
			
			while ( line != null )
			{
				entire.add(line);
				line = br.readLine();
			}
			
			for( int i = 0; i < entire.size(); i++ )						// To print out 'entire' contents
			{
				String temp;
				StringBuilder sb = new StringBuilder();
				
				
				if( entire.get(i).indexOf(trg)!= -1 )						// If current line is on 'Target'
				{
					temp = entire.get(i).substring(0, 8);
					sb.append(temp);
					if( entire.get(i).indexOf("</Target>") != -1)			// when a target ends in a line
					{
						temp = entire.get(i).substring(
								entire.get(i).indexOf("</Target>"));
						sb.append(temp);
						
						System.out.println(sb.toString());
					}
					else													// when a target has multiple lines
					{
						int j = i;
						while(true)
						{
							if (entire.get(j).indexOf("</Target>") == -1)	// still not end of Target
							{
								if( entire.get(j).indexOf(trg)!= -1 )
								{
									sb.append("");
								}
							}
							else											// current phase on end of Target
							{
								sb.append(entire.get(j).substring(
										entire.get(j).indexOf("</Target>")) );
								break;
							}
							j++;
							i = j;
						}
						System.out.println( sb.toString() );
					}
				}
				else														// print current line
					System.out.println( entire.get(i));
				
			}
		}
		catch (Exception e) { e.printStackTrace(); }
		
	} // end of main
//---------------------------------------------------------------------------------------//
} // end of class
