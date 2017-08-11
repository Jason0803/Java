package reference.vo;

public class ProductVO {
	 private int serialNo;
	 private String model;
	 private String maker;
	 private int price;
	 
	public ProductVO(int serialNo, String model, String maker, int price) {
		super();
		this.serialNo = serialNo;
		this.model = model;
		this.maker = maker;
		this.price = price;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	 

	 
}
