package kr.or.connect.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.ProductImage;

@Service
public interface ProductImageService {
	
	public List<ProductImage> getProductImageList(int productId);

}
