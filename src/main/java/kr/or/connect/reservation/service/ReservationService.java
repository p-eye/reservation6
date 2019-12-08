package kr.or.connect.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.dto.ReservationParam;
import kr.or.connect.reservation.dto.ReservationPrice;
import kr.or.connect.reservation.dto.response.ReservationInfoResponse;

@Service
public interface ReservationService {


	public ReservationInfoResponse getReservationInfoResponse(String reservationEmail);
	
	public List<ReservationInfo> getReservationInfoList(String reservationEmail);
	
	public int getReservationTotalPrice(int reservationInfoId);
	
	public List<ReservationPrice> getReservationPriceList(int reservationInfoId);

	public int insertReservationInfo(ReservationParam reservationParam);

}
