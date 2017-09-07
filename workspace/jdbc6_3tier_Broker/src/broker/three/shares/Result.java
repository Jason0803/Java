package broker.three.shares;

import java.util.ArrayList;
/*
 * returned obj & status
 */
public class Result extends ArrayList {
	private int status = -1;
	
	public Result() {
		super(1);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
