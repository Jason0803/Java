package poly.child;

import java.util.Arrays;

import poly.parent.Person;

public class Student extends Person {
	private boolean[] document;
	private int[] attendance = new int[30];
	private char grade;

	public static final int ATTEND = 0;
	public static final int LATE = 1;
	public static final int ABSENT = 2;
	
	
	public Student(String name, String personId, String address, String phoneNumber, boolean[] document,
			int[] attendance, char grade) {
		super(name, personId, address, phoneNumber);
		this.document = document;
		this.attendance = attendance;
		this.grade = grade;
	}
	
	

	public Student(String name, String personId, String address, String phoneNumber) {
		super(name, personId, address, phoneNumber);
		this.document = document;
		this.attendance = attendance;
		this.grade = grade;
	}



	public boolean[] getDocument() {
		return document;
	}

	public void setDocument(boolean[] document) {
		this.document = document;
	}

	public int[] getAttendance() {
		return attendance;
	}

	public void setAttendance(int[] attendance) {
		this.attendance = attendance;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return super.toString()+"Student [document=" + Arrays.toString(document) + ", attendance=" + Arrays.toString(attendance)
				+ ", grade=" + grade + "]";
	}

}
