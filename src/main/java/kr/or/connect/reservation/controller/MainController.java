package kr.or.connect.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.reservation.dao.CommentDao;
import kr.or.connect.reservation.dao.ReservationInfoDao;

@Controller
public class MainController {

	@Autowired
	private CommentDao commentDao;

	@Autowired
	private ReservationInfoDao reservationInfoDao;

	@GetMapping(path = "/detail")
	public String getDetail(@RequestParam(name = "displayInfoId", required = true) int displayInfoId) {
		return "detail";

	}

	@GetMapping(path = "/review")
	public String getReviews(@RequestParam(name = "displayInfoId", required = true) int displayInfoId, ModelMap model) {
		return "review";
	}

	@GetMapping(path = "/reserve")
	public String makeReservation() {
		return "reserve";
	}

	@GetMapping(path = "/bookingloginForm")
	public String getBookinglogin() {
		return "bookinglogin";
	}

	@GetMapping(path = "/myreservation")
	public String getMyReservation(@RequestParam(name = "reservationEmail", required = true) String reservationEmail) {
		return "/myreservation";
	}

	@GetMapping(path = "/reviewWrite")
	public String getReviewWrite(@RequestParam(name = "productId", required = true) int productId,
			@RequestParam(name = "reservationInfoId", required = true) int reservationInfoId, Model model) {

		if (reservationInfoDao.matchReservationInfo(reservationInfoId, productId) == null) {
			System.out.println("1");
			model.addAttribute("errorMsg", "예매 정보를 찾을 수 없습니다");

			return "alert";
		} else if (commentDao.getComment(reservationInfoId, productId) != null) {
			System.out.println("2");

			model.addAttribute("errorMsg", "이미 리뷰를 작성하셨습니다");
			return "alert";

		} else
			System.out.println("3");
			return "reviewWrite";

	}

	@GetMapping(path = "/alert")
	public String getAlert() {
		return "alert";
	}

}
