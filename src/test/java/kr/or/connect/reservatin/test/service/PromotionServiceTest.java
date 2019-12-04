package kr.or.connect.reservatin.test.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.service.PromotionService;

public class PromotionServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		PromotionService promotionService = ac.getBean(PromotionService.class);

		/* getPromotionList */
		System.out.println(promotionService.getPromotionList());
		
		/* getPromotionResponse */
		System.out.println(promotionService.getPromotionResponse());

	}

}
