package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cart;
import cartbiz.CartBiz;

public class ItemCartListController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CartBiz cartBiz = new CartBiz();
		ArrayList<Cart> cartList=cartBiz.getCartList(request);
		
		
		//for문을 돌면서 각각의 Cart/sumMoney를 뽑아야 한다.
		int sumMoney = 0;
		for(int i=0; i<cartList.size(); i++){
			int money = cartList.get(i).getPrice()*cartList.get(i).getQuantity();
			sumMoney += money;
		}
		request.setAttribute("cartSize", cartList.size());
		request.setAttribute("sumMoney", sumMoney);
		request.setAttribute("cartList", cartList);
		
		ModelAndView mv = new ModelAndView();
		mv.setUrl("itemCartList.jsp"); //포워딩 방식
		//itemCartList.jsp
		return mv;
	}

}












