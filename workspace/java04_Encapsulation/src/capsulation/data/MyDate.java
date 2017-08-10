package capsulation.data;

public class MyDate {
	private int month;
	private int day;
	public static void errorDisplay(){
		System.out.println("Invalid Input !!");
		System.exit(0);
	}
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if(month < 1 || month > 12){
			errorDisplay();
		} else this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		switch (month){
			// February
			case 2: {
				if(day < 1 || day > 28){
					errorDisplay();
				} else this.day = day;
				break;
			}
			
			// 1 ~ 31
			case 1: case 3: case 5: case 7: case 8: case 10: case 12: {
				if(day < 1 || day > 31){
					errorDisplay();
				} else 	this.day = day;
				break;
			}
			// 1 ~ 30
			case 4: case 6: case 9: case 11: {
				if(day < 1 || day > 30){
					errorDisplay();
				} else this.day = day;
				break;
			}
		}
	}
} // End of MyDate Class