package kr.or.connect.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.DisplayInfoResponse;
import kr.or.connect.reservation.dto.ProductResponse;
import kr.or.connect.reservation.service.DisplayInfoService;
import kr.or.connect.reservation.service.ProductService;

@RestController
@RequestMapping(path = "/api/products")
public class ProductApiController {

	@Autowired
	public ProductService productService;

	@Autowired
	public DisplayInfoService displayInfoService;
	
	@GetMapping(path = "")
	public ProductResponse getProductResponse(
			@RequestParam(name = "categoryId", required = false, defaultValue = "0") int categoryId,
			@RequestParam(name = "start", required = false, defaultValue = "0") int start) {

		return productService.getProductResponseByCategoryId(categoryId, start);
	}
	
	@GetMapping(path = "/{displayInfoId}")
	public DisplayInfoResponse getDisplayInfo(
			@PathVariable(name = "displayInfoId", required = true) int displayInfoId) {
		return displayInfoService.getDisplayInfoResponse(displayInfoId);
	}

}
