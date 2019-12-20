package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dao.ProductImageDao;
import kr.or.connect.reservation.dao.ProductPriceDao;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.dto.response.ProductResponse;
import kr.or.connect.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductDao productDao;
	private final ProductPriceDao productPriceDao;
	private final ProductImageDao productImageDao;

	@Autowired
	public ProductServiceImpl(ProductDao productDao, ProductPriceDao productPriceDao, ProductImageDao productImageDao) {
		this.productDao = productDao;
		this.productPriceDao = productPriceDao;
		this.productImageDao = productImageDao;
	}

	@Override
	public ProductResponse getProductResponse(int categoryId, int start) {

		ProductResponse productResponse = new ProductResponse();

		productResponse.setItems(getProductList(categoryId, start));
		productResponse.setTotalCount(countProductList(categoryId));

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
	public int countProductList(int categoryId) {
		if (categoryId == TOTAL_CATEGORIES) {
			return productDao.countProductListAll();
		} else {
			return productDao.countProductListByCategory(categoryId);
		}
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
