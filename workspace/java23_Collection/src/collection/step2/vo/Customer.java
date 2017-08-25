package collection.step2.vo;

public class Customer {
	private int cusId; // PK
	private String name;
	private int age;
	
	public Customer(int cusId, String name, int age) {
		super();
		this.cusId = cusId;
		this.name = name;
		this.age = age;
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [cusId=" + cusId + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
