package kr.or.connect.reservatin.test.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dto.Product;

public class ProductDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		ProductDao productDao = ac.getBean(ProductDao.class);

		/* getProductListByCategoryId */
		List<Product> productList = productDao.getProductListByCategory(2, 4, 4);

		for (Product product : productList) {
			System.out.println(product);
			System.out.println("==========");

		}

		/* getProduct */
		System.out.println(productDao.getProduct(42));
	}

}
