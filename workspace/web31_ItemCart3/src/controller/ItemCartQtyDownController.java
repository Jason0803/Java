package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cartbiz.CartBiz;

public class ItemCartQtyDownController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		CartBiz cartBiz = new CartBiz();
		cartBiz.downCartQty(request, name);
		
		ModelAndView mv = new ModelAndView();
		mv.setUrl("itemCartList.do");
		mv.setRedirect(true);
		return mv;
	}

}
