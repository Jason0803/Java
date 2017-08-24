package props.test;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		Properties p = System.getProperties();
		Enumeration en = p.propertyNames();
		
		while(en.hasMoreElements()) {
			String key = (String)en.nextElement();
			System.out.print("Key : " + key + "\n-Property : ");
			System.out.println(p.getProperty(key));
			//System.out.println(en.nextElement().toString());
		}
		
		//System.out.println(p.toString());
		

	}

}
