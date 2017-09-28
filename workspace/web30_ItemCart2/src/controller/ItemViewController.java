package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDao;

public class ItemViewController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int itemnumber = Integer.parseInt(request.getParameter("itemnumber"));
		
		boolean result = ItemDao.getInstance().updateRecordCount(itemnumber);
		System.out.println("count update...."+result);
		
		Item item=ItemDao.getInstance().getItem(itemnumber);
		System.out.println("get item...."+item);
		
		request.setAttribute("item", item);
		ModelAndView mv = new ModelAndView();
		mv.setUrl("itemView.jsp");
		return mv;
	}

}
















