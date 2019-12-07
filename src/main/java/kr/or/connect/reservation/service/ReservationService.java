package kr.or.connect.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.dto.ReservationResponse;
import kr.or.connect.reservation.dto.ReservationPrice;

@Service
public interface ReservationService {


	public ReservationResponse getReservationResponse(String reservationEmail);
	
	public List<ReservationInfo> getReservationInfoList(String reservationEmail);
	
	public int getReservationTotalPrice(int reservationInfoId);
	
	public List<ReservationPrice> getReservationPriceList(int reservationInfoId);

}