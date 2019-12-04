package kr.or.connect.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.Promotion;

@Service
public interface PromotionService {

	public List<Promotion> getPromotionList();

}
