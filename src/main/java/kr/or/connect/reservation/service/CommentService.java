package kr.or.connect.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.CommentImage;

@Service
public interface CommentService {
	
	public List<Comment> getCommentList(int productId);

	public List<CommentImage> getCommentImageList(int reservationInfoId);
}
