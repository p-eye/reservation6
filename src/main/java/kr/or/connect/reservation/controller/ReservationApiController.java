package kr.or.connect.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dao.ReservationInfoDao;
import kr.or.connect.reservation.dto.ReservationParam;
import kr.or.connect.reservation.dto.response.ReservationInfoResponse;
import kr.or.connect.reservation.dto.response.ReservationResponse;
import kr.or.connect.reservation.service.ReservationService;

@RestController
@RequestMapping(path = "/api/reservations")
@CrossOrigin

public class ReservationApiController {


	@Autowired
	public ReservationService reservationService;
	
	@Autowired
	public ReservationInfoDao reservationInfoDao;

	@Autowired
	public ReservationApiController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	@GetMapping(path = "")
	public ReservationInfoResponse getReservationInfoResponse(
			@RequestParam(name = "reservationEmail", defaultValue = "") String reservationEmail) {
		return reservationService.getReservationInfoResponse(reservationEmail);
	}

	@PostMapping(path = "")
	public ReservationResponse addReservationInfo(@RequestBody ReservationParam reservationParam) {
		System.out.println(reservationParam);
		reservationService.insertReservationInfo(reservationParam);
		
		
		
		return null;
	}

}
