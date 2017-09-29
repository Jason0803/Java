package controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDao;

public class ItemListController implements  Controller{
	/*
	 biz logic call
	 바인딩
	 view 페이지를 지정....mv에 담는다.
	 */
	@Override
	public ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		 
		 ArrayList<Item> list= ItemDao.getInstance().getAllItems();
		 request.setAttribute("list", list);
		 ModelAndView mv = new ModelAndView();
		 mv.setUrl("itemList.jsp");//forward 방식으로 지정됨...
		return mv;
	}

}















