package kr.or.connect.reservation.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.service.ProductService;
import kr.or.connect.reservation.service.ReservationService;

@RestController
@RequestMapping(path = "/api/comments")
public class CommentApiController {

	private final ProductService productService;
	private final ReservationService reservationService;

	@Autowired
	public CommentApiController(ProductService productService, ReservationService reservationService) {
		this.productService = productService;
		this.reservationService = reservationService;
	}

	@GetMapping(path = "/product/{productId}")
	public Product getProduct(@PathVariable(name = "productId", required = true) int productId) {
		return productService.getProduct(productId);

	}

	@GetMapping(path = "/reservation/{reservationInfoId}")
	public ReservationInfo getReservationInfo(
			@PathVariable(name = "reservationInfoId", required = true) int reservationInfoId) {
		return reservationService.getReservationInfo(reservationInfoId);

	}

}
