package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cartbiz.CartBiz;

public class ItemCartQtyUpController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * CartBiz에서 biz()....up
		 */
		String name = request.getParameter("name");
		CartBiz cartBiz = new CartBiz();
		cartBiz.upCartQty(request, name);
		
		ModelAndView mv = new ModelAndView();
		mv.setUrl("itemCartList.do");
		mv.setRedirect(true);
		return mv;
	}

}














