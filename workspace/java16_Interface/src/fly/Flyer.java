package fly;

public interface Flyer {
	// All fields in Interface is 'public static final'
	char color = 'B'; 
	public static final int DEFAULT_SPEED = 1024;
	
	// All methods in Interface is 'public abstract'
	String fly();
	void takeOff();
	void land(); // 
}
