package file.step3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import file.step3.test.ChattingSaveService;

public class ActionHandler implements ActionListener {
	public ChattingSaveService service;
	public ActionHandler(ChattingSaveService service){
		this.service = service;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String message=service.tf.getText();
		if("".equals(message)) return;
		service.ta.append("\n"+message);
		service.tf.setText("");
		service.tf.requestFocus();
	}
}















