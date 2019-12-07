package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.ReservationInfoDao;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.service.DisplayInfoService;
import kr.or.connect.reservation.service.ReservationInfoService;
import kr.or.connect.reservation.service.ReservationPriceService;

@Service
public class ReservationInfoServiceImpl implements ReservationInfoService {

	@Autowired
	private ReservationInfoDao reservationInfoDao;
	
	@Autowired
	private DisplayInfoService displayInfoService;
	
	@Autowired
	private ReservationPriceService reservationPriceService;

	@Override
	public List<ReservationInfo> getReservationInfoList(String reservationEmail) {
		List<ReservationInfo> reservationInfoList =	 reservationInfoDao.getReservationInfoList(reservationEmail);
		
		//Each ReservationInfo
		for (ReservationInfo reservationInfo : reservationInfoList) {
			reservationInfo.setDisplayInfo(displayInfoService.getDisplayInfo(reservationInfo.getDisplayInfoId()));
			reservationInfo.setTotalPrice(reservationPriceService.getReservationTotalPrice(reservationInfo.getReservationInfoId()));
		}
		
		return reservationInfoList;

	}

}
