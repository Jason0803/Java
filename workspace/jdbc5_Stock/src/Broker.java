import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.StringTokenizer;
import java.sql.*;

//인터페이스 implements 한 상태로 클래스 선언하자
public class Broker {
	private static int mode = 0;
	private static final int ADD_MODE = 1;
	private static final int UPDATE_MODE = 2;

	//Database 		db;

	Frame 	frame =new Frame("ABC Stock");

	//*************컴포넌트 선언...생성 *****************
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

	// **************** 생성자 **************************************
	//*****************************************************************
	public Broker() {
		/*
	   try	{	    
	    db =  new Database("127.0.0.1");
		} catch(ClassNotFoundException cnfe) {
			System.out.println("Broker Constructor : " + cnfe);
	} catch(SQLException sqle) {
		System.out.println("Broker Constructor : " + sqle);
	}
	*/
		createGUI();
	//	addListener();

	//	showList(db.getAllCustomers(),custList);
	//	showList(db.getAllStocks(),stockList);
	
		initButton(true);
		emptyText();
		textEditable(false);

	}//생성자 닫고...

	// **********배경색, 전경색 지정 ***************
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
		// *******************  컴포넌트 부착  *******************************
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

	// ************* 버튼 초기화 *****************
	// *********************************************
		buyB.setEnabled(true);
		sellB.setEnabled(true);

		stockTf.setEditable	(false);
		priceTf.setEditable	(false);
		buyTf.setEditable  	(false);

	
		frame.setSize(700, 350);
		frame.setLocation(100, 100);
		frame.setVisible(true);
	}//createGUI() 닫고


	// ************** 리스너 부착 *************************
	//********************************************************
	/*
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

            
		//***********프레임 창 닫는 로직. **************
		//**************************************************
   		frame.addWindowListener(
			new WindowAdapter()	{	
				public void windowClosing(WindowEvent we){	
					System.exit(0);
				}
			}
		);
	} //addListener() 닫고....
	*/
	/*
	버튼을 Group(add, delete, update vs apply, cancel)하여
	Enable되게 하는 메소드
	*/
    public void initButton(boolean b){
		addB.setEnabled(b);
        deleteB.setEnabled(b);
        updateB.setEnabled(b);
		applyB.setEnabled(!b);
		cancelB.setEnabled(!b);
	}
	// name, ssn, address  TextField의 편집상태를 바꾼다
	public void textEditable(boolean b)	{
		nameTf.setEditable	(b);
		ssnTf.setEditable	(b);
		addrTa.setEditable	(b);
	}

	//ssn, name, address의 TextFiled 값을 clear 시킨다.
	public void emptyText(){
    	nameTf.setText("");
    	ssnTf.setText("");
    	addrTa.setText("");                              
    }
	public static void main(String args[]) {
		Broker broker = new Broker();		
	}
}


