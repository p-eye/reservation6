package kr.or.connect.reservatin.test.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.service.DisplayInfoImageService;

public class DisplayInfoImageServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		DisplayInfoImageService displayInfoImageService = ac.getBean(DisplayInfoImageService.class);

		/* getDisplayInfoImage */
		System.out.println(displayInfoImageService.getDisplayInfoImage(59));
	}

}
