package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.CommentImageDao;
import kr.or.connect.reservation.dto.CommentImage;
import kr.or.connect.reservation.service.CommentImageService;

@Service
public class CommentImageServiceImpl implements CommentImageService {

	@Autowired
	private CommentImageDao commentImageDao;

	@Override
	public List<CommentImage> getCommentImageList(int reservationInfoId) {
		return commentImageDao.getCommentImageList(reservationInfoId);
	}

}