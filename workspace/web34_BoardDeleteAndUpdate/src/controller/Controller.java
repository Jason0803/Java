package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ModelAndView;

public interface Controller {
	public ModelAndView handlerRequest(HttpServletRequest request, HttpServletResponse response)
							throws Exception;
}
