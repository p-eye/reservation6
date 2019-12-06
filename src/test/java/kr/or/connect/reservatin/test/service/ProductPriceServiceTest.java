package kr.or.connect.reservatin.test.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.service.ProductPriceService;

public class ProductPriceServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		ProductPriceService productPriceService = ac.getBean(ProductPriceService.class);

		/* getProductPriceList */
		List<ProductPrice> productPriceList = productPriceService.getProductPriceList(2);

		for (ProductPrice productPrice : productPriceList) {
			System.out.println(productPrice);
		}

	}

}
