import java.util.*;
import java.io.*;
import java.lang.*;

public class testMain 
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = null;
		
		try
		{
			String fileName = "//Users//Jason//Desktop//segmentTest.exp";
			String line;
			ArrayList<String> entire = new ArrayList<String>();
			ArrayList<Segment> segments = new ArrayList<Segment>();
			
			String seg = "<Segment>";
			String src = "<Source>";
			String trg = "<Target>";
			Segment tmpSeg = new Segment();
			int segmentCount = 0;
			
			br = new BufferedReader(new FileReader(fileName));
			line = br.readLine();
			
			while( line != null )
			{
				entire.add(line);
				line = br.readLine();
			}
			
			segmentCount = findSegment(entire, segments, seg, src, trg, tmpSeg,
					segmentCount);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			br.close();
		}
	
	} // end of main
// --------------------------------------------------------------------------------------------//
	public static int findSegment(ArrayList<String> entire,
			ArrayList<Segment> segments, String seg, String src, String trg,
			Segment tmpSeg, int segmentCount) 
	{
		StringBuilder sb = new StringBuilder();
		String temp;
		
		for (int i=0; i < entire.size(); i++)
		{
			if( entire.get(i).indexOf(seg) != -1 )
			{
				tmpSeg.setSegment( entire.get(i).substring(9));	
				//find source and target
			}
			if( entire.get(i).indexOf(src) != -1 )
			{
				if( entire.get(i).indexOf("</Source>") != -1)
				{
					tmpSeg.setSource( entire.get(i).substring(
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
						else
						{
							sb.append(entire.get(j));
							break;
						}
						j++;
					}
					temp = sb.toString();
					tmpSeg.setSource( temp.substring(8, temp.indexOf("</Source>")));
				}
			}
			if( entire.get(i).indexOf(trg) != -1 )
			{
				if( entire.get(i).indexOf("</Target>") != -1)
				{
					tmpSeg.setTarget( entire.get(i).substring(
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
					tmpSeg.setTarget( temp.substring(8, temp.indexOf("</Target>")));
				}
				segments.add(tmpSeg);
				segments.get(segmentCount).printSegment();
				segmentCount++;
			}
			
		}
		return segmentCount;
	}
// --------------------------------------------------------------------------------------------//
}
