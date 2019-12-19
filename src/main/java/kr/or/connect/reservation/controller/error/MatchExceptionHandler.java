package kr.or.connect.reservation.controller.error;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import kr.or.connect.reservation.dto.exception.MatchException;

@ControllerAdvice
public class MatchExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(MatchException.class)
	public String handleMatchException(MatchException e, HttpServletRequest request, Model model) {

		String errorMsg = e.getMessage();
		logger.error(errorMsg);

		if (errorMsg.equals("이미 리뷰를 작성하셨습니다")) {

			// 세션등록이유: 내 예매내역 페이지에서 등록한 리뷰 있을 때만 현 페이지 새로고침 하려고 (view 호출 후 세션 삭제)
			request.getSession().setAttribute("currentURI", request.getHeader("referer"));
		}

		model.addAttribute("errorMsg", errorMsg);
		return "alert";

	}
}