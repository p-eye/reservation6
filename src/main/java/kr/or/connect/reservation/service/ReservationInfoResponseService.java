package kr.or.connect.reservation.service;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.ReservationInfoResponse;

@Service
public interface ReservationInfoResponseService {
	

	public ReservationInfoResponse getReservationInfoResponse(String reservationEmail);
	
}
