package kr.or.connect.reservation.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.service.ProductService;

@RestController
@RequestMapping(path = "/api/comments")
public class CommentApiController {

	private final ProductService productService;

	@Autowired
	public CommentApiController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping(path = "/{productId}")
	public Product getProduct(@PathVariable(name = "productId", required = true) int productId) {
		return productService.getProduct(productId);

	}

}
