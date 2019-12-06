package kr.or.connect.reservatin.test.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dao.DisplayInfoImageDao;

public class DisplayInfoImageDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		DisplayInfoImageDao displayInfoImageDao = ac.getBean(DisplayInfoImageDao.class);

		/* getDislayInfoImage*/
		System.out.println(displayInfoImageDao.getDisplayInfoImage(59));
		

	}

}
