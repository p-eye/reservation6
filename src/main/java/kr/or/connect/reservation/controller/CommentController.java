package kr.or.connect.reservation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.service.MatchingService;

@Controller
public class CommentController {

	private static final String LOGIN = "login";

	private final MatchingService matchingService;

	@Autowired
	public CommentController(MatchingService matchingService) {
		this.matchingService = matchingService;
	}

	@GetMapping(path = "/reviewWrite")
	public String getReviewWrite(@RequestParam(name = "productId", required = true) int productId,
			@RequestParam(name = "reservationInfoId", required = true) int reservationInfoId,
			HttpServletRequest request) {

		HttpSession httpSession = request.getSession();
		ReservationInfo reservationInfo = (ReservationInfo) httpSession.getAttribute(LOGIN);
		String loginedEmail = reservationInfo.getReservationEmail();

		matchingService.matchCommentWrite(reservationInfoId, loginedEmail, productId);

		return "reviewWrite";

	}

	@GetMapping(path = "/alert")
	public String getAlert() {
		return "alert";
	}

}
