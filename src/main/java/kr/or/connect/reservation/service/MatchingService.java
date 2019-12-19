package kr.or.connect.reservation.service;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.response.MsgResponse;

@Service
public interface MatchingService {
	
	public final boolean IS_MATCHED = true;
	public final boolean IS_NOT_MATCHED = false;
	
	public MsgResponse getMsgResponse(int reservationInfoId, String reservationEmail, int productId);
	
}
