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

	// /bookinglogin 실행 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute(LOGIN) != null) {
			
			// 로그인 정보 있으면 기존 로그인 정보 제거
			httpSession.removeAttribute(LOGIN);
		}

		return true;
	}

	// /bookinglogin 실행 후
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		ModelMap modelMap = modelAndView.getModelMap();
		ReservationInfo reservationInfo = (ReservationInfo) modelMap.get("reservationInfo");

		// 로그인 성공시
		if (reservationInfo != null) {
			
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute(LOGIN, reservationInfo);

			String reservationEmail = reservationInfo.getReservationEmail();
			Object destination = httpSession.getAttribute("destination");

			if (destination != null) {
				
				/* destination 세션 있을 때 = commet 페이지에서 넘어왔을 때
				 * 그 페이지로 redirect 후 destination 세션 삭제
				 */
				response.sendRedirect((String) destination);
				httpSession.removeAttribute("destination");

			} else {
				
				/* 없을 때 = main, detail + myreservation 페이지에서 넘어왔을 때
				 * 나의 예매내역 페이지로 이동
				 */
				response.sendRedirect("./myreservation?reservationEmail=" + reservationEmail);
			}

		}

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
}
