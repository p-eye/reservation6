package kr.or.connect.reservation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.dto.response.MsgResponse;
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
			@RequestParam(name = "reservationInfoId", required = true) int reservationInfoId, Model model,
			HttpServletRequest request) {

		HttpSession httpSession = request.getSession();
		ReservationInfo reservationInfo = (ReservationInfo) httpSession.getAttribute(LOGIN);
		String reservationEmail = reservationInfo.getReservationEmail();

		MsgResponse msgResponse = matchingService.getMsgResponse(reservationInfoId, reservationEmail, productId);

		if (msgResponse != null) {
			String msg = msgResponse.getMsg();
			if (msg.equals("이미 리뷰를 작성하셨습니다")) {

				// 세션등록이유: 내 예매내역 페이지에서 등록한 리뷰 있을 때만 현 페이지 새로고침 하려고 (view 호출 후 세션 삭제)
				httpSession.setAttribute("currentURI", request.getHeader("referer"));
			}
			
			model.addAttribute("errorMsg", msgResponse.getMsg());
			return "alert";
		}

		return "reviewWrite";

	}

	@GetMapping(path = "/alert")
	public String getAlert() {
		return "alert";
	}

}
