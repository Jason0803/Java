package sql;

public interface StringQuery {
	String INSERT_POSTING = 
			"INSERT INTO board (no, title, writer, password, content, time_posted)"+
	" VALUES(board_seq.nextVal,?,?,?,?,sysdate)";
	
	String CURRENT_NO = 
			"SELECT board_seq.currVal FROM dual";
	
	String SELECT_POSTING = 
			"SELECT no, title, writer, content, hits, time_posted FROM board WHERE  no=?";
	
	String PAGE_LIST = "SELECT no, title, writer, hits, to_char(time_posted, 'YYYY.MM.DD') time_posted FROM board";
	
	String PASS_CHECK =" SELECT COUNT(-1) FROM board WHERE no=? AND password=?";
	String DELETE_POSTING="DELETE FROM board WHERE no=?";
}





























