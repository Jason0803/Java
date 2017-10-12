package controller;
/*
 * 서버상에서 이동할 페이지와 이동방식의 정보를 가지고 있음.
 */
public class ModelAndView {
	private String path;
	private boolean isRedirect;
	
	public ModelAndView(String path, boolean isRedirect) {
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}
	public ModelAndView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModelAndView(String path) {
		super();
		this.path = path;
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







