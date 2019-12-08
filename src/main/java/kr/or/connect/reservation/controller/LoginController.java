package kr.or.connect.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.service.ReservationService;

@Controller
@CrossOrigin
public class LoginController {
	
	@Autowired
	private ReservationService reservationService;

	@PostMapping(path = "/bookingloginPost")
	public void getMyReservation(@RequestParam String reservationEmail, Model model) {

		List<ReservationInfo> reservationInfoList = reservationService.getReservationInfoList(reservationEmail);

		if (reservationInfoList.size() != 0) {
			model.addAttribute("reservationInfo", reservationInfoList.get(0));

		} else {
			model.addAttribute("errorMsg", "등록된 이메일이 없습니다");
		}

	}
}
