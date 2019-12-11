package kr.or.connect.reservation.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommentInterceptor extends HandlerInterceptorAdapter {

	private static final String LOGIN = "login";
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// /reviewWrite 실행 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute(LOGIN) == null) {
			
			// 로그인 정보 없을 때
			logger.info("no user is logged");

			saveDestination(request);
			response.sendRedirect("./bookingloginForm");
			return false;
		}

		else {
			
			//로그인 정보 있을 때
			
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
