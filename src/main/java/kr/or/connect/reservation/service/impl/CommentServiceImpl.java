package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.or.connect.reservation.dao.CommentDao;
import kr.or.connect.reservation.dao.CommentImageDao;
import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.CommentImage;
import kr.or.connect.reservation.dto.param.CommentParam;
import kr.or.connect.reservation.dto.response.CommentResponse;
import kr.or.connect.reservation.service.CommentService;
import kr.or.connect.reservation.service.FileService;

@Service
public class CommentServiceImpl implements CommentService {

	private final CommentDao commentDao;
	private final CommentImageDao commentImageDao;
	private final FileService fileService;

	@Autowired
	public CommentServiceImpl(CommentDao commentDao, CommentImageDao commentImageDao, FileService fileService) {
		this.commentDao = commentDao;
		this.commentImageDao = commentImageDao;
		this.fileService = fileService;
	}

	/* get */

	@Override
	public List<Comment> getCommentList(int productId) {
		List<Comment> commentList = commentDao.getCommentList(productId);

		// Each Comment
		for (Comment comment : commentList) {
			int reservationInfoId = comment.getReservationInfoId();
			comment.setCommentImages(getCommentImageList(reservationInfoId));
		}

		return commentList;
	}

	@Override
	public List<CommentImage> getCommentImageList(int reservationInfoId) {
		return commentImageDao.getCommentImageList(reservationInfoId);
	}

	@Override
	public double getAverageScore(int productId) {
		return commentDao.getCommentAverageScore(productId);
	}

	@Override
	public CommentResponse getCommentResponse(int commentId) {
		CommentResponse commentResponse = commentDao.getCommentResponse(commentId);
		commentResponse.setCommentImage(getCommentImage(commentId));

		return commentResponse;
	}

	@Override
	public CommentImage getCommentImage(int commentId) {
		return commentImageDao.getCommentImage(commentId);
	}

	
	/* insert */

	@Override
	@Transactional
	public CommentResponse insertCommentAndImage(CommentParam commentParam, MultipartFile commentImageFile) {

		int commentId = insertComment(commentParam);

		System.out.println(commentImageFile);
		// 파일 없을 때
		if (commentImageFile == null) {
			System.out.println("no file");
			return getCommentResponse(commentId);
		}

		// 파일 있을 때
		System.out.println("yes file");
		int fileId = fileService.insertFileInfo(commentImageFile, commentId);
		int reservationInfoId = commentParam.getReservationInfoId();

		insertCommentImage(commentId, reservationInfoId, fileId);
		return getCommentResponse(commentId);
	}

	@Override
	public int insertComment(CommentParam commentParam) {
		return commentDao.insertComment(commentParam);
	}
	
	@Override
	public void insertCommentImage(int reservationUserCommentId, int reservationInfoId, int fileId) {

		CommentImage commentImage = new CommentImage();

		commentImage.setReservationUserCommentId(reservationUserCommentId);
		commentImage.setReservationInfoId(reservationInfoId);
		commentImage.setFileId(fileId);

		commentImageDao.insertCommentImage(commentImage);

	}
}
