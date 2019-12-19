package kr.or.connect.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.MatchingDao;
import kr.or.connect.reservation.dto.response.MsgResponse;
import kr.or.connect.reservation.service.MatchingService;

@Service
public class MatchingServiceImpl implements MatchingService {

	private final MatchingDao matchingDao;

	@Autowired
	public MatchingServiceImpl(MatchingDao matchingDao) {
		this.matchingDao = matchingDao;
	}

	@Override
	public MsgResponse getMsgResponse(int reservationInfoId, String reservationEmail, int productId) {

		// 로그인 이메일과 예매id가 일치하지 않을 때 = 내가 예매한게 아님
		if (!isReservationInfoMatched(reservationInfoId, reservationEmail)) {
			return new MsgResponse("예매 정보를 찾을 수 없습니다");
		}

		// 상품id와 예매id가 일치하지 않을 때 = 그런 예매내역 자체가 없음
		if (!isReservationInfoMatched(reservationInfoId, productId)) {
			return new MsgResponse("예매 정보를 찾을 수 없습니다");
		}

		// 내가 예매했지만 이미 리뷰를 등록했을 때
		if (isCommentMatched(reservationInfoId, productId)) {
			return new MsgResponse("이미 리뷰를 작성하셨습니다");
		}

		return null;
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

	public boolean isReservationInfoMatched(int reservationInfoId, String reservationEmail) {
		if (matchingDao.matchReservationInfo(reservationInfoId, reservationEmail) == null) {
			return IS_NOT_MATCHED;
		} else {
			return IS_MATCHED;
		}
	}

}
