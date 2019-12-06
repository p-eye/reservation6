package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.CommentDao;
import kr.or.connect.reservation.dao.CommentImageDao;
import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.CommentImage;
import kr.or.connect.reservation.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private CommentImageDao commentImageDao;


	@Override
	public List<Comment> getCommentList(int productId) {
		return commentDao.getCommentList(productId);
	}

	@Override
	public List<CommentImage> getCommentImageList(int reservationInfoId) {
		return commentImageDao.getCommentImageList(reservationInfoId);
	}

	
}
