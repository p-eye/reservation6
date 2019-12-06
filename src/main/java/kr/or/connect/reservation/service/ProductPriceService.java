package kr.or.connect.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.ProductPrice;

@Service
public interface ProductPriceService {

	public List<ProductPrice> getProductPriceList(int displayInfoId);
	

}
