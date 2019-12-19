package kr.or.connect.reservation.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class EmailInterceptor extends HandlerInterceptorAdapter {

	private static final String LOGIN = "login";
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// /myReservation 실행 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute(LOGIN) == null) {

			logger.info("no user is logged");

			response.sendRedirect("./bookingloginForm");
			return false;
		}

		else {
			
			/*로그인 정보 있을 때 myresevation 컨트롤러로 */
			logger.debug("{} 를 호출했습니다.", handler.toString());
			
			return true;
		}

	}

	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
	

}
