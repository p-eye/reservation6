package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.connect.reservation.dao.CommentDao;
import kr.or.connect.reservation.dao.CommentImageDao;
import kr.or.connect.reservation.dao.FileDao;
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
	
	@Autowired
	private FileDao fileDao;

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
	public CommentResponse insertCommentAndImage(CommentParam commentParam, MultipartFile commentImageFile) {
		///insert~~~
		int commentId = insertComment(commentParam);
		
		int fileId = insertFile(commentImageFile, commentId);
		
		int reservationInfoId = commentParam.getReservationInfoId();
		
		int commentImageId = insertCommentImage(commentId, reservationInfoId,
				fileId);

		
		CommentResponse commentResponse = getCommentResponse(commentId);
		commentResponse.setCommentImage(getCommentImage(commentImageId));

		return commentResponse;
	}

	public int insertComment(CommentParam commentParam) {
		return commentDao.insertComment(commentParam);
	}
	
	public int insertFile(MultipartFile commentImageFile, int commentId) {
		CommentImage commentImage = new CommentImage();
		
		commentImage.setFileName(commentImageFile.getOriginalFilename());
		commentImage.setSaveFileName(FILE_PATH + commentImageFile.getOriginalFilename());
		commentImage.setContentType(commentImageFile.getContentType());
		commentImage.setDeleteFlag(false);
		commentImage.setCreateDate(commentDao.getCommentResponse(commentId).getCreateDate());
		commentImage.setModifyDate(commentDao.getCommentResponse(commentId).getModifyDate());

		return fileDao.insertFileInfo(commentImage);
	}
	
	public int insertCommentImage(int reservationUserCommentId, int reservationInfoId,  int fileId) {

		CommentImage commentImage = new CommentImage();
		
		commentImage.setReservationUserCommentId(reservationUserCommentId);
		commentImage.setReservationInfoId(reservationInfoId);
		commentImage.setFileId(fileId);

		return commentImageDao.insertCommentImage(commentImage);

	}
}
