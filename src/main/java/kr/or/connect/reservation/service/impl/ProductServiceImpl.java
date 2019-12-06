package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.CategoryDao;
import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dao.ProductImageDao;
import kr.or.connect.reservation.dao.ProductPriceDao;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.dto.ProductResponse;
import kr.or.connect.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private ProductPriceDao productPriceDao;

	@Autowired
	private ProductImageDao productImageDao;

	@Override
	public List<Product> getProductListByCategoryId(int categoryId, int start) {

		if (categoryId == TOTAL_CATEGORIES) {
			return productDao.getProductListAll(start, PRODUCT_PER_PAGE);
		} else {
			return productDao.getProductListByCategoryId(categoryId, start, PRODUCT_PER_PAGE);
		}
	}

	@Override
	public ProductResponse getProductResponseByCategoryId(int categoryId, int start) {

		ProductResponse productResponse = new ProductResponse();
		productResponse.setItems(getProductListByCategoryId(categoryId, start));

		if (categoryId == TOTAL_CATEGORIES) {
			int totalCount = 0;
			for (Category category : categoryDao.getCategoryList()) {
				totalCount += category.getDisplayInfoCount();
			}
			productResponse.setTotalCount(totalCount);

		} else {
			int totalCount = categoryDao.getCategoryList().get(categoryId - 1).getDisplayInfoCount();
			productResponse.setTotalCount(totalCount);
		}

		return productResponse;
	}

	@Override
	public List<ProductPrice> getProductPriceList(int productId) {
		return productPriceDao.getProductPriceList(productId);
	}

	@Override
	public List<ProductImage> getProductImageList(int productId) {
		return productImageDao.getProductImageList(productId);
	}

}
