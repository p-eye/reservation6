package kr.or.connect.reservation.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import kr.or.connect.reservation.dto.param.CommentParam;
import kr.or.connect.reservation.dto.param.ReservationParam;
import kr.or.connect.reservation.dto.response.CommentResponse;
import kr.or.connect.reservation.dto.response.ReservationInfoResponse;
import kr.or.connect.reservation.dto.response.ReservationResponse;
import kr.or.connect.reservation.service.CommentService;
import kr.or.connect.reservation.service.ReservationService;

@RestController
@RequestMapping(path = "/api/reservations")
@CrossOrigin

public class ReservationApiController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final ReservationService reservationService;
	private final CommentService commentService;
	
	@Autowired
	public ReservationApiController(ReservationService reservationService, CommentService commentService) {
		this.reservationService = reservationService;
		this.commentService = commentService;
	}


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


	@PostMapping(path = "/{reservationInfoId}/comments")
	public CommentResponse insertCommentAndImage(@PathVariable int reservationInfoId, CommentParam commentParam,
			@RequestParam(required = false) MultipartFile commentImageFile) {

		logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
		
		return commentService.insertCommentAndImage(commentParam, commentImageFile);

	}

}
