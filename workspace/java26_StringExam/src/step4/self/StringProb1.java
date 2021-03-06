package step4.self;
public class StringProb1 {
	public static void main(String[] args) {
		System.out.println(makeInitial("Java Data Base Conectivity"));
		System.out.println(makeInitial("Java Server Pages"));
		System.out.println(makeInitial("Enterprise Java Beans"));
		
		//JDBC
		// JSP
		// EJB
	}

	private static String makeInitial(String fullName) {
		String result = "";
		char[] upperCases = { 
			'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'I', 'J', 'K', 'L', 'M', 'N',
			'O', 'P', 'Q', 'R', 'S', 'T', 'U',
			'V', 'W', 'X', 'Y', 'Z'
		};
		
		for(int i = 0; i < fullName.length(); i++){
			for(int j = 0; j < upperCases.length; j++) {
				if(fullName.charAt(i) == upperCases[j]) {
					result = result + upperCases[j];
				}
			}
		}
		
		return result;
	}
}
