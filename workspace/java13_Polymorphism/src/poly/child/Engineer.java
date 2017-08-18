package poly.child;

import poly.parent.Employee;

public class Engineer extends Employee {
	private String tech;
	private int bonus;
	
	public Engineer(String empId, String name, String address, int salary, String tech, int bonus) {
		super(empId, name, address, salary);
		this.tech = tech;
		this.bonus = bonus;
	}

	public String getTech() {
		return tech;
	}

	public void setTech(String tech) {
		this.tech = tech;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	public void changeTech(String tech){
		this.tech = tech;
	}
	
	@Override
	public String toString(){
		return super.toString() + ", Engineer [tech="+tech+"]";
	}
	
}
