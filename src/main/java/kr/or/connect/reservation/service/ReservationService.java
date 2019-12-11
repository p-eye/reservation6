package kr.or.connect.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.dto.ReservationPrice;
import kr.or.connect.reservation.dto.param.ReservationParam;
import kr.or.connect.reservation.dto.response.ReservationInfoResponse;
import kr.or.connect.reservation.dto.response.ReservationResponse;

@Service
public interface ReservationService {

	public ReservationInfoResponse getReservationInfoResponse(String reservationEmail);

	public List<ReservationInfo> getReservationInfoList(String reservationEmail);

	public int getReservationTotalPrice(int reservationInfoId);

	public List<ReservationPrice> getReservationPriceList(int reservationInfoId);

	public int insertReservationInfo(ReservationParam reservationParam);

	public ReservationResponse insertReservationInfoAndPrice(ReservationParam reservationParam);

	public void insertReservationPrice(ReservationParam reservationParam, int reservationInfoId);

	public ReservationResponse getReservationResponse(int reservationInfoId);
	
	public ReservationResponse cancelReservationInfo(int reservationInfoId);

	public ReservationInfo getReservationInfo(int reservationInfoId);

}
