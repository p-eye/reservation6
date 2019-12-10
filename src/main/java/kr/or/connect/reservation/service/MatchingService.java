package kr.or.connect.reservation.service;

import org.springframework.stereotype.Service;

@Service
public interface MatchingService {
	
	public final int IS_MATCHED = 1;
	public final int IS_NOT_MATCHED = 0;
	
	public int matchComment(int reservationInfoId, int productId);
	
	public int matchReservationInfo(int reservationInfoId, int productId);
	
	public int matchReservationInfo(int reservationInfoId, String reservationEmail);
}
