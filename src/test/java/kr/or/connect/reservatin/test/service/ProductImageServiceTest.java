package kr.or.connect.reservatin.test.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.service.ProductImageService;

public class ProductImageServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		ProductImageService productImageService = ac.getBean(ProductImageService.class);

		/* getProductImageList */
		List<ProductImage> productImageList = productImageService.getProductImageList(2);

		for (ProductImage productImage : productImageList) {
			System.out.println(productImage);
		}
	}

}
