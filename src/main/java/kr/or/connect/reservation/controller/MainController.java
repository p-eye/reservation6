package kr.or.connect.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@GetMapping(path = "/detail")
	public String getDetail(@RequestParam(name = "displayInfoId", required = true) int displayInfoId) {
		return "detail";

	}

}
