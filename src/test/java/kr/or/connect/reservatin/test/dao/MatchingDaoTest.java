package kr.or.connect.reservatin.test.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dao.MatchingDao;

public class MatchingDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		MatchingDao matchingDao = ac.getBean(MatchingDao.class);

		/* matchComment */
		System.out.println(matchingDao.matchComment(3, 3));
		
		
		/*matchReservatinInfo*/
		System.out.println(matchingDao.matchReservationInfo(1,2));

	}

}
