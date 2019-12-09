package kr.or.connect.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.reservation.service.MatchingService;

@Controller
public class CommentController {

	@Autowired
	private MatchingService matchingService;

	@GetMapping(path = "/reviewWrite")
	public String getReviewWrite(@RequestParam(name = "productId", required = true) int productId,
			@RequestParam(name = "reservationInfoId", required = true) int reservationInfoId, Model model) {

		if (matchingService.matchReservationInfo(reservationInfoId, productId) == 0) {
			model.addAttribute("errorMsg", "예매 정보를 찾을 수 없습니다");
			return "alert";
			
		} else if (matchingService.matchComment(reservationInfoId, productId) != 0) {
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
