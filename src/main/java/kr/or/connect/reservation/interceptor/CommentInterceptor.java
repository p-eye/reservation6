package kr.or.connect.reservation.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.or.connect.reservation.dto.ReservationInfo;

public class CommentInterceptor extends HandlerInterceptorAdapter {

	private static final String LOGIN = "login";
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 컨트롤러메서드 실행전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession httpSession = request.getSession();
		ReservationInfo reservationInfo = (ReservationInfo) httpSession.getAttribute(LOGIN);

		if (reservationInfo == null) {
			logger.info("no user is logged");
			httpSession.setAttribute("noUser", "noUser");
			saveDestination(request);
			response.sendRedirect("./bookingloginForm");
			return false;
		}

		else {
			httpSession.removeAttribute("noUser");
			logger.debug("{} 를 호출했습니다.", handler.toString());
			return true;
		}


	}

	private void saveDestination(HttpServletRequest request) {

		String uri = request.getRequestURI();
		String query = request.getQueryString();
		if (query == null || query.equals("null")) {
			query = "";
		} else {
			query = "?" + query;
		}

		if (request.getMethod().contentEquals("GET")) {
			logger.info("destination: " + (uri + query));
			request.getSession().setAttribute("destination", uri + query);
		}

	}

}
