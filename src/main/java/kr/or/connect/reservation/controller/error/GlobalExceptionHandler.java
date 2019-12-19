package kr.or.connect.reservation.controller.error;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import kr.or.connect.reservation.dto.error.MatchException;
import kr.or.connect.reservation.dto.response.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

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

	@ExceptionHandler(MatchException.class)
	public String handleMatchException(Model model, MatchException e, HttpServletRequest request) {

		String errorMsg = e.getMessage();
		if (errorMsg.equals("이미 리뷰를 작성하셨습니다")) {

			// 세션등록이유: 내 예매내역 페이지에서 등록한 리뷰 있을 때만 현 페이지 새로고침 하려고 (view 호출 후 세션 삭제)
			request.getSession().setAttribute("currentURI", request.getHeader("referer"));
		}
		
		model.addAttribute("errorMsg", errorMsg);
		return "alert";

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

		List<ApiResponse> errors = new ArrayList<>();

		for (FieldError filedError : e.getBindingResult().getFieldErrors()) {
			logger.error("{}: {}", filedError.getField(), filedError.getDefaultMessage());
			errors.add(new ApiResponse(400, filedError.getField() + ": " + filedError.getDefaultMessage()));
		}

		return new ResponseEntity(errors, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(BindException.class)
	public ResponseEntity<Object> handleBindException(BindException e) {

		List<ApiResponse> errors = new ArrayList<>();

		for (FieldError filedError : e.getBindingResult().getFieldErrors()) {
			logger.error("{}: {}", filedError.getField(), filedError.getDefaultMessage());
			errors.add(new ApiResponse(400, filedError.getField() + ": " + filedError.getDefaultMessage()));
		}

		return new ResponseEntity(errors, HttpStatus.BAD_REQUEST);

	}

}