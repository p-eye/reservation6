package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.ReservationInfoDao;
import kr.or.connect.reservation.dao.ReservationPriceDao;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.dto.ReservationInfoResponse;
import kr.or.connect.reservation.dto.ReservationPrice;
import kr.or.connect.reservation.service.DisplayInfoService;
import kr.or.connect.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationInfoDao reservationInfoDao;
	
	@Autowired
	private ReservationPriceDao reservationPriceDao;

	@Autowired
	private DisplayInfoService displayInfoService;
	
	@Override
	public ReservationInfoResponse getReservationInfoResponse(String reservationEmail) {
		
		ReservationInfoResponse reservationInfoResponse = new ReservationInfoResponse();
		reservationInfoResponse.setReservations(getReservationInfoList(reservationEmail));

		return reservationInfoResponse;
	}

	@Override
	public List<ReservationInfo> getReservationInfoList(String reservationEmail) {
		List<ReservationInfo> reservationInfoList = reservationInfoDao.getReservationInfoList(reservationEmail);

		// Each ReservationInfo
		for (ReservationInfo reservationInfo : reservationInfoList) {
			reservationInfo.setDisplayInfo(displayInfoService.getDisplayInfo(reservationInfo.getDisplayInfoId()));
			reservationInfo.setTotalPrice(getReservationTotalPrice(reservationInfo.getReservationInfoId()));
		}

		return reservationInfoList;

	}

	@Override
	public int getReservationTotalPrice(int reservationInfoId) {
		return reservationInfoDao.getReservationTotalPrice(reservationInfoId);
	}
	
	@Override
	public List<ReservationPrice> getReservationPriceList(int reservationInfoId) {
		return reservationPriceDao.getReservationPriceList(reservationInfoId);
	}

}
