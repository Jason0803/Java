package broker.three.vo;

import java.io.Serializable;

public class StockRec implements Serializable{
	private String symbol;
	private float price;
	
	public StockRec(String symbol, float price) {
		super();
		this.symbol = symbol;
		this.price = price;
	}
	public StockRec() {
		symbol = "";
		price = 0.0f;
	}
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "StockRec [symbol=" + symbol + ", price=" + price + "]";
	}
	
}
