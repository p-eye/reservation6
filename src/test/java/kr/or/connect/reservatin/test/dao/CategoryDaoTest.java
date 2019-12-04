package kr.or.connect.reservatin.test.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dao.CategoryDao;

public class CategoryDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		 CategoryDao categoryDao = ac.getBean(CategoryDao.class);
		 
		 /*getCategoryList*/
		 System.out.println(categoryDao.getCategoryList());
		 

		 
	}
	

}
