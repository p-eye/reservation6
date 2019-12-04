package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.CategoryDao;
import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductResponse;
import kr.or.connect.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<Product> getProductListByCategoryId(int categoryId, int start) {
		return productDao.getProductListByCategoryId(categoryId, start, PRODUCT_PER_PAGE);
	}

	@Override
	public ProductResponse getProductResponseByCategoryId(int categoryId, int start) {

		ProductResponse productResponse = new ProductResponse();

		int totalCount = categoryDao.getCategoryList().get(categoryId - 1).getDisplayInfoCount();
		productResponse.setTotalCount(totalCount);
		
		productResponse.setItems(getProductListByCategoryId(categoryId, start));
		
		return productResponse;
	}

}
