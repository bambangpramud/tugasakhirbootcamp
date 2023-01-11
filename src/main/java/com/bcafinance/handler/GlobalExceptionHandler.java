package com.bcafinance.handler;

import com.bcafinance.utils.ConstantMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Slf4j(topic = "GLOBAL_EXCEPTION_HANDLER")
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	private List<ApiValidationError> lsSubError = new ArrayList<ApiValidationError>();

//	@Override
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)/*UNTUK WEBSOCKET ATAU PROTOCOL LAIN SELAIN HTTP*/
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
																  HttpHeaders headers,
																  HttpStatus status,
																  WebRequest request) {
		lsSubError.clear();
		for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
			lsSubError.add(new ApiValidationError(fieldError.getField(),fieldError.getDefaultMessage()));
		}
		ApiError apiError =
				new ApiError(HttpStatus.UNPROCESSABLE_ENTITY,ConstantMessage.ERROR_UNPROCCESSABLE,ex,request.getDescription(false),"00001");
		apiError.setSubErrors(lsSubError);
		return ResponseEntity.unprocessableEntity().body(apiError);
	}

//	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, ConstantMessage.ERROR_MAIL_FORM_JSON, ex,request.getDescription(false),"00002"));
	}


	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		System.out.println("RESOURCE NOT FOUND EXCEPTION");
		return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND,ex.getMessage(),ex,request.getDescription(false),"00003"));
	}


	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Object> handleAllUncaughtException(Exception ex, WebRequest request) {

		System.out.println("INTERNAL SERVER ERROR => "+ex.getMessage());
		return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,ConstantMessage.ERROR_INTERNAL_SERVER,ex,request.getDescription(false),"X2013"));
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Object> dataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {

		System.out.println("DATA INTEGRITY ERROR => "+ex.getMessage());
		return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST,ConstantMessage.ERROR_DATA_INVALID,ex,request.getDescription(false),"X7006"));
	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return ResponseEntity.status(apiError.getStatus()).body(apiError);
	}

//	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,ConstantMessage.ERROR_UNEXPECTED,ex,request.getDescription(false),"X2236"));
	}

}