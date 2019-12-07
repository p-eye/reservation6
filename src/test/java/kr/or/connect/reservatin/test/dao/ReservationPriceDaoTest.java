package kr.or.connect.reservatin.test.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dao.ReservationPriceDao;
import kr.or.connect.reservation.dto.ReservationPrice;

public class ReservationPriceDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		ReservationPriceDao reservationPriceDao = ac.getBean(ReservationPriceDao.class);

		/* getResrvationPriceList */
		List<ReservationPrice> reservationPriceList = reservationPriceDao.getReservationPriceList(5);

		for (ReservationPrice reservationPrice : reservationPriceList) {
			System.out.println(reservationPrice);
			System.out.println("==========");

		}
		
		/*getReservationTotalPrice */
		System.out.println(reservationPriceDao.getReservationTotalPrice(1));

	}

}
