package step5.test;

class SunCompany {
	private String companyName;
	private static SunCompany sun = new SunCompany();
	private SunCompany() {
		companyName = "Sun Microsystems";
		System.out.println("Company Name :: " + companyName);
	}
	public static SunCompany getInstance() {
		return sun;
	}
	
}

public class SingletonTest {

	public static void main(String[] args) {
		SunCompany.getInstance();
	}

}
