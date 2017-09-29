/*
 *1.  item들이 장바구니에 담겨지는 / 2. 담겨진 모든 Item들을 가지고 오는 비지니스 로직
 *1 ::
 *   1) 이미 담겨져 있는 item을 다시 담을때....수량만 증가시킨다
 *   2) 카트에 담겨져 있지 않는 item을 담을때 ...하나 담아준다.
 *   --> 1), 2) 을 알기위해서는 CartBiz 에 비지니스 로직을 시작하기 전에 반드시 이것!! 부터
 *       작성해야 한다.
 *       :: 
 *       카트에 있는(담겨있는) 모든 item목록들을 다 가져와야 한다.. * 
 */
package cartbiz;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.Item;

public class CartBiz {
	
	
	
	public void addCart(HttpServletRequest request,Item item){
	 //가지고 와야 된다...cart에 담겨진 목록들을...cartList라는 이름으로 바인딩 되어있다하자
		HttpSession session=request.getSession();
		ArrayList<Cart> cartList=(ArrayList<Cart>)session.getAttribute("cartList");
		
		if(cartList==null) cartList = new ArrayList<Cart>();
		boolean newCart = true; //cart가 비었다면
		Cart cart = null;
		//1)지금 선택한 상품이 Cart에 담겨져있는 상품이라면 수량만 중가시키고	
		for(int i=0; i<cartList.size(); i++){
			cart = cartList.get(i);
			if(item.getName().equals(cart.getName())){
				newCart = false;
				cart.setQuantity(cart.getQuantity()+1);
			}//if
		}//for
		
		//2)Cart에 담겨져 있지 않는 상품이라면 Cart에 하나씩 담아준다...	
		if(newCart){
			cart = new Cart();
			cart.setImage(item.getUrl());
			cart.setName(item.getName());
			cart.setPrice(item.getPrice());
			cart.setQuantity(1); //무조건 1이된다.
			cartList.add(cart);
		}//if
		
		//세션에 바인딩....
		session.setAttribute("cartList", cartList);
	}//addCart()
	
	public ArrayList<Cart> getCartList(HttpServletRequest request){
		//session에 바인딩된 cartList정보를 받아와서 리턴,,,
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList=(ArrayList<Cart>)session.getAttribute("cartList");
		return cartList;
	}
	
	public void upCartQty(HttpServletRequest request, String name){
		//세션에 바인딩 되어있는 cartList를 받아와서
		//name에 해당하는 상품의 수량을 1만 증가...
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList=(ArrayList<Cart>)session.getAttribute("cartList");
		
		for(int i=0; i<cartList.size(); i++){
			if(cartList.get(i).getName().equals(name))
				cartList.get(i).setQuantity(cartList.get(i).getQuantity()+1);
		}//for
	}//upCartQty()
	
	public void downCartQty(HttpServletRequest request, String name){
		//세션에 바인딩 되어있는 cartList를 받아와서
		//name에 해당하는 상품의 수량을 1만 감소...
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList=(ArrayList<Cart>)session.getAttribute("cartList");
		
		for(int i=0; i<cartList.size(); i++){
			if(cartList.get(i).getName().equals(name))
				cartList.get(i).setQuantity(cartList.get(i).getQuantity()-1);
		}//for
	}//downCartQty()
	
	//cartList에서 선택된 Cart들을 삭제하는 기능..
	public void removeCartItem(HttpServletRequest request,String[ ] names){
		//cartList에서의 cart의 이름과 names의 이름이 같은 경우에 list에서 해당하는 name을 삭제
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList =(ArrayList<Cart>)session.getAttribute("cartList");
		
		for(int i=0; i<names.length; i++){
			for(int j=0; j<cartList.size(); j++){
				if(names[i].equals(cartList.get(j).getName())){
					cartList.remove(cartList.get(j));
				}//if
			}//for
		}//for
	}//removeCartItem()
}




















