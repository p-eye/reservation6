package kr.or.connect.reservation.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.connect.reservation.dto.FileInfo;

@Service
public interface FileService {
	
	public static final String FILE_PATH = "img_comment/";
	
	public int insertFileInfo(MultipartFile commentImageFile, int commentId);

	public FileInfo getFileInfoByProductId(int productId);

	public FileInfo getFileInfo(int fileId);
}
