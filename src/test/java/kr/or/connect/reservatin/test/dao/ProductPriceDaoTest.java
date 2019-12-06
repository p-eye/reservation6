package kr.or.connect.reservatin.test.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dao.ProductPriceDao;
import kr.or.connect.reservation.dto.ProductPrice;

public class ProductPriceDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		ProductPriceDao productPriceDao = ac.getBean(ProductPriceDao.class);

		/* getProductPriceList */
		List<ProductPrice> productPriceList = productPriceDao.getProductPriceList(38);

		for (ProductPrice productPrice : productPriceList) {
			System.out.println(productPrice);
		}
	}

}
