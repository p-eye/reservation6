package kr.or.connect.reservation.service.impl;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

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

		String fileNameTimeStamped = uploadCommentImageFile(commentImageFile);

		FileInfo fileInfo = new FileInfo();

		fileInfo.setFileName(fileNameTimeStamped);
		fileInfo.setSaveFileName(FILE_PATH + fileNameTimeStamped);
		fileInfo.setContentType(commentImageFile.getContentType());

		return fileDao.insertFileInfo(fileInfo);
	}

	static final String ILLEGAL_EXP = "[:\\\\/%*?:|\"<>]";

	public String uploadCommentImageFile(MultipartFile commentImageFile) {

		/* 파일명 유효성 검사 */
		String fileName = commentImageFile.getOriginalFilename();
		if (!isValidFileName(fileName)) {
			fileName = makeValidFileName(fileName, "_");

		}

		/* 파일명에 현재시간 timeStamp 붙이기 */
		String fileNameTimeStamped = makeTimeStampedFileName(fileName);

		/* 파일업로드 */
		try (

				FileOutputStream fos = new FileOutputStream("c:/tmp/" + FILE_PATH + fileNameTimeStamped);
				InputStream is = commentImageFile.getInputStream();) {
			int readCount = 0;
			byte[] buffer = new byte[1024];
			while ((readCount = is.read(buffer)) != -1) {
				fos.write(buffer, 0, readCount);
			}
		} catch (Exception ex) {
			throw new RuntimeException("file Save Error");
		}

		return fileNameTimeStamped;
	}
	
	public String makeTimeStampedFileName(String fileName) {
		String _fileName = fileName.substring(0, fileName.lastIndexOf("."));
		String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss.SSS").format(System.currentTimeMillis());

		return _fileName + "_" + timeStamp + "." + fileType;
	}

	public static boolean isValidFileName(String fileName) {
		if (fileName == null || fileName.trim().length() == 0)
			return false;

		return !Pattern.compile(ILLEGAL_EXP).matcher(fileName).find();
	}

	public static String makeValidFileName(String fileName, String replaceStr) {
		if (fileName == null || fileName.trim().length() == 0 || replaceStr == null)
			return String.valueOf(System.currentTimeMillis());

		return fileName.replaceAll(ILLEGAL_EXP, replaceStr);
	}
}
