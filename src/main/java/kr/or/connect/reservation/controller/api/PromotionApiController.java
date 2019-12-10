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


	@Autowired
	public PromotionService promotionService;
	
    @GetMapping(path = "")
    public PromotionResponse getPromotionResponse() {
        return promotionService.getPromotionResponse();
    }

}
