package kr.or.connect.reservatin.test.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.service.CategoryService;

public class CategoryServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		CategoryService categoryService = ac.getBean(CategoryService.class);

		/* getCategoryList */
		System.out.println(categoryService.getCategoryList());
		
		/*getCategoryResponse*/
		System.out.println(categoryService.getCategoryResponse());
	}

}
