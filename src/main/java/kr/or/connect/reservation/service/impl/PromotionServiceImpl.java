package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.PromotionDao;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.dto.response.PromotionResponse;
import kr.or.connect.reservation.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService {

	@Autowired
	private PromotionDao promotionDao;

	@Override
	public List<Promotion> getPromotionList() {
		return promotionDao.getPromotionList();
	}

	@Override
	public PromotionResponse getPromotionResponse() {
		
		PromotionResponse promotionResponse = new PromotionResponse();
		promotionResponse.setItems(getPromotionList());
		
		return promotionResponse;
	}

}
