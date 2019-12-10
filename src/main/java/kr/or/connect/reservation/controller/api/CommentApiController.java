package kr.or.connect.reservation.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.ProductTable;
import kr.or.connect.reservation.service.ProductService;

@RestController
@RequestMapping(path = "/api/comments")
public class CommentApiController {

	@Autowired
	public ProductService productService;

	@GetMapping(path = "/{productId}")
	public ProductTable getProduct(@PathVariable(name = "productId", required = true) int productId) {
		return productService.getProduct(productId);

	}

}
