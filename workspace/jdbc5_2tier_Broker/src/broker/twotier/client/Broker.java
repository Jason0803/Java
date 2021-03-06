package broker.twotier.client;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import broker.twotier.dao.Database;
import broker.twotier.exception.DuplicateSSNException;
import broker.twotier.exception.InvalidTransactionException;
import broker.twotier.exception.RecordNotFoundException;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.SharesRec;
import broker.twotier.vo.StockRec;

//�������̽� implements �� ���·� Ŭ���� ��������
public class Broker implements ActionListener,ItemListener{
	private static int mode = 0;
	private static final int ADD_MODE = 1;
	private static final int UPDATE_MODE = 2;

	Database 		db;

	Frame 	frame =new Frame("ABC Stock");

	//*************������Ʈ ����...���� ************************
    //*******************************************************
	Panel 	pc =new Panel();
	Panel 	pe =new Panel();
	
	Panel 	   pec	=new Panel();
	Panel 	   pes	=new Panel();	
	
	
	Panel 	   pcn	=new Panel();
	Panel 	   pcc	=new Panel();
	Panel 	   pcw	=new Panel();
	Panel 	   pcs	=new Panel();
	

	Panel 		pcn1	=new Panel();
	Panel 		pcc1	=new Panel();
	Panel 		pcc2	=new Panel();
	
	Panel 		pcwn	=new Panel();
	Panel 		pcws	=new Panel();
	Panel 		pcwa	=new Panel();
	

	TextField nameTf	= new TextField(15);
	TextField ssnTf		= new TextField(15);
	TextField stockTf	= new TextField(15);
	TextField buyTf		= new TextField(15);
	TextField priceTf	= new TextField(15);
	TextField sellTf	= new TextField(15);

	TextArea addrTa	= new TextArea(3,15);

	List 	custList	= new List(15, false);
	List 	stockList	= new List(15, false);
	List 	portList	= new List(15, false);
	
	Button 	addB	= new Button("ADD");
	Button 	deleteB	= new Button("DELETE");
	Button 	updateB	= new Button("UPDATE");
	Button 	applyB	= new Button("apply");
	Button 	cancelB	= new Button("cancel");

	Button 	buyB	= new Button("Buy");
	Button 	sellB	= new Button("Sell");

	Button 	priceB	= new Button("Get Current Stock Price");

	// **************** ������ **************************************
	//*****************************************************************
	public Broker() throws Exception{
		
	   try	{	    
	    db =  new Database("127.0.0.1");
		} catch(Exception cnfe) {
			System.out.println("Broker Constructor : " + cnfe);
	
		}
		createGUI();
		addListener();

		showCustList(db.getAllCustomers(),custList);
		showStockList(db.getAllStocks(),stockList);
	
		initButton(true);
		emptyText();
		textEditable(false);

	}//������ �ݰ�...

	// **********����, ����� ���� **********************
	//**************************************************
	public void createGUI() {	
	
		pc.setBackground(new Color(196 ,196  ,255  ));
		pe.setBackground(new Color(196 ,196  ,255  ));
		pec.setBackground(new Color(196 ,196  ,255  ));
		pes.setBackground(new Color(196 ,196  ,255  ));
		pcn.setBackground(new Color(196 ,196  ,255  ));
		pcc.setBackground(new Color(196 ,196  ,255  ));
		pcw.setBackground(new Color(196 ,196  ,255  ));
		pcs.setBackground(new Color(196 ,196  ,255  ));
		pcn1.setBackground(new Color(196 ,196  ,255  ));
		pcc1.setBackground(new Color(196 ,196  ,255  ));
		pcc2.setBackground(new Color(196 ,196  ,255  ));
		pcwn.setBackground(new Color(196 ,196  ,255  ));
		pcws.setBackground(new Color(196 ,196  ,255  ));
		pcwa.setBackground(new Color(196 ,196  ,255  ));
		custList.setBackground(new Color(142 ,142  ,255));
		stockList.setBackground(new Color(48 ,0  ,96));
		portList.setBackground(new Color(142 ,142  ,255));
		sellTf.setBackground(new Color(196 ,196  ,255));
	
	    frame.add(pc,"Center");
		frame.add(pe,"East");
		// *******************  ������Ʈ ����  ************************************
		// **********************************************************************
		pe.setLayout(new BorderLayout());
			pe.add(new Label("Stock Information", Label.CENTER), "North");
			pe.add(pec, "Center");
			pe.add(pes, "South");

			pec.setLayout(new BorderLayout());
			pec.add(new Label("Available Stocks"), "North");
			pec.add(stockList, "Center");
			pec.add(priceB, "South");
			pes.setLayout(new GridLayout(2, 2));
			pes.add(new Label("  Stock"));	
			pes.add(stockTf);
			pes.add(new Label("  Current Price"));	
			pes.add(priceTf);

		pc.setLayout(new BorderLayout());
			pc.add(pcn, "North");
			pc.add(pcc, "Center");
			pc.add(pcw, "West");
			pc.add(pcs, "South");

			GridLayout grid = new GridLayout(2, 1);
			pcn.setLayout(grid);
			grid.setHgap(20);
			pcn.add(new Label("Customer Information", Label.CENTER));
			pcn.add(pcn1);
			pcn1.add(addB);
			pcn1.add(deleteB);
			pcn1.add(updateB);
			pcn1.add(applyB);
			pcn1.add(cancelB);

			pcc.setLayout(new GridLayout(1, 2));
			pcc.add(pcc1);
			pcc1.setLayout(new BorderLayout());
			pcc1.add(new Label("Stock Portfolio"), "North");
			pcc1.add(portList);

			pcc.add(pcc2);
			pcc2.setLayout(new BorderLayout());
			pcc2.add(new Label("All Customers"), "North");
			pcc2.add(custList);

			pcw.setLayout(new GridLayout(3, 1));
			pcw.add(pcwn);
			pcwn.add(new Label("Name"));
			pcwn.add(nameTf);
			pcw.add(pcws);
			pcws.add(new Label("SSN"));
			pcws.add(ssnTf);
			pcw.add(pcwa);
			pcwa.add(new Label("Address"));
			pcwa.add(addrTa);

			pcs.add(buyB);
			pcs.add(buyTf);
			pcs.add(sellTf);
			pcs.add(sellB);

	// ************* ��ư �ʱ�ȭ *****************************************
	// ****************************************************************
		buyB.setEnabled(true);
		sellB.setEnabled(true);

		stockTf.setEditable	(false);
		priceTf.setEditable	(false);
		buyTf.setEditable  	(false);

	
		frame.setSize(700, 350);
		frame.setLocation(100, 100);
		frame.setVisible(true);
	}//createGUI() �ݰ�


	// ************** ������ ���� ****************************************
	//*****************************************************************

    public void addListener()
	{
		addB.addActionListener(this);
		deleteB.addActionListener(this);
        updateB.addActionListener(this);
        applyB.addActionListener(this);
		cancelB.addActionListener(this);
		buyB.addActionListener(this);
        sellB.addActionListener(this);
        priceB.addActionListener(this);

		custList.addItemListener(this);
		stockList.addItemListener(this);
        portList.addItemListener(this);               

            
		//***********������ â �ݴ� ����. ***********************************
		//****************************************************************
   		frame.addWindowListener(
			new WindowAdapter()	{	
				public void windowClosing(WindowEvent we){	
					System.exit(0);
				}
			}
		);
	} //addListener() �ݰ�....

	/*
	��ư�� Group(add, delete, update vs apply, cancel)�Ͽ�
	Enable�ǰ� �ϴ� �޼ҵ�
	*/
    public void initButton(boolean b){
		addB.setEnabled(b);
        deleteB.setEnabled(b);
        updateB.setEnabled(b);
		applyB.setEnabled(!b);
		cancelB.setEnabled(!b);
	}
	// name, ssn, address  TextField�� �������¸� �ٲ۴�
	public void textEditable(boolean b)	{
		nameTf.setEditable	(b);
		ssnTf.setEditable	(b);
		addrTa.setEditable	(b);
	}

	//ssn, name, address�� TextFiled ���� clear ��Ų��.
	public void emptyText(){
    	nameTf.setText("");
    	ssnTf.setText("");
    	addrTa.setText("");                              
    }
	//==================================================================
	// Database�� method�� ȣ��
	//==================================================================

		// showList(db.getAllCustomer() , custList )
		/**
		 * 1)customer List area�� �ִ� ���� �����<BR>
		 * 2)CustomerRec[]�� �ִ� ��� CustomerRec ��ü ������ List�� �ѷ��ش�<BR>
		 */
		public void showCustList(ArrayList<CustomerRec> cust, List list){
			list.removeAll();
			for(int i=0; i<cust.size(); i++){
				String ssn = cust.get(i).getSsn();
				String name = cust.get(i).getName();
				String addr = cust.get(i).getAddress();
				list.add(ssn+"  "+name+"  "+addr);
			}			
	    }	
		
		/**
		*argument�� ���� CustomerRec[]�� stockList�� �ϳ��� �ѷ��ش�.<BR>
		 * 1)stock List area�� �ִ� ���� �����.<BR>
		 * 2)StockRec[]�� �ִ� ��� StockRec ��ü ������ List�� �ѷ��ش�.<BR>
		 */
		public void showStockList(ArrayList<StockRec> sr, List list){
			list.removeAll();
			list.setForeground(Color.YELLOW);
			for(int i=0; i<sr.size(); i++){
				String symbol = sr.get(i).getSymbol();
				float price=  sr.get(i).getPrice();
				list.add(symbol +"  "+price);
			}			
		}
	
		 /**
		<PRE>
		 * 1)���ڰ����� �Էµ� VectorŸ���� portfolio ������ �� ����Ʈ�� Stock Portfolio�� �ѷ��ش�.
		 </PRE>
		 */    
		public void showList(Vector portfolio, List list){
			list.removeAll();
			for(int i=0; i<portfolio.size(); i++){
				SharesRec sr = (SharesRec)portfolio.get(i);
				String symbol = sr.getSymbol();
				int quantity = sr.getQuantity();
				list.add(symbol+" "+quantity);
			}			
		}
		
		 /**
		<PRE>
		 * 1)customer List���� ���õ� �׸��߿��� ssn�� Token�Ѵ�
		 * 2)�߶��� ssn���� DB�� getCustomer()�� �̿�. table���� ssn�� �ش��ϴ� ������ ������ �����´�
		 * 3)������ ������ ssn,name,address TextField�� port LIst�� �Ѹ���. 
		 </PRE>
		 * @throws RecordNotFoundException 
		 */    
		public void showCustomer() throws RecordNotFoundException{
			String customer=custList.getSelectedItem();
			StringTokenizer st = new StringTokenizer(customer);
			String ssn = st.nextToken();
			System.out.println(ssn);
			try{
				CustomerRec cr=db.getCustomer(ssn);
				nameTf.setText(cr.getName());
				ssnTf.setText(cr.getSsn());
				addrTa.setText(cr.getAddress());
				Vector<SharesRec> v=cr.getPortfolio();
				if(v !=null){ //�ֽ��� ������ ���̶��...
					showList(v, portList);
				}else{ //�ֽ��� �������� ���� ���̶��...
					portList.removeAll();
				}
			}catch(SQLException e){
				System.out.println("ã�� ���� ������ ���...showCustomer()...");
			}
		} 
		
		 /**
		<PRE>
		 * 1)ssn, symbol, quantity ������ �˾ƿ´� --> ssnTf, buyTf, sellTf�� �ؽ�Ʈ�ڽ��� �Էµ� ��
		 * 2)������ ������ ���ڷ� DB�� buyShares()�� �̿�. 
		 * 3)���� Stock Portfolio�� �ֽ��� ������ ������ �ѷ����� �Ѵ�.
		 </PRE>
		 * @throws RecordNotFoundException 
		 */   
		public void buyStock() throws RecordNotFoundException{
			
			String ssn = ssnTf.getText().trim();
			System.out.println(ssn+"...buyStock()...");
			String symbol = buyTf.getText().trim();
			int quantity = Integer.parseInt(sellTf.getText());
			try{
				db.buyShares(ssn, symbol, quantity);
				showCustomer();//�̰� �����ָ� ��� �Ǵ� �� Ȯ��...
			}catch(SQLException e){
				e.printStackTrace();
			}		
		 } 
	  

		 /**
		<PRE>
		 * 1)ssn, symbol, quantity ������ �˾ƿ´� --> ssnTf, buyTf, sellTf�� �ؽ�Ʈ�ڽ��� �Էµ� ��
		 * 2)������ ������ ���ڷ� DB�� sellShares()�� �̿�. 
		 * 3)���� Stock Portfolio�� �ֽ��� ������ ������ �ѷ����� �Ѵ�.
		 </PRE>
		 * @throws RecordNotFoundException 
		 */   
		public void sellStock() throws RecordNotFoundException{
			String ssn = ssnTf.getText().trim();
			System.out.println(ssn+"...sellStock()...");
			String symbol = buyTf.getText().trim();
			int quantity = Integer.parseInt(sellTf.getText());
			try{
				db.sellShares(ssn, symbol, quantity);
				
			}catch(SQLException e){
				e.printStackTrace();
			}catch(RecordNotFoundException e1){
				System.out.println("�ֽ��� �ȷ��� ����� ���..sellStock()");
			}catch(InvalidTransactionException e2){
				System.out.println("�ȷ��� �ֽ��� �� ���ƿ�...sellStock()");
			}
			showCustomer();//�̰� �����ָ� ��� �Ǵ� �� Ȯ��...
		}
		 
		 /**
		<PRE>
		 * 1)apply button�� ���� ȣ��Ǵ� �޼ҵ�(Add button�� �����ִ�.)
		 * 2)nameTf,ssnTf,addrTa �� �Էµ� ���� �޾ƿ� CustomerRec ��ü�� ����
		 * 3)DB�� addCustomer()�� ȣ���ϰ�
		 * 4)���������� List�� �߰��� ���� ������ ��� ���� ����Ʈ�� �Ѹ���.
		 </PRE>
		 */
		public void addCustomer(){
			String name = nameTf.getText().trim();
			String ssn = ssnTf.getText().trim();
			String address = addrTa.getText().trim();
			CustomerRec cr = new CustomerRec(ssn, name, address);
			
			try{
				db.addCustomer(cr);
				showCustList(db.getAllCustomers(), custList);
			}catch(DuplicateSSNException e){
				System.out.println("�ߺ��Ǵ� �� �־...addCustomer()");
			}catch(SQLException e){
				e.printStackTrace();
			}
	    } 
		 /**
		<PRE>
		 * 1)apply button�� ���� ȣ��Ǵ� �޼ҵ�(Add button�� �����ִ�.)
		 * 2)nameTf,ssnTf,addrTa �� �Էµ� ���� �޾ƿ� CustomerRec ��ü�� ����
		 * 3)DB�� updateCustomer()�� ȣ���ϰ�
		 * 4)���������� List�� ������ ���� ������ ��� ���� ����Ʈ�� �Ѹ���.
		 </PRE>
		 */ 		  
		public void updateCustomer(){
			
			String name = nameTf.getText().trim();
			String ssn = ssnTf.getText().trim();
			String address = addrTa.getText().trim();
			CustomerRec cr = new CustomerRec(ssn, name, address);
			
			try{
				db.updateCustomer(cr);
				showCustList(db.getAllCustomers(), custList);
			}catch(RecordNotFoundException e){
				System.out.println("������ �� ���...updateCustomer()");
			}catch(SQLException e){
				e.printStackTrace();
			}			
	    } 		
		/**
		//delete button�� ���� ȣ��ȴ�.
		 * 1)database�� deleteCustomer(ssn)call<BR>
		 * 2)showList(CustomerRec[],List) ȣ��<BR>
		 * 
		 */
		public void deleteCustomer(){
			String ssn = ssnTf.getText().trim();
			try{
				db.deleteCustomer(ssn);
				ArrayList<CustomerRec> list = db.getAllCustomers();
				showCustList(list, custList);
			}catch(Exception e){
				System.out.println("�����Ϸ��� ���� �����ϴ�. Broker.deleteCustomer() "+e);
			}
	    } 		
		/**
		<PRE>
		*stockList�� ���õ� ������
		*buyTf, sockTf, priceTf TextField�� �ѷ��ش�.
		 * 1)stock List �߿��� ���õ� �׸��� Token�Ѵ�.
		 * 2)symbol,price�� �ش� textfield�� setting �Ѵ�.
		 </PRE>
		 */
		public void showStock(){
			String stock = stockList.getSelectedItem();
			StringTokenizer st = new StringTokenizer(stock);
			String symbol = st.nextToken().trim();
			String price = st.nextToken().trim();
			
			buyTf.setText(symbol);
			stockTf.setText(symbol);
			priceTf.setText(price);
		}

		  /**
		*portList�� ���õ� ������ buy, sell TextField�� �ѷ��ش�.
		 * 1)port List���� ���õ� �׸��� Token�Ѵ�.<BR>
		 * 2)symbol,quantity�� �ش� textfield�� setting�Ѵ�<BR>
		 */
		public void showPortfolio(){
			String portfolio = portList.getSelectedItem();
			StringTokenizer st = new StringTokenizer(portfolio);
			String symbol = st.nextToken();
			String quantity = st.nextToken();
			
			buyTf.setText(symbol);
			sellTf.setText(quantity);
	   	}


	//============================================================
	// Event Handling ó��
	//=============================================================

		 /**
		<PRE>
		 * List������ �ٸ� �������� �����ϸ� call
		 * 1)�� �޼ҵ� ȣ��� ������ 2���� textfield(buy,sell)�� ���¸� null�� �����
		 * 2)�� �޼ҵ带 ȣ���Ų event source��
		 *   customer List�� ��� : showCustomer() method call
		 *   portfolio List�� ��� : showPortfolio() method call
		 *   stock List �� ��� : showStock() method call
		</PRE>
		 */
		public void itemStateChanged(ItemEvent ie) {
			buyTf.setText("");
			sellTf.setText("");
			List list = (List)ie.getSource();
			if(list.equals(custList)){
				try {
					showCustomer();
				} catch (RecordNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(list.equals(stockList)){
				showStock();
			}else{
				showPortfolio();
			}
			
		}
		//Button���� eventHandling
		public void actionPerformed(ActionEvent ae){
			String buttonLabel = ae.getActionCommand();
			if(buttonLabel.equals("ADD")){
				initButton(false);
				textEditable(true);
				emptyText(); 
				nameTf.requestFocus();
				mode = ADD_MODE;
				System.out.println(mode);
			}else if(buttonLabel.equals("DELETE")){
				deleteCustomer();
				emptyText();
			}else if(buttonLabel.equals("UPDATE")){
				initButton(false);
				textEditable(true);
				nameTf.requestFocus();
				mode = UPDATE_MODE;
				System.out.println(mode);
			}else if (buttonLabel.equals("apply"))	{
			
				switch(mode){
					case ADD_MODE:
						addCustomer();
						emptyText();
						textEditable(false);
						initButton(true);
						break;
					case UPDATE_MODE:
						updateCustomer();
						textEditable(false);
						initButton(true);
						break;
				}
			}else if(buttonLabel.equals("cancel")){
				initButton(true);
				emptyText();
				textEditable(false);
			}else if(buttonLabel.equals("Buy")){
				try {
					buyStock();
				} catch (RecordNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sellTf.setText("");
			}else if (buttonLabel.equals("Sell")){
				try {
					sellStock();
				} catch (RecordNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sellTf.setText("");
				System.out.println(0);
			}
		}
	public static void main(String args[])throws Exception {
		Broker broker = new Broker();		
	}
}


