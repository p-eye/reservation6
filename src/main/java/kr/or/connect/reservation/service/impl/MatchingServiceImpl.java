package kr.or.connect.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.MatchingDao;
import kr.or.connect.reservation.dto.exception.MatchException;
import kr.or.connect.reservation.service.MatchingService;

@Service
public class MatchingServiceImpl implements MatchingService {

	private final MatchingDao matchingDao;

	@Autowired
	public MatchingServiceImpl(MatchingDao matchingDao) {
		this.matchingDao = matchingDao;
	}

	@Override
	public void matchCommentWrite(int reservationInfoId, String loginedEmail, int productId) {

		// 로그인 이메일과 예매id가 일치하지 않을 때 = 내가 예매한게 아님
		if (!isReservationInfoMatched(reservationInfoId, loginedEmail)) {
			throw new MatchException("예매 정보를 찾을 수 없습니다");
		}

		// 상품id와 예매id가 일치하지 않을 때 = 그런 예매내역 자체가 없음
		if (!isReservationInfoMatched(reservationInfoId, productId)) {
			throw new MatchException("예매 정보를 찾을 수 없습니다");
		}

		// 내가 예매했지만 이미 리뷰를 등록했을 때
		if (isCommentMatched(reservationInfoId, productId)) {
			throw new MatchException("이미 리뷰를 작성하셨습니다");
		}
	}

	@Override
	public void matchEmail(String reservationEmail, String loginedEmail) {

		// 로그인 이메일과 url 이메일이 다를 때
		if (!isEmailMatched(reservationEmail, loginedEmail)) {
			throw new MatchException("올바르지 않은 이메일입니다");
		}
	}

	public boolean isEmailMatched(String reservationEmail, String loginedEmail) {
		if (!reservationEmail.equals(loginedEmail)) {
			return IS_NOT_MATCHED;
		} else {
			return IS_MATCHED;
		}
	}

	public boolean isCommentMatched(int reservationInfoId, int productId) {
		if (matchingDao.matchComment(reservationInfoId, productId) == null) {
			return IS_NOT_MATCHED;
		} else {
			return IS_MATCHED;
		}
	}

	public boolean isReservationInfoMatched(int reservationInfoId, int productId) {
		if (matchingDao.matchReservationInfo(reservationInfoId, productId) == null) {
			return IS_NOT_MATCHED;
		} else {
			return IS_MATCHED;
		}
	}

	public boolean isReservationInfoMatched(int reservationInfoId, String loginedEmail) {
		if (matchingDao.matchReservationInfo(reservationInfoId, loginedEmail) == null) {
			return IS_NOT_MATCHED;
		} else {
			return IS_MATCHED;
		}
	}

}
