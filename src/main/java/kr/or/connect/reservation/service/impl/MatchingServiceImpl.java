package kr.or.connect.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.MatchingDao;
import kr.or.connect.reservation.service.MatchingService;

@Service
public class MatchingServiceImpl implements MatchingService {

	@Autowired
	private MatchingDao matchingDao;

	@Override
	public int matchComment(int reservationInfoId, int productId) {

		if (matchingDao.matchComment(reservationInfoId, productId) == null) {
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public int matchReservationInfo(int reservationInfoId, int productId) {
		if (matchingDao.matchReservationInfo(reservationInfoId, productId) == null) {
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public int matchReservationInfo(int reservationInfoId, String reservationEmail) {
		if (matchingDao.matchReservationInfo(reservationInfoId, reservationEmail) == null) {
			return 0;
		} else {
			return 1;
		}
	}

}
