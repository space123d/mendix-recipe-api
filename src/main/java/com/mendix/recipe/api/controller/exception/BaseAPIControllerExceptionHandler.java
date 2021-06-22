package com.mendix.recipe.api.controller.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mendix.recipe.api.model.generated.ErrorMessage;
import com.mendix.recipe.api.model.generated.ErrorObject;

public class BaseAPIControllerExceptionHandler extends ResponseEntityExceptionHandler {

	/** 'Unexpected' exceptions **/
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleUnexpectedException(Exception ex) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		String preamble = "An unexpected Exception occurred: ";
		String message = "An unexpected error occurred. Please check the internal logs for more details.";

		logException(preamble, ex);
		return buildErrorResponse(status, message);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
		HttpStatus status = HttpStatus.CONFLICT;
		String preamble = "A Constraint Violation Exception occurred: ";
		String message = "A Data Constraint error occurred. Please check the internal logs for more details.";

		logException(preamble, ex.getSQLException());
		return buildErrorResponse(status, message);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public final ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		// Unique Key constraint violations should return HTTP status 409
		if (ex.getCause().getClass().equals(ConstraintViolationException.class)) {
			status = HttpStatus.CONFLICT;
		}
		String preamble = "A Data Integrity Exception occurred: ";
		String message = "A Data Integrity error occurred. Please check the internal logs for more details.";

		Exception extractedException = extractException(ex);

		logException(preamble, extractedException);
		return buildErrorResponse(status, message);
	}

	/** API Semantics exceptions **/
	@ExceptionHandler(javax.validation.ConstraintViolationException.class)
	public final ResponseEntity<Object> handleAPISemanticsConstraintViolationException(
			javax.validation.ConstraintViolationException ex) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String preamble = "A API Semantics Constraint Violation occurred: ";
		String message = "Non-allowed parameters/arguments were passed in the incoming request. Please check the internal logs for more details.";

		logException(preamble, ex);
		return buildErrorResponse(status, message);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public final ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String preamble = "An Illegal Argument Exception occurred: ";
		String message = "Non-allowed parameters/arguments were passed in the incoming request. Please check the internal logs for more details.";

		logException(preamble, ex);
		return buildErrorResponse(status, message);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
		HttpStatus errorStatus = HttpStatus.BAD_REQUEST;
		String preamble = "A Method Argument Type Mismatch Exception occurred: ";
		String message = "The request has invalid request arguments. Please check the internal logs for more details.";

		logException(preamble, ex);
		return buildErrorResponse(errorStatus, message);
	}

	@Override
	public final ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String preamble = "An Invalid Request Parameters Exception occurred: ";
		String message = "Invalid or unexpected parameters/arguments were passed in the incoming request. Please check the internal logs for more details.";

		logException(preamble, ex);
		return buildErrorResponse(status, message);
	}

	@Override
	public final ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		HttpStatus errorStatus = HttpStatus.BAD_REQUEST;
		String preamble = "A Servlet Request Binding Exception occurred: ";
		String message = "There is a mismatch on the expected request parameters type/format. Please check the internal logs for more details.";

		logException(preamble, ex);
		return buildErrorResponse(errorStatus, message);
	}

	// Handle error that gets thrown when request is not valid format, such as not
	// fulfilling @Valid parameters and/or @Min constraints
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		HttpStatus errorStatus = HttpStatus.BAD_REQUEST;
		String preamble = "A Method Argument Not Valid Exception occurred: ";
		String message = "The request is missing required request arguments or the request body is invalid. Please check the internal logs for more details.";

		logException(preamble, ex);
		return buildErrorResponse(errorStatus, message);
	}

	// Handle error that gets thrown when wrong type of values are used for
	// properties
	@Override
	public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		HttpStatus errorStatus = HttpStatus.BAD_REQUEST;
		String preamble = "A Http Message Not Readable Exception Occurred: ";
		String message = "The request cannot be fulfilled due to bad syntax. Please adjust the type of the values and check the internal logs for more details.";

		logException(preamble, ex);
		return buildErrorResponse(errorStatus, message);
	}

	@Override
	public ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		HttpStatus errorStatus = HttpStatus.BAD_REQUEST;
		String preamble = "Missing Servlet Request Parameter Exception: ";
		String message = "Missing required parameter. Please check the internal logs for more details.";

		logException(preamble, ex);
		return buildErrorResponse(errorStatus, message);
	}

	protected void logException(String preamble, Exception exception) {
		String innerMessage = "";
		if (exception.getCause() != null) {
			innerMessage = exception.getCause().getMessage();
		}
		logger.error(String.format("%s%s %s", preamble, exception.getMessage(), innerMessage));

	}

	protected ResponseEntity<Object> buildErrorResponse(HttpStatus httpStatus, String message) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setMessage(message);

		ErrorObject errorObject = new ErrorObject();
		errorObject.addErrorMessagesItem(errorMessage);

		return new ResponseEntity<>(errorObject, httpStatus);
	}

	/** Helper methods **/
	protected Exception extractException(Exception exception) {
		Exception extractedException = exception;

		try {
			Throwable firstLevelException = exception.getCause();
			Throwable targetException = firstLevelException.getCause();
			extractedException = new Exception(targetException.getMessage());
		} catch (Exception e) {
			return extractedException;
		}

		return extractedException;
	}
}
