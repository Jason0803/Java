package kosta.cons;

public class Engine {
	String brandName;
	int life;
	
	public Engine(String brandName, int life) {
		this.brandName = brandName;
		this.life = life;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
	public String display(){
		return "\nEngine Details.." +
				"\n-Brand Name : " + brandName +
				"\n-Life Remaining : " + life;
	}
	
}