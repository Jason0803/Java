package vo.diary;

import java.util.Arrays;
import java.util.Date;

import util.CocoaDate;

public class Schedule extends Diary {
	private String title;
	private String content;
	private String[] groupMemberID;
	private CocoaDate startDate;
	private CocoaDate endDate;
	
	public Schedule() {
		super();
	}
	
	public Schedule(int no, String id, String title, String content, String[] groupMemberID, CocoaDate startDate, CocoaDate endDate) {
		super(no, id);
		this.title = title;
		this.content = content;
		this.groupMemberID = groupMemberID;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Schedule(String id, String title, String content, String[] groupMemberID, CocoaDate startDate,
			CocoaDate endDate) {
		super(id);
		this.title = title;
		this.content = content;
		this.groupMemberID = groupMemberID;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Schedule(int no, String id) {
		super(no, id);
	}
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String[] getGroupMemberID() {
		return groupMemberID;
	}
	public void setGroupMemberID(String[] groupMemberID) {
		this.groupMemberID = groupMemberID;
	}
	public CocoaDate getStartDate() {
		return startDate;
	}
	public void setStartDate(CocoaDate startDate) {
		this.startDate = startDate;
	}
	public CocoaDate getEndDate() {
		return endDate;
	}
	public void setEndDate(CocoaDate endDate) {
		this.endDate = endDate;
	}
	
	@Override
	public String toString() {
		return "Schedule [title=" + title + ", content=" + content + ", groupMemberID=" + Arrays.toString(groupMemberID)
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	
	
}
