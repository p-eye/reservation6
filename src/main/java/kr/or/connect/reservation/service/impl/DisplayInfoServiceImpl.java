package kr.or.connect.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.DisplayInfoDao;
import kr.or.connect.reservation.dao.DisplayInfoImageDao;
import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.dto.response.DisplayInfoResponse;
import kr.or.connect.reservation.service.CommentService;
import kr.or.connect.reservation.service.DisplayInfoService;
import kr.or.connect.reservation.service.ProductService;

@Service
public class DisplayInfoServiceImpl implements DisplayInfoService {

	
	private final DisplayInfoDao displayInfoDao;
	private final DisplayInfoImageDao displayInfoImageDao;
	private final ProductService productService;
	private final CommentService commentService;

	@Autowired
	public DisplayInfoServiceImpl(DisplayInfoDao displayInfoDao, DisplayInfoImageDao displayInfoImageDao,
			ProductService productService, CommentService commentService) {
		this.displayInfoDao = displayInfoDao;
		this.displayInfoImageDao = displayInfoImageDao;
		this.productService = productService;
		this.commentService = commentService;
	}

	@Override
	public DisplayInfo getDisplayInfo(int displayInfoId) {
		return displayInfoDao.getDisplayInfo(displayInfoId);
	}

	@Override
	public DisplayInfoImage getDisplayInfoImage(int displayInfoId) {
		return displayInfoImageDao.getDisplayInfoImage(displayInfoId);
	}
	
	@Override
	public DisplayInfoResponse getDisplayInfoResponse(int displayInfoId) {
		
		DisplayInfoResponse displayInfoResponse = new DisplayInfoResponse();
		
		DisplayInfo displayInfo = getDisplayInfo(displayInfoId);
		int productId = displayInfo.getProductId();
		
		displayInfoResponse.setDisplayInfo(displayInfo);
		displayInfoResponse.setDisplayInfoImage(getDisplayInfoImage(displayInfoId));
		
		displayInfoResponse.setProductImages(productService.getProductImageList(productId));
		displayInfoResponse.setProductPrices(productService.getProductPriceList(productId));
		displayInfoResponse.setComments(commentService.getCommentList(productId));
		displayInfoResponse.setAverageScore(commentService.getAverageScore(productId));
		
		return displayInfoResponse;
		
	}

}
