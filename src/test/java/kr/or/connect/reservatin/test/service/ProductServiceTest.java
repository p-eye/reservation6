package kr.or.connect.reservatin.test.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductResponse;
import kr.or.connect.reservation.service.ProductService;

public class ProductServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		ProductService productService = ac.getBean(ProductService.class);

		/* getProductListByCategoryId */
		/*
		List<Product> productList = productService.getProductListByCategoryId(2, 4);

		for (Product product : productList) {
			System.out.println(product);
			System.out.println("==========");

		}
		*/
		
		
		/*getProductResponseByCategoryId */
		 System.out.println(productService.getProductResponseByCategoryId(1, 0));
	}

}
