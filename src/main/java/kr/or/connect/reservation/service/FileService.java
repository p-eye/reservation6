package kr.or.connect.reservation.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileService {
	
	public static final String FILE_PATH = "img_comment/";
	
	public int insertFileInfo(MultipartFile commentImageFile, int commentId);
}
