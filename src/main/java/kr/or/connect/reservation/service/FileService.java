package kr.or.connect.reservation.service;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.CommentImage;

@Service
public interface FileService {
	
	public int insertFile(CommentImage commentImage);
}
