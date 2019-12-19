package kr.or.connect.reservation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.service.MatchingService;
import kr.or.connect.reservation.service.ReservationService;

@Controller
@CrossOrigin
public class LoginController {

	private static final String LOGIN = "login";

	private final ReservationService reservationService;
	private final MatchingService matchingService;

	@Autowired
	public LoginController(ReservationService reservationService, MatchingService matchingService) {
		this.reservationService = reservationService;
		this.matchingService = matchingService;
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
	public String getMyReservation(@RequestParam(name = "reservationEmail", required = true) String reservationEmail,
			HttpServletRequest request) {

		HttpSession httpSession = request.getSession();
		ReservationInfo reservationInfo = (ReservationInfo) httpSession.getAttribute(LOGIN);
		String loginedEmail = reservationInfo.getReservationEmail();

		matchingService.matchEmail(reservationEmail, loginedEmail);
		
		return "/myreservation";
	}

}
