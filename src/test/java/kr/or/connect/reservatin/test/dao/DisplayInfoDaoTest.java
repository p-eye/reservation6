package kr.or.connect.reservatin.test.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dao.DisplayInfoDao;

public class DisplayInfoDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		DisplayInfoDao displayInfoDao = ac.getBean(DisplayInfoDao.class);

		/* getDislayInfo : EmptyResultDataAccessException 테스트*/
		System.out.println(displayInfoDao.getDisplayInfo(1000));
		

	}

}
