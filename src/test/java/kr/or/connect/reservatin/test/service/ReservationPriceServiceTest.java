package kr.or.connect.reservatin.test.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.ReservationPrice;
import kr.or.connect.reservation.service.ReservationPriceService;

public class ReservationPriceServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		ReservationPriceService reservationPriceService = ac.getBean(ReservationPriceService.class);

		/* getReservationPriceService */

		List<ReservationPrice> reservationPriceList = reservationPriceService.getReservationPriceList(5);

		for (ReservationPrice reservationPrice : reservationPriceList ) {
			System.out.println(reservationPrice);

		}
	}

}
