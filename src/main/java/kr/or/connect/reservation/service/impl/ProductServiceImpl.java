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
import kr.or.connect.reservation.dto.response.ProductResponse;
import kr.or.connect.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final CategoryDao categoryDao;
	private final ProductDao productDao;
	private final ProductPriceDao productPriceDao;
	private final ProductImageDao productImageDao;
	
	@Autowired
	public ProductServiceImpl(CategoryDao categoryDao, ProductDao productDao, ProductPriceDao productPriceDao,
			ProductImageDao productImageDao) {
		this.categoryDao = categoryDao;
		this.productDao = productDao;
		this.productPriceDao = productPriceDao;
		this.productImageDao = productImageDao;
	}

	@Override
	public ProductResponse getProductResponse(int categoryId, int start) {

		ProductResponse productResponse = new ProductResponse();

		productResponse.setItems(getProductList(categoryId, start));
		productResponse.setTotalCount(getProductListTotalCount(categoryId));

		return productResponse;
	}

	@Override
	public List<Product> getProductList(int categoryId, int start) {
		if (categoryId == TOTAL_CATEGORIES) {
			return productDao.getProductListAll(start, PRODUCT_PER_PAGE);
		} else {
			return productDao.getProductListByCategory(categoryId, start, PRODUCT_PER_PAGE);
		}

	}

	@Override
	public int getProductListTotalCount(int categoryId) {

		int totalCount = 0;
		if (categoryId == TOTAL_CATEGORIES) {
			for (Category category : categoryDao.getCategoryList()) {
				totalCount += category.getDisplayInfoCount();
			}
		} else {
			totalCount = categoryDao.getCategoryList().get(categoryId - 1).getDisplayInfoCount();
		}

		return totalCount;
	}

	@Override
	public List<ProductPrice> getProductPriceList(int productId) {
		return productPriceDao.getProductPriceList(productId);
	}

	@Override
	public List<ProductImage> getProductImageList(int productId) {
		return productImageDao.getProductImageList(productId);
	}

	@Override
	public Product getProduct(int productId) {
		return productDao.getProduct(productId);
	}

}
