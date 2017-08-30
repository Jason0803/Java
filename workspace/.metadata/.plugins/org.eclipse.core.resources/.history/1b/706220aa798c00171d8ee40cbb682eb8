package file.step3.test;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import file.step3.ActionHandler;
import file.step3.FileSaveHandler;

public class ChattingSaveService {
	//1.gui구성
	
	public Frame f;
	public Panel p;
	public TextField tf;
	public TextArea ta;
	public Button save;
	public String nickName;
	
	public ChattingSaveService(String nickName){//객체 생성시 닉네임 받아온다
		this.nickName = nickName;
		f = new Frame("Chatting Room...");
		p = new Panel();
		tf = new TextField(50);
		ta = new TextArea();
		save = new Button("SAVE");		
	}
	public void launchFrame(){
		f.setSize(500,300);
		p.add(tf);
		p.add(save);
		f.add(ta, "Center");
		f.add(p,"South");
		
		f.setResizable(false);
		ta.setEditable(false);
		ta.setBackground(Color.LIGHT_GRAY);
		ta.setText("["+nickName+"] 님이 입장하셨습니다.");
		f.setVisible(true);
		
		tf.requestFocus();
		
		//프레임 창닫는 로직
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//2.
		tf.addActionListener(new ActionHandler(this));
		save.addActionListener(new FileSaveHandler(this));
	}
	public static void main(String[] args) {
		ChattingSaveService service = new ChattingSaveService("하바리");
		service.launchFrame();

	}
}











