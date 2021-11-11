package com.application.exception.handler;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.application.exception.BadRequestException;
import com.application.exception.InternalProblemException;
import com.application.exception.InternalServerError;
import com.application.model.ApiErrorModel;
import com.application.util.ExceptionMessageUtil;
import com.application.util.RootException;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ApiErrorModel> handleBadRequestException(BadRequestException exception) {
		List<String> msgs = Arrays.asList(exception.getMessage());
		Date date = new Date();
		int statusCode = HttpStatus.BAD_REQUEST.value();

		ApiErrorModel error = new ApiErrorModel(statusCode, msgs, date);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(InternalProblemException.class)
	public ResponseEntity<ApiErrorModel> handleInternalProblemException(InternalProblemException exception) {
		List<String> msgs = Arrays.asList(exception.getMessage());
		Date date = new Date();
		int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();

		ApiErrorModel error = new ApiErrorModel(statusCode, msgs, date);

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}

	
	@ExceptionHandler(InternalServerError.class)
	public ResponseEntity<ApiErrorModel> handleInternalServerError(InternalServerError exception) {
		List<String> msgs = Arrays.asList(exception.getMessage());
		Date date = new Date();
		int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();

		ApiErrorModel error = new ApiErrorModel(statusCode, msgs, date);

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}
	
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<ApiErrorModel> handleSQLServerException(SQLException exception) {
		List<String> msgs = Arrays.asList(exception.getMessage());
		Date date = new Date();
		int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();

		ApiErrorModel error = new ApiErrorModel(statusCode, msgs, date);

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
		List<String> msgs = Arrays.asList(ExceptionMessageUtil.getFormatedMessage(RootException.getRootExceptionMessage(exception)));
		Date date = new Date();
		int statusCode = HttpStatus.BAD_REQUEST.value();
		
		ApiErrorModel error = new ApiErrorModel(statusCode, msgs, date);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException exception) {
		List<String> msgs = Arrays.asList(exception.getMessage());
		Date date = new Date();
		int statusCode = HttpStatus.BAD_REQUEST.value();
		
		ApiErrorModel error = new ApiErrorModel(statusCode, msgs, date);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
}
