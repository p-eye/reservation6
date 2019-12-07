package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.ReservationInfoDao;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.service.ReservationInfoService;

@Service
public class ReservationInfoServiceImpl implements ReservationInfoService {

	@Autowired
	private ReservationInfoDao reservationInfoDao;

	@Override
	public List<ReservationInfo> getReservationInfoList(String reservationEmail) {
		return reservationInfoDao.getReservationInfoList(reservationEmail);
	}

}
