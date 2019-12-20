package kr.or.connect.reservation.controller.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmptyResultDataAccessExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public void handleEmptyResultDataAccessException(EmptyResultDataAccessException e) {

		
		System.out.println("----"+e.getMessage());

	}

}