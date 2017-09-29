package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cartbiz.CartBiz;
import model.Item;
import model.ItemDao;

public class ItemCartAddController implements  Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * 1. 장바구니에 추가하고자 하는 Item 객체를 하나 받아온다
		 * 2. 해당 Item을 Cart에 담는다...cartBiz의 addCart() 호출
		 * 3. itemCartList.do로  페이지를 이동...ItemCartListController
		 *                  (itemCartList.jsp 로 페이지이동)
		 *    이때 redirect 방식으로 이동하도록 세팅한다.
		 */
		int itemid = Integer.parseInt(request.getParameter("itemid"));
		Item item=ItemDao.getInstance().getItem(itemid);
		
		//장바구니 로직을 호출하기 위해서 CartBiz 객체를 생성
		CartBiz  cartBiz = new CartBiz();
		cartBiz.addCart(request, item); //장바구니에 알아서 들어감..
		
		ModelAndView mv = new ModelAndView();
		mv.setUrl("itemCartList.do");
		mv.setRedirect(true);
		return mv;
	}

}






















