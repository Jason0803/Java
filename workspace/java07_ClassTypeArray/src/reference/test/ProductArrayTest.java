package reference.test;

import reference.vo.ProductVO;
import reference.service.ProductService;

public class ProductArrayTest {

	public static void main(String[] args) {
		ProductVO[] pros = {
				new ProductVO(111, "Drum", "DaeWoo", 4500),
				new ProductVO(231, "Washer", "DaeWoo", 1000),
				new ProductVO(171, "Drum", "LG Elec.", 4500),
				new ProductVO(281, "Washer", "Samsung", 1600)
		};
		
		ProductService service = new ProductService();
		service.displayAll(pros);
		System.out.println("============ Total Price ============");
		System.out.println(service.totalPrice(pros));
		System.out.println("============ Average Price ============");
		System.out.println(service.averagePrice(pros));
		System.out.println("============ Product(s) Over Average ============");
		System.out.println(service.getProductsOverAverage(pros));
		service.getProductWithMaker(pros, "DaeWoo");
		/*
		for(ProductVO temp : pros ){
			System.out.println(temp.getModel());
		}
		*/
		

		
	}

}
