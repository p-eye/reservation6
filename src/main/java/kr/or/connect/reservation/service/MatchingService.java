package kr.or.connect.reservation.service;

import org.springframework.stereotype.Service;

@Service
public interface MatchingService {

	public final boolean IS_MATCHED = true;
	public final boolean IS_NOT_MATCHED = false;

	public void matchCommentWrite(int reservationInfoId, String loginedEmail, int productId);

	public void matchEmail(String reservationEmail, String loginedEmail);

}
