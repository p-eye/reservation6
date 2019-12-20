package kr.or.connect.reservation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	public void getMyReservation(@RequestParam String reservationEmail, Model model, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		/* 기존 구현 with LoginInterceptor */

		/*
		  List<ReservationInfo> reservationInfoList =
		  reservationService.getReservationInfoList(reservationEmail);
		  
		  if (reservationInfoList.size() != 0) { model.addAttribute("reservationInfo",
		  reservationInfoList.get(0));
		  
		  } else { model.addAttribute("errorMsg", "등록된 이메일이 없습니다"); }
		 */

		/* without LoginInterceptor */
		List<ReservationInfo> reservationInfoList = reservationService.getReservationInfoList(reservationEmail);
		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute(LOGIN) != null) {

			// 로그인 정보 있으면 기존 로그인 정보 제거
			httpSession.removeAttribute(LOGIN);
		}

		if (reservationInfoList.size() != 0) {
			ReservationInfo reservationInfo = reservationInfoList.get(0);

			httpSession.setAttribute(LOGIN, reservationInfo);

			Object destination = httpSession.getAttribute("destination");

			if (destination != null) {

				/*
				 * destination 세션 있을 때 = commet 페이지에서 넘어왔을 때 , 
				 * 그 페이지로 redirect 후 destination 세션 삭제
				 */
				response.sendRedirect((String) destination);
				httpSession.removeAttribute("destination");

			} else {

				// destination 없을 때 = main, detail + myreservation 페이지에서 넘어왔을 때 나의 예매내역 페이지로 이동
				response.sendRedirect("./myreservation?reservationEmail=" + reservationEmail);
			}

		} else {
			model.addAttribute("errorMsg", "등록된 이메일이 없습니다");
			response.sendRedirect("./bookingloginForm");
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
