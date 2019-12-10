package kr.or.connect.reservation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.service.MatchingService;

@Controller
public class CommentController {

	private static final String LOGIN = "login";
	private static final int IS_NOT_MATCHED = 0;

	@Autowired
	private MatchingService matchingService;

	@GetMapping(path = "/reviewWrite")
	public String getReviewWrite(@RequestParam(name = "productId", required = true) int productId,
			@RequestParam(name = "reservationInfoId", required = true) int reservationInfoId, Model model,
			HttpServletRequest request) {

		HttpSession httpSession = request.getSession();
		ReservationInfo reservationInfo = (ReservationInfo) httpSession.getAttribute(LOGIN);
		String reservationEmail = reservationInfo.getReservationEmail();

		// 로그인 정보와 타겟 예매기록이 다를때
		if (matchingService.matchReservationInfo(reservationInfoId, reservationEmail) == IS_NOT_MATCHED) {
			model.addAttribute("errorMsg", "예매 정보를 찾을 수 없습니다");
			return "alert";
		}

		// 타겟 예매 기록이 없을 때
		if (matchingService.matchReservationInfo(reservationInfoId, productId) == IS_NOT_MATCHED) {
			model.addAttribute("errorMsg", "예매 정보를 찾을 수 없습니다");
			return "alert";

		// 타겟 예매 기록에 이미 리뷰를 등록했을 때
		} else if (matchingService.matchComment(reservationInfoId, productId) != IS_NOT_MATCHED) {
			model.addAttribute("errorMsg", "이미 리뷰를 작성하셨습니다");
			return "alert";

		} else
			return "reviewWrite";

	}

	@GetMapping(path = "/alert")
	public String getAlert() {
		return "alert";
	}

}
