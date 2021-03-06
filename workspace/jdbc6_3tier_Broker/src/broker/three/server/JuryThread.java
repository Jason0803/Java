package broker.three.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

import broker.three.exception.DuplicateSSNException;
import broker.three.exception.InvalidTransactionException;
import broker.three.exception.RecordNotFoundException;
import broker.three.shares.Command;
import broker.three.shares.Result;
import broker.three.vo.CustomerRec;

public class JuryThread extends Thread {
	private Socket s;
	private Database db;
	private Command cmd;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public JuryThread(Socket s, Database db) {
		try {
			this.s = s;
			this.db = db;
			ois = new ObjectInputStream(s.getInputStream());
			oos = new ObjectOutputStream(s.getOutputStream());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void run() {
		System.out.println("Jury Run...");
		while(true) {
			try {
				cmd = (Command)ois.readObject();
			} catch (Exception e) {}
				int value = cmd.getCommanValue();
				String[] args = cmd.getArgs();
				Result r = cmd.getResults();
				switch(value) {
					case Command.GET_ALL_CUSTOMER: {
						try {
							System.out.println("Getting all customers...");
							ArrayList<CustomerRec> list = db.getAllCustomers();
							r.add(list);
							System.out.println("hello");
							r.setStatus(0);
						} catch(Exception e) {
							
						}
						
						break;
					}
					case Command.BUY_SHARES : {
						try {
							db.buyShares(args[0], args[1], Integer.parseInt(args[2]));
							r.setStatus(0);
						} catch(Exception e) {
							
						}
						break;
					}
					case Command.SELL_SHARES : {
						try {
							db.sellShares(args[0], args[1], Integer.parseInt(args[2]));
							r.setStatus(0);

						} catch (RecordNotFoundException e) {
							r.setStatus(-1);
						} catch (InvalidTransactionException e) {
							r.setStatus(-3);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					}
					case Command.GET_ALL_STOCK : {
						try {
							r.add(db.getAllStocks());
							r.setStatus(0);
						
						} catch(Exception e) {}
						break;
					}
					case Command.GET_STOCK_PRICE : {
						try {
							float price = db.getStockPrice(args[0]);
							r.add(price);
							r.setStatus(0);
						} catch (RecordNotFoundException e) {
							System.out.println("No Such Record Found !");
						} catch (Exception e) {}
						break;
					}
					case Command.GET_CUSTOMER : {
						try {
							CustomerRec cr = db.getCustomer(args[0]);
							r.add(cr);
							r.setStatus(0);
						} catch (Exception e) { 
							System.out.println(e.getMessage());
						}
						break;
					}
					case Command.ADD_CUSTOMER : {
						
						try {
							db.addCustomer(new CustomerRec(args[0], args[1], args[2]));
							r.setStatus(0);
						} catch (DuplicateSSNException e) {
							r.setStatus(-3);
						} catch (Exception e) {}
						break;
					}
					case Command.DELETE_CUSTOMER : {
						try {
							db.deleteCustomer(args[0]);
							r.setStatus(0);
						} catch(RecordNotFoundException e) {
							r.setStatus(-1);
						} catch(Exception e) {}
						break;
					}
					case Command.UPDATE_CUSTOMER : {
						try {
							db.updateCustomer(new CustomerRec(args[0], args[1], args[2]) );
							r.setStatus(0);
						} catch (RecordNotFoundException e) {
							r.setStatus(-1);
							System.out.println("No such Record Found !");
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					}
				} // switch
				try {
					oos.writeObject(cmd);
				} catch (Exception e ) { 
					
				}
		} // while
	} // run
} // class
