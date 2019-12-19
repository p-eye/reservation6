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

	// /reviewWrite, myreservation 실행 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute(LOGIN) == null) {
			/* 로그인 정보 있을 때 */

			logger.info("no user is logged in");

			if (request.getRequestURI().contains("reviewWrite")) {
				/*
				 * reviewWrite 페이지에서 넘어왔을 때 
				 * 로그인 후 돌아갈 페이지 (= 현재페이지)를 destination으로 저장한다 
				 * 로그인 폼으로 리다이렉트
				 */
				saveDestination(request);
			}
			response.sendRedirect("./bookingloginForm");
			return false;
		}

		else {

			/* 로그인 정보 있을 때 해당 컨트롤러로 */
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

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		/* reviewWrite에서 return View 한 후 세션 삭제 */
		request.getSession().removeAttribute("currentURI");
	}

}
