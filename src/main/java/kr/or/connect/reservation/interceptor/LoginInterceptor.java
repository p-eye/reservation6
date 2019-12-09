package kr.or.connect.reservation.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.UriComponentsBuilder;

import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.service.ReservationService;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final String LOGIN = "login";
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ReservationService reservationService;

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

		
		logger.debug("{} 가종료되었습니다. {} 를 view로 사용합니다.", handler.toString(), modelAndView.getViewName());
		
		if (reservationInfo != null) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute(LOGIN, reservationInfo);
			String loginReferer = (String) httpSession.getAttribute("loginReferer");
			if(loginReferer.contains("reviewWrite")) {
			
				response.sendRedirect(loginReferer);
			}
			
			else {
			response.sendRedirect(
					"./myreservation?reservationEmail=" + reservationInfo.getReservationEmail());
			}
		}

		
		/*
		
		if (reservationInfo != null) {

		
			System.out.println("111111111111111");
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute(LOGIN, reservationInfo);
			String loginReferer = (String) httpSession.getAttribute("loginReferer");

			if (loginReferer.contains("productId")) {
				System.out.println("22222");
				String reservationEmail = reservationInfo.getReservationEmail();


					MultiValueMap<String, String> parameters = UriComponentsBuilder.fromUriString(loginReferer).build()
							.getQueryParams();

					int productId = Integer.parseInt(parameters.get("productId").get(0));

					System.out.println(reservationEmail);
					System.out.println(productId);
					if(reservationEmail !=null) {
					System.out.println(reservationService.getReservationInfoList(reservationEmail));}
					try {
					int isMatchedReservationInfo = reservationService.matchReservationInfo(productId, reservationEmail); // 왜 여기서 널이 뜰까
					

					if (isMatchedReservationInfo != 0) {
 
						System.out.println("33333");
						response.sendRedirect(loginReferer);

					}

					else {

						System.out.println("44444");
						System.out.println("예매정보를 찾을 수 없습니다");
						response.sendRedirect("./");

					}

				} catch (Exception e) {

				}
			}

			else {

				System.out.println("555555");
				response.sendRedirect("./myreservation?reservationEmail=" + reservationInfo.getReservationEmail());
			}
		}

		System.out.println("66666");
		logger.debug("{} 가종료되었습니다. {} 를 view로 사용합니다.", handler.toString(), modelAndView.getViewName());

*/
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
}
