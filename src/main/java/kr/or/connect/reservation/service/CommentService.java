package kr.or.connect.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.CommentImage;
import kr.or.connect.reservation.dto.CommentParam;
import kr.or.connect.reservation.dto.CommentResponse;

@Service
public interface CommentService {

	public List<Comment> getCommentList(int productId);

	public double getAverageScore(int productId);

	public List<CommentImage> getCommentImageList(int reservationInfoId);

	public CommentResponse getCommentResponse(int commentId);

	public CommentImage getCommentImage(int commentId);

	public CommentResponse insertCommentAndImage(CommentParam commentParam);

}
