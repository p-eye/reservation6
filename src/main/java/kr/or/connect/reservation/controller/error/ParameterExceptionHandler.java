package kr.or.connect.reservation.controller.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ParameterExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public String handleMissingParams(MissingServletRequestParameterException e, Model model) {
		logger.error("{} parameter is missing", e.getParameterName());

		model.addAttribute("errorMsg", "비정상적인 접근입니다");
		return "alert";
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public String handleMissingParams(Model model, MethodArgumentTypeMismatchException e) {
		logger.error("{} requires {} type", e.getName(), e.getRequiredType());

		model.addAttribute("errorMsg", "비정상적인 접근입니다");
		return "alert";
	}

}