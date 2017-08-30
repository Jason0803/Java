package file.step3;
import java.awt.FileDialog;
/*
 * save 버튼을 클릭하면
 * 기본에 나눴던 대화내용을(TextArea에 append되어진 모든 내용들)
 * 특정한 경로의 파일로 저장하는 로직
 * ::
 * FileDialog 클래스를 사용하면 효율적이다.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		
		/*
		 * 1. fd를 이용해서 해당경로와 파일명을 알아낸다.
		 * 2. fileName을 String으로 지정할수 있다.
		 * 3. 출력용 스트림 생성
		 * 4. 읽어들인다. ta에 있는 내용을
		 * 5. 뿌린다...생성된 파일로
		 --> writeFileCreate()을 여기서 호출하자.
		 * 6. 열어서 사용한 자원을 닫는다.
		 */
		
		
	}
	
	public void writeFileCreate(String path)throws IOException{
		
	}
}











