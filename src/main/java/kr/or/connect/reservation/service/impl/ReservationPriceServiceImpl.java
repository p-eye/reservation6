package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.ReservationPriceDao;
import kr.or.connect.reservation.dto.ReservationPrice;
import kr.or.connect.reservation.service.ReservationPriceService;

@Service
public class ReservationPriceServiceImpl implements ReservationPriceService {

	@Autowired
	private ReservationPriceDao reservationPriceDao;

	@Override
	public List<ReservationPrice> getReservationPriceList(int reservationInfoId) {
		return reservationPriceDao.getReservationPriceList(reservationInfoId);
	}

	@Override
	public int getReservationTotalPrice(int reservationInfoId) {
		return reservationPriceDao.getReservationTotalPrice(reservationInfoId);
	}

	
}
