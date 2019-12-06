package kr.or.connect.reservatin.test.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dao.ProductImageDao;
import kr.or.connect.reservation.dto.ProductImage;

public class ProductImageDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		ProductImageDao productImageDao = ac.getBean(ProductImageDao.class);

		/* getProductImageList */
		List<ProductImage> productImageList = productImageDao.getProductImageList(38);

		for (ProductImage productImage : productImageList) {
			System.out.println(productImage);
		}
	}

}
