package kr.or.connect.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductResponse;

@Service
public interface ProductService {
	
	public final int PRODUCT_PER_PAGE = 4;
	
	public List<Product> getProductListByCategoryId(int categoryId, int start);

	public ProductResponse getProductResponseByCategoryId(int categoryId, int start);
	
	
	
}
