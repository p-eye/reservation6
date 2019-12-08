package kr.or.connect.reservation.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.or.connect.reservation.dto.ReservationInfo;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final String LOGIN = "login";
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 컨트롤러메서드 실행전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute(LOGIN) != null) {
			// 기존의 로그인 정보 제거
			httpSession.removeAttribute(LOGIN);
		}

		logger.debug("{} 를 호출했습니다.", handler.toString());
		return true;
	}

	// 컨트롤러메서드 실행후
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		ModelMap modelMap = modelAndView.getModelMap();

		ReservationInfo reservationInfo = (ReservationInfo) modelMap.get("reservationInfo");

		if (reservationInfo != null) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute(LOGIN, reservationInfo);
			response.sendRedirect(
					"/reservation6/myreservation?reservationEmail=" + reservationInfo.getReservationEmail());

		}

		logger.debug("{} 가종료되었습니다. {} 를 view로 사용합니다.", handler.toString(), modelAndView.getViewName());

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
}
