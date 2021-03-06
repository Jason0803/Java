package broker.three.shares;

import java.io.Serializable;

public class Command implements Serializable {
	public static  final int BUY_SHARES = 10;
	public static  final int SELL_SHARES = 20;
	public static  final int GET_ALL_STOCK = 30;
	public static  final int GET_STOCK_PRICE = 40;
	public static  final int GET_CUSTOMER = 50;
	public static  final int GET_ALL_CUSTOMER = 60;
	public static  final int ADD_CUSTOMER = 70;
	public static  final int DELETE_CUSTOMER = 80;
	public static  final int UPDATE_PRICE = 90;
	public static final int UPDATE_CUSTOMER = 100;
	
	private int commanValue;
	private String[] args;
	private Result results;
	
	
	public Command(int commanValue) {
		super();
		this.commanValue = commanValue;
		results = new Result();
	}
	
	// data pack
	public void setCommanValue(int commanValue) {
		this.commanValue = commanValue;
	}
	public void setArgs(String[] args) {
		this.args = args;
	}
	public void setResults(Result results) {
		this.results = results;
	}
	
	// data unpack	
	public int getCommanValue() {
		return commanValue;
	}
	public String[] getArgs() {
		return args;
	}
	public Result getResults() {
		return results;
	}
	

	
	
}
