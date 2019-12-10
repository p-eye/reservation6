package kr.or.connect.reservation.controller.api;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kr.or.connect.reservation.dto.CommentParam;
import kr.or.connect.reservation.dto.CommentResponse;
import kr.or.connect.reservation.dto.ReservationParam;
import kr.or.connect.reservation.dto.response.ReservationInfoResponse;
import kr.or.connect.reservation.dto.response.ReservationResponse;
import kr.or.connect.reservation.service.CommentService;
import kr.or.connect.reservation.service.ReservationService;

@RestController
@RequestMapping(path = "/api/reservations")
@CrossOrigin

public class ReservationApiController {

	@Autowired
	public ReservationService reservationService;

	@Autowired
	public CommentService commentService;

	@GetMapping(path = "")
	public ReservationInfoResponse getReservationInfoResponse(
			@RequestParam(name = "reservationEmail", defaultValue = "") String reservationEmail) {
		return reservationService.getReservationInfoResponse(reservationEmail);
	}

	@PostMapping(path = "")
	public ReservationResponse addReservationInfo(@RequestBody ReservationParam reservationParam) {
		return reservationService.insertReservationInfoAndPrice(reservationParam);

	}

	@PutMapping(path = "/{reservationInfoId}")
	public ReservationResponse cancelReservation(@PathVariable int reservationInfoId) {
		return reservationService.cancelReservationInfo(reservationInfoId);
	}

	public static final String FILE_PATH = "img_comment/";

	@PostMapping(path = "/{reservationInfoId}/comments")
	public CommentResponse insertCommentAndImage(@PathVariable int reservationInfoId, 
			CommentParam commentParam,
			MultipartFile commentImageFile) {
	


		
		System.out.println(commentParam);
		System.out.println(commentImageFile);
		/*
		 * System.out.println("파일 이름 : " + attachedImage.getOriginalFilename());
		 * System.out.println("파일 크기 : " + attachedImage.getSize()); String filePath =
		 * "c:/tmp/";
		 */
		/*
		 * File file = new File(filePath+ attachedImage.getOriginalFilename());
		 * 
		 * try {
		 * 
		 * attachedImage.transferTo(file); } }
		 */

		// uploadCommentImageFile(attachedImage);

		// return commentService.insertCommentAndFile(comment, attachedImage);
		return commentService.insertCommentAndImage(commentParam, commentImageFile);

	}

	public void uploadCommentImageFile(MultipartFile attachedImage) {

		try (

				FileOutputStream fos = new FileOutputStream(
						"c:/tmp/" + FILE_PATH + attachedImage.getOriginalFilename());
				InputStream is = attachedImage.getInputStream();) {
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
