package kr.or.connect.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.CommentDao;
import kr.or.connect.reservation.dao.ReservationInfoDao;
import kr.or.connect.reservation.service.MatchingService;

@Service
public class MatchingServiceImpl implements MatchingService {

	@Autowired
	private CommentDao commentDao;

	@Autowired
	private ReservationInfoDao reservationInfoDao;

	@Override
	public int matchComment(int reservationInfoId, int productId) {

		if (commentDao.matchComment(reservationInfoId, productId) == null) {
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public int matchReservationInfo(int reservationInfoId, int productId) {
		if (reservationInfoDao.matchReservationInfo(reservationInfoId, productId) == null) {
			return 0;
		} else {
			return 1;
		}
	}

}
