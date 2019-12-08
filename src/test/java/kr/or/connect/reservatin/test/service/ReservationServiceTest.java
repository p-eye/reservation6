package kr.or.connect.reservatin.test.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.dto.ReservationPrice;
import kr.or.connect.reservation.service.ReservationService;

public class ReservationServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		ReservationService reservationService = ac.getBean(ReservationService.class);

		/* getReservationInfoService */
		List<ReservationInfo> reservationInfoList = reservationService.getReservationInfoList("kimjinsu@connect.co.kr");

		for (ReservationInfo reservationInfo : reservationInfoList) {
			System.out.println(reservationInfo);

		}
		System.out.println("======================================");

		/* getReservationTotalPrice */
		System.out.println(reservationService.getReservationTotalPrice(4));
		System.out.println("======================================");

		/* getReservationInfoResponse */
		System.out.println(reservationService.getReservationInfoResponse("kimjinsu@connect.co.kr"));
		System.out.println("======================================");

		/* getReservationPrice */
		List<ReservationPrice> reservationPriceList = reservationService.getReservationPriceList(5);

		for (ReservationPrice reservationPrice : reservationPriceList) {
			System.out.println(reservationPrice);

		}
		System.out.println("======================================");

		/* getReservationResponse */
		System.out.println(reservationService.getReservationResponse(3));
		System.out.println("======================================");
	}

}
