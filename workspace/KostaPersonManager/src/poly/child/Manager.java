package poly.child;

import poly.parent.Person;

public class Manager extends Person {
	private String position;

	public Manager(String name, String personId, String address, String phoneNumber, String position) {
		super(name, personId, address, phoneNumber);
		this.position = position;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return super.toString()+"Manager [position=" + position + "]";
	}

}
