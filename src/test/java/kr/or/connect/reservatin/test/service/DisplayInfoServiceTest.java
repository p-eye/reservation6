package kr.or.connect.reservatin.test.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.service.DisplayInfoService;

public class DisplayInfoServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		DisplayInfoService displayInfoService = ac.getBean(DisplayInfoService.class);

		/* getDisplayInfo */
		//System.out.println(displayInfoService.getDisplayInfo(59));
		
		/* getDisplayInfoImage */
		//System.out.println(displayInfoService.getDisplayInfoImage(59));
		
		/*getDisplayInfoResponse */
		System.out.println(displayInfoService.getDisplayInfoResponse(27));
		
	}

}
