package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cartbiz.CartBiz;

public class ItemCartRemoveController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		String[ ] names=request.getParameterValues("delete");
		CartBiz cartBiz = new CartBiz();
		cartBiz.removeCartItem(request, names);
		
		ModelAndView mv = new ModelAndView();
		mv.setUrl("itemCartList.do");
		mv.setRedirect(true);
		return mv;
	}
}











