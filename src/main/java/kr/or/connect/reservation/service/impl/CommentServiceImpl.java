package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.CommentDao;
import kr.or.connect.reservation.dao.CommentImageDao;
import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.CommentImage;
import kr.or.connect.reservation.dto.CommentParam;
import kr.or.connect.reservation.dto.CommentResponse;
import kr.or.connect.reservation.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;

	@Autowired
	private CommentImageDao commentImageDao;

	@Override
	public List<Comment> getCommentList(int productId) {
		List<Comment> commentList = commentDao.getCommentList(productId);

		//Each Comment
		for (Comment comment : commentList) {
			int reservationInfoId = comment.getReservationInfoId();
			comment.setCommentImages(getCommentImageList(reservationInfoId));
		}

		return commentList;
	}

	@Override
	public double getAverageScore(int productId) {
		return commentDao.getCommentAverageScore(productId);
	}

	@Override
	public List<CommentImage> getCommentImageList(int reservationInfoId) {
		return commentImageDao.getCommentImageList(reservationInfoId);
	}
	
	@Override
	public CommentResponse getCommentResponse(int commentId) {
		return commentDao.getCommentResponse(commentId);
	}
	
	@Override
	public CommentImage getCommentImage(int commentId) {
		return commentImageDao.getCommentImage(commentId);
	}
	
	@Override
	public CommentResponse insertCommentAndImage(CommentParam commentParam) {
		///insert~~~
		int commentId = commentDao.insertComment(commentParam);
		
		
		CommentResponse commentResponse = commentDao.getCommentResponse(commentId);
	//	commentResponse.setCommentImage(commentImage);
		return commentResponse;
	}

}
