package kr.or.connect.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.service.ReservationService;

@Controller
@CrossOrigin
public class LoginController {

	private final ReservationService reservationService;

	@Autowired
	public LoginController(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}

	@GetMapping(path = "/bookingloginForm")
	public String getBookinglogin() {
		return "bookinglogin";
	}

	@PostMapping(path = "/bookinglogin")
	public void getMyReservation(@RequestParam String reservationEmail, Model model) {

		List<ReservationInfo> reservationInfoList = reservationService.getReservationInfoList(reservationEmail);

		if (reservationInfoList.size() != 0) {
			model.addAttribute("reservationInfo", reservationInfoList.get(0));

		} else {
			model.addAttribute("errorMsg", "등록된 이메일이 없습니다");
		}

	}

	@GetMapping(path = "/myreservation")
	public String getMyReservation(@RequestParam(name = "reservationEmail", required = true) String reservationEmail) {
		return "/myreservation";
	}

}
