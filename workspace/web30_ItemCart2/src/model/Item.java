package model;

public class Item {
	private int itemnumber; //item_id
	private String name; //item_name
	private int price;
	private String description;
	private String url;
	private int count;
	
	public Item(int itemnumber, String name, int price, String description, String url, int count) {
		super();
		this.itemnumber = itemnumber;
		this.name = name;
		this.price = price;
		this.description = description;
		this.url = url;
		this.count = count;
	}
	public int getItemnumber() {
		return itemnumber;
	}
	public void setItemnumber(int itemnumber) {
		this.itemnumber = itemnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Item [itemnumber=" + itemnumber + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", url=" + url + ", count=" + count + "]";
	}	
}
