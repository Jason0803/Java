package reference.test;

import reference.vo.ProductVO;

public class ProductArrayTest {

	public static void main(String[] args) {
		ProductVO[] pros = {
				new ProductVO(111, "Drum", "DaeWoo", 4500),
				new ProductVO(231, "Washer", "DaeWoo", 1000),
				new ProductVO(171, "Drum", "LG Elec.", 4500),
				new ProductVO(281, "Washer", "Samsung", 1600)
		};
		
		/*
		for(ProductVO temp : pros ){
			System.out.println(temp.getModel());
		}
		*/
		
		System.out.println("====== Products more expensive than 1000 ======");
		for(ProductVO temp : pros) {
			if(temp.getPrice() > 1500)
				temp.display();
		}
		
	}

}
