package kr.or.connect.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

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

	@GetMapping(path = "/bookinglogin")
	public String getBookinglogin() {
		return "bookinglogin";
	}
	
	
}
