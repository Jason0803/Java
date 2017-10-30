package sql;

public interface StringQuery {
	/*
	 * Diary No 시퀀스 생성.
	 * 컬럼명 : seq_diary_no
	 * 다이어리 번호 부여방법 : INSERT 구문 사용시 no 컬럼에 seq_diary_no.NEXTVAL 기입
	 * - K
	 */
	
	// ----------------------------------- MemberDAO -------------------------------------- //
	String REGISTER_MEMBER =
			"INSERT INTO member VALUES(?,?,?,?,?)";
	String ISEXIST_MEMBER =
			"SELECT id FROM member WHERE id = ?";
	String CHECK_VALIDATION = 
			"SELECT password FROM member WHERE id = ?";
	String UPDATE_MEMBER =
			"UPDATE member SET password=?, name=?, acc_plan=?, theme=? where id=?";
	String GET_MEMBER_INFO =
			"SELECT * FROM member where id=?";
	
	// ------------------------------------------------------- DiaryDAO ------------------------------------------------------- //
	String GET_ALL_MEMO = 
			"SELECT * FROM memo WHERE id = ? ORDER BY wrt_date DESC";
	String GET_ALL_SCHEDULE =
			"SELECT * FROM schedule WHERE id = ? ORDER BY start_date DESC";
	String GET_ALL_NOTE =
			"SELECT * FROM note WHERE id = ? ORDER BY wrt_date DESC";

	String SEARCH_NOTE_BY_KEYWORD = 
			"SELECT * FROM note WHERE id = ? AND (title LIKE '%'||?||'%' OR content LIKE '%'||?||'%')";
	String SEARCH_MEMO_BY_KEYWORD =
			"SELECT * FROM memo WHERE id=? AND content LIKE '%'||?||'%'";
	String SEARCH_SCHEDULE_BY_KEYWORD = 
	         "SELECT * FROM SCHEDULE WHERE id=? AND (TITLE like '%'||?||'%' OR CONTENT like '%'||?||'%')";

	String GET_CURR_DIARYNO =
			 "SELECT last_number FROM user_sequences WHERE sequence_name='SEQ_DIARY_NO'";
	String WRITE_MEMO = 
			 "INSERT INTO memo (memo_no, id, content, wrt_date) VALUES(seq_diary_no.nextVal, ?, ?, to_date(?, 'YYYYMMDDHH24MI'))";
	String WRITE_NOTE = 
			 "INSERT INTO note (note_no, id, title, content, wrt_date, curr_date) "
			 + "VALUES(seq_diary_no.nextVal, ?, ?, ?, to_date(?, 'YYYYMMDDHH24MI'), to_date(?, 'YYYYMMDDHH24MI'))";
	String WRITE_SCHEDULE = 
			"INSERT INTO schedule (schedule_no, id, to_date(start_date), to_date(end_date), title, content) "
			+ "VALUES(seq_diary_no.nextVal, ?, ?, ?, ?, ?)";
	String WRITE_SCHEDULE_GROUP = "INSERT INTO schedule_group (schedule_no, group_member_id) VALUES(?, ?)";
	
	
	
	String GET_DAILY_NOTE_BY_ID = 
			 "SELECT * FROM note WHERE id=? AND to_char(wrt_date, 'YYYYMMDD')=?";
	String GET_DAILY_SCHEDULE_BY_ID = 
			 "SELECT * FROM schedule WHERE id=? AND to_char(start_date, 'YYYYMMDD')=?";
	String GET_NOTE_BY_NO = 
			"SELECT * FROM note WHERE note_no=?";
	String GET_SCHEDULE_BY_NO =
			"SELECT * FROM Schedule WHERE Schedule_no=?"; 
	String UPDATE_NOTE = 
			"UPDATE note SET title = ?, content = ?, curr_date = sysdate WHERE note_no = ?";
	String UPDATE_SCHEDULE = 
			"UPDATE schedule SET title = ?, content = ?, start_date = to_date(?, 'YYYYMMDDHH24MI'), end_date = to_date(?,'YYYYMMDDHH24MI') WHERE schedule_no = ?";

	
	
	
	String DELETE_SCHEDULE_BY_NO =
			"DELETE schedule WHERE schedule_no=?"; 

	String DELETE_MEMO_BY_NO =
			"DELETE memo WHERE MEMO_NO=?"; 

	String DELETE_NOTE_BY_NO =
			"DELETE note WHERE note_no=?";

	
	String GET_CURR_NOTE_NO = 
			"SELECT note_no FROM note WHERE wrt_date = (SELECT MAX(wrt_date) FROM note)";
	
}