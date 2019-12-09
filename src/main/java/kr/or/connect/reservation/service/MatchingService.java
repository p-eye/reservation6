package kr.or.connect.reservation.service;

import org.springframework.stereotype.Service;

@Service
public interface MatchingService {
	
	public int matchComment(int reservationInfoId, int productId);
	
	public int matchReservationInfo(int reservationInfoId, int productId);
	
	
}
