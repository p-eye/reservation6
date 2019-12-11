package kr.or.connect.reservation.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.response.DisplayInfoResponse;
import kr.or.connect.reservation.dto.response.ProductResponse;
import kr.or.connect.reservation.service.DisplayInfoService;
import kr.or.connect.reservation.service.ProductService;

@RestController
@RequestMapping(path = "/api/products")
public class ProductApiController {

	private final ProductService productService;
	private final DisplayInfoService displayInfoService;

	@Autowired
	public ProductApiController(ProductService productService, DisplayInfoService displayInfoService) {
		this.productService = productService;
		this.displayInfoService = displayInfoService;
	}

	@GetMapping(path = "")
	public ProductResponse getProductResponse(
			@RequestParam(name = "categoryId", required = false, defaultValue = "0") int categoryId,
			@RequestParam(name = "start", required = false, defaultValue = "0") int start) {

		return productService.getProductResponse(categoryId, start);
	}

	@GetMapping(path = "/{displayInfoId}")
	public DisplayInfoResponse getDisplayInfo(
			@PathVariable(name = "displayInfoId", required = true) int displayInfoId) {
		return displayInfoService.getDisplayInfoResponse(displayInfoId);
	}

}
