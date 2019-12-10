package kr.or.connect.reservatin.test.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dao.CommentDao;

public class CommentDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		CommentDao commentDao = ac.getBean(CommentDao.class);

		/* getCommentList */

		/*
		List<Comment> commentList = commentDao.getCommentList(1);

		for (Comment comment : commentList) {
			System.out.println(comment);
		}

		*/
		/* getCommentAvg */
		System.out.println(commentDao.getCommentAverageScore(1));
		
		/* getCommentResponse */
		System.out.println(commentDao.getCommentResponse(3));
	}

}
