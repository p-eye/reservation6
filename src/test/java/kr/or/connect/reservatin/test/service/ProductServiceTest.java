package kr.or.connect.reservatin.test.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;
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
		 System.out.println(productService.getProductResponseByCategoryId(0, 0));
		 
		/* getProductPriceList */
		List<ProductPrice> productPriceList = productService.getProductPriceList(38);

		for (ProductPrice productPrice : productPriceList) {
			System.out.println(productPrice);
		}
		
		/* getProductImageList */
		List<ProductImage> productImageList = productService.getProductImageList(38);

		for (ProductImage productImage : productImageList) {
			System.out.println(productImage);
		}

	}

}
