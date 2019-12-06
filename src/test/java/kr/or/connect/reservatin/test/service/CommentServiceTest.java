package kr.or.connect.reservatin.test.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservation.config.ApplicationConfig;
import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.service.CommentService;

public class CommentServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		CommentService commentService = ac.getBean(CommentService.class);

		/* getCommentList */

		List<Comment> commentList = commentService.getCommentList(2);

		for (Comment comment : commentList) {
			System.out.println(comment);
		}
	}

}
