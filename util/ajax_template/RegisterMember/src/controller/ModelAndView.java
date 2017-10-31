package controller;

public class ModelAndView {
	private String path="index.jsp";//이동경로 
	private boolean isRedirect;//이동방식 --> false 로 기본 초기화
	public ModelAndView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModelAndView(String path) {
		super();
		this.path = path;
	}
	public ModelAndView(String path, boolean isRedirect) {
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
}







