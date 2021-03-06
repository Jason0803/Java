package file.step3;
import java.awt.FileDialog;
/*
 * save ��ư�� Ŭ���ϸ�
 * �⺻�� ������ ��ȭ������(TextArea�� append�Ǿ��� ��� �����)
 * Ư���� ����� ���Ϸ� �����ϴ� ����
 * ::
 * FileDialog Ŭ������ ����ϸ� ȿ�����̴�.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import file.step3.test.ChattingSaveService;

public class FileSaveHandler implements ActionListener {
	public ChattingSaveService service;
	public FileSaveHandler(ChattingSaveService service){
		this.service = service;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		FileDialog fd = new FileDialog(service.f, "파일저장", FileDialog.SAVE);
		fd.setVisible(true);
		
		String fileName = fd.getDirectory() + fd.getFile();
		try{
			File file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			writeFileCreate(fileName);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			}
		
	}
	
	public void writeFileCreate(String path)throws IOException{
		FileWriter fw = new FileWriter(path);
		BufferedWriter bw = new BufferedWriter(fw);
		
		String chats = service.ta.getText();
		
		bw.write(chats);
		
		bw.close();
	}
}











