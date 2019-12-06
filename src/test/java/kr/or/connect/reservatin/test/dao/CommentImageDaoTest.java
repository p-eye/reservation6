package kr.or.connect.reservatin.test.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dao.CommentImageDao;

public class CommentImageDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		CommentImageDao commentImageDao = ac.getBean(CommentImageDao.class);

		/* getCommentImageList*/
		System.out.println(commentImageDao.getCommentImageList(2));
		

	}

}
