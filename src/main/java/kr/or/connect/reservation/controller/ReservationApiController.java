package kr.or.connect.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.response.ReservationResponse;
import kr.or.connect.reservation.service.ReservationService;

@RestController
@RequestMapping(path = "/api/reservations")
@CrossOrigin

public class ReservationApiController {

	private final ReservationService reservationService;

	@Autowired
	public ReservationApiController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	@GetMapping(path = "")
	public ReservationResponse getReservationResponse(
			@RequestParam(name = "reservationEmail", defaultValue = "") String reservationEmail) {
		return reservationService.getReservationResponse(reservationEmail);
	}

}
