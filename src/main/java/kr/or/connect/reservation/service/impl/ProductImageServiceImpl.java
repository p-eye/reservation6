package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.ProductImageDao;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.service.ProductImageService;

@Service
public class ProductImageServiceImpl implements ProductImageService {

	@Autowired
	private ProductImageDao productImageDao;

	@Override
	public List<ProductImage> getProductImageList(int displayInfoId) {
		return productImageDao.getProductImageList(displayInfoId);
	}

}
