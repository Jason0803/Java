package poly.course;

public class Course {
	private String title;
	private int classHourPerDay;//

	public Course(String title, int classHourPerDay) {
		super();
		this.title = title;
		this.classHourPerDay = classHourPerDay;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getClassHourPerDay() {
		return classHourPerDay;
	}

	public void setClassHourPerDay(int classHourPerDay) {
		this.classHourPerDay = classHourPerDay;
	}

}
