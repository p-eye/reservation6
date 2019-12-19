package kr.or.connect.reservation.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.response.PromotionResponse;
import kr.or.connect.reservation.service.PromotionService;

@RestController
@RequestMapping(path = "/api/promotions")
public class PromotionApiController {

	private final PromotionService promotionService;

	@Autowired
	public PromotionApiController(PromotionService promotionService) {
		this.promotionService = promotionService;
	}

	@GetMapping
	public PromotionResponse getPromotionResponse() {
		return promotionService.getPromotionResponse();
	}

}
