package kr.or.connect.reservation.service.impl;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.connect.reservation.dao.FileDao;
import kr.or.connect.reservation.dto.FileInfo;
import kr.or.connect.reservation.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	private final FileDao fileDao;

	@Autowired
	public FileServiceImpl(FileDao fileDao) {
		this.fileDao = fileDao;
	}

	@Override
	public int insertFileInfo(MultipartFile commentImageFile, int commentId) {

		uploadCommentImageFile(commentImageFile);

		FileInfo fileInfo = new FileInfo();

		fileInfo.setFileName(commentImageFile.getOriginalFilename());
		fileInfo.setSaveFileName(FILE_PATH + commentImageFile.getOriginalFilename());
		fileInfo.setContentType(commentImageFile.getContentType());

		return fileDao.insertFileInfo(fileInfo);
	}

	// 이런 함수도 인터페이스에서 선언하고 Override 해야 하나요?
	public void uploadCommentImageFile(MultipartFile commentImageFile) {

		try (

				FileOutputStream fos = new FileOutputStream(
						"c:/tmp/" + FILE_PATH + commentImageFile.getOriginalFilename());
				InputStream is = commentImageFile.getInputStream();) {
			int readCount = 0;
			byte[] buffer = new byte[1024];
			while ((readCount = is.read(buffer)) != -1) {
				fos.write(buffer, 0, readCount);
			}
		} catch (Exception ex) {
			throw new RuntimeException("file Save Error");
		}

	}

}
