import java.util.*;

public class Segment 
{
	private String segmentNumber;
	private String source;
	private String target;
	
	String getSegment() { return this.segmentNumber; }
	String getSource() { return this.source; }
	String getTarget() { return this.target; }
	
	public void setSegment(String seg)
	{
		this.segmentNumber = seg;
	}
	public void setSource(String src)
	{
		this.source = src;
	}
	public void setTarget(String trg)
	{
		this.target = trg;
	}
	public void printSegment()
	{
		System.out.println("Segment Number: " + this.segmentNumber);
		System.out.println("Source: " + this.source);
		System.out.println(" Target: " + this.target);
	}
}
