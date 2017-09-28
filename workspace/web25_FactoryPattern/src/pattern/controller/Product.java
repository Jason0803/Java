package pattern.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Product {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
