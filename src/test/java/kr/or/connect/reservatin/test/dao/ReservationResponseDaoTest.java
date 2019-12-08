package kr.or.connect.reservatin.test.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dao.ReservationResponseDao;

public class ReservationResponseDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		ReservationResponseDao reservationResponseDao = ac.getBean(ReservationResponseDao.class);

		/* getResrvationResponse */
		System.out.println(reservationResponseDao.getReservationResponse(3));


	}

}
