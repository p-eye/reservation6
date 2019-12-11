package kr.or.connect.reservation.controller;

import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dao.FileDao;
import kr.or.connect.reservation.dto.FileInfo;
import kr.or.connect.reservation.service.CommentService;

@RestController
@RequestMapping(path = "/file")
public class FileController {

	@Autowired
	CommentService commentService;

	@Autowired
	FileDao fileDao;

	@GetMapping(path = "/product/{proudctId}")
	public String getImage(@PathVariable int proudctId, HttpServletResponse response) {

		FileInfo fileInfo = fileDao.getFileInfoByProductId(proudctId);
		downloadImageFile(fileInfo, response);

		return null;
	}

	@GetMapping(path = "/{fileId}")
	public String getImageByFileId(@PathVariable int fileId, HttpServletResponse response) {

		FileInfo fileInfo = fileDao.getFileInfo(fileId);
		downloadImageFile(fileInfo, response);

		return null;

	}

	public void downloadImageFile(FileInfo fileInfo, HttpServletResponse response) {
		
		String fileName = fileInfo.getFileName();
		String saveFileName = "c:/tmp/" + fileInfo.getSaveFileName();
		String contentType = fileInfo.getContentType();

		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Content-Type", contentType);
		response.setHeader("Pragma", "no-cache;");
		response.setHeader("Expires", "-1;");

		try (FileInputStream fis = new FileInputStream(saveFileName); OutputStream out = response.getOutputStream();) {
			int readCount = 0;
			byte[] buffer = new byte[1024];
			while ((readCount = fis.read(buffer)) != -1) {
				out.write(buffer, 0, readCount);
			}
		} catch (Exception ex) {
			throw new RuntimeException("file Save Error");
		}

	}
}
