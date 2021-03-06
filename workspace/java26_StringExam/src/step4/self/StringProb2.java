package step4.self;
public class StringProb2 {
	public static final String SPACE = " ";
	
	public static void main(String[] args) {
		System.out.println(spaceTrim("Java  Program        Language"));
		System.out.println(spaceTrim("Structured Query     Language"));
		System.out.println(spaceTrim("Servlet & JSP"));
		
		System.out.println(spaceTrim_2("Java  Program        Language"));
		System.out.println(spaceTrim_2("Structured Query     Language"));
		System.out.println(spaceTrim_2("Servlet & JSP"));
	}

	private static char[] spaceTrim(String string) {
		// Java Program Language
		// String temp = string.replaceAll("\\s+", " ");
		
		char[] result = new char[string.length()];
		
		int index = 0;
		for(int i = 0; i < string.length()-1; i++) {
			if((string.charAt(i) != ' ') || (string.charAt(i) == ' ' && string.charAt(i+1) != ' ') ) { 
				result[index++] = string.charAt(i);
			}
		}
		
		
		return result;
	}
	
	private static char[] spaceTrim_2(String string) {
		char[] result;
		String temp = string.replaceAll("\\s+", " ");
		result = temp.toCharArray();
		return result;
	}
}
