package kr.or.connect.reservatin.test.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.service.MatchingService;

public class MatchingServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		MatchingService matchingService = ac.getBean(MatchingService.class);

		/*matchReservationInfo*/
		System.out.println(matchingService.matchReservationInfo(1, "kimjinsu@connect.co.kr"));
		
	}

}
