package kr.or.connect.reservatin.test.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dao.CommentDao;
import kr.or.connect.reservation.dto.Comment;

public class CommentDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		CommentDao commentDao = ac.getBean(CommentDao.class);

		/* getCommentList*/
		
		List<Comment> commentList = commentDao.getCommentList(1);
		
		for(Comment comment: commentList) {
			System.out.println(comment);
		}
	}

}
