package kr.or.connect.reservatin.test.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.service.CommentImageService;

public class CommentImageServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		CommentImageService commentImageService = ac.getBean(CommentImageService.class);

		/* getCommentImageList */
		System.out.println(commentImageService.getCommentImageList(2));

	}

}
