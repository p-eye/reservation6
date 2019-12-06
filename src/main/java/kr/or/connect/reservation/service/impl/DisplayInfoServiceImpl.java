package kr.or.connect.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.DisplayInfoDao;
import kr.or.connect.reservation.dao.DisplayInfoImageDao;
import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.dto.DisplayInfoResponse;
import kr.or.connect.reservation.service.CommentService;
import kr.or.connect.reservation.service.DisplayInfoService;
import kr.or.connect.reservation.service.ProductService;

@Service
public class DisplayInfoServiceImpl implements DisplayInfoService {

	@Autowired
	private DisplayInfoDao displayInfoDao;

	@Autowired
	private DisplayInfoImageDao displayInfoImageDao;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CommentService commentService;

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
		
		displayInfoResponse.setDisplayInfo(displayInfo);
		displayInfoResponse.setDisplayInfoImage(getDisplayInfoImage(displayInfoId));
		
		int productId = displayInfo.getProductId();
		
		displayInfoResponse.setProductImages(productService.getProductImageList(productId));
		displayInfoResponse.setProductPrices(productService.getProductPriceList(productId));
		displayInfoResponse.setComments(commentService.getCommentList(productId));
		displayInfoResponse.setAverageScore(commentService.getAverageScore(productId));
		
		return displayInfoResponse;
		
	}

}
