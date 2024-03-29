package com.study.skillup.restfulapi.controller;

import com.study.skillup.restfulapi.error.ErrorResponse;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiControllerAdvice extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
      HttpRequestMethodNotSupportedException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest webRequest) {
    ErrorResponse res = new ErrorResponse();
    res.setErrorMassage(ex.getMessage());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
      HttpMediaTypeNotSupportedException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest webRequest) {
    ErrorResponse res = new ErrorResponse();
    res.setErrorMassage(ex.getMessage());
    res.setStatus(status.value());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(
      HttpMediaTypeNotAcceptableException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest webRequest) {
    ErrorResponse res = new ErrorResponse();
    res.setErrorMassage(ex.getMessage());
    res.setStatus(status.value());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleMissingPathVariable(
      MissingPathVariableException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest webRequest) {
    ErrorResponse res = new ErrorResponse();
    res.setErrorMassage(ex.getMessage());
    res.setStatus(status.value());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleMissingServletRequestParameter(
      MissingServletRequestParameterException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest webRequest) {
    ErrorResponse res = new ErrorResponse();
    res.setErrorMassage(ex.getMessage());
    res.setStatus(status.value());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleServletRequestBindingException(
      ServletRequestBindingException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest webRequest) {
    ErrorResponse res = new ErrorResponse();
    res.setErrorMassage(ex.getMessage());
    res.setStatus(status.value());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleConversionNotSupported(
      ConversionNotSupportedException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest webRequest) {
    ErrorResponse res = new ErrorResponse();
    res.setErrorMassage(ex.getMessage());
    res.setStatus(status.value());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleTypeMismatch(
      TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest webRequest) {
    ErrorResponse res = new ErrorResponse();
    res.setErrorMassage(ex.getMessage());
    res.setStatus(status.value());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(
      HttpMessageNotReadableException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest webRequest) {
    ErrorResponse res = new ErrorResponse();
    res.setErrorMassage(ex.getMessage());
    res.setStatus(status.value());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleHttpMessageNotWritable(
      HttpMessageNotWritableException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest webRequest) {
    ErrorResponse res = new ErrorResponse();
    res.setErrorMassage(ex.getMessage());
    res.setStatus(status.value());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest webRequest) {
    ErrorResponse res = new ErrorResponse();
    res.setErrorMassage(ex.getMessage());
    res.setStatus(status.value());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleMissingServletRequestPart(
      MissingServletRequestPartException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest webRequest) {
    ErrorResponse res = new ErrorResponse();
    res.setErrorMassage(ex.getMessage());
    res.setStatus(status.value());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleBindException(
      BindException ex, HttpHeaders headers, HttpStatus status, WebRequest webRequest) {
    ErrorResponse res = new ErrorResponse();
    res.setErrorMassage(ex.getMessage());
    res.setStatus(status.value());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleNoHandlerFoundException(
      NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest webRequest) {
    ErrorResponse res = new ErrorResponse();
    res.setErrorMassage(ex.getMessage());
    res.setStatus(status.value());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleAsyncRequestTimeoutException(
      AsyncRequestTimeoutException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest webRequest) {
    ErrorResponse res = new ErrorResponse();
    res.setErrorMassage(ex.getMessage());
    res.setStatus(status.value());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @ExceptionHandler({ChangeSetPersister.NotFoundException.class})
  public ResponseEntity<Object> handle404(ChangeSetPersister.NotFoundException ex, WebRequest request) {
    HttpHeaders headers = new HttpHeaders();
    ErrorResponse body = new ErrorResponse();
    HttpStatus status = HttpStatus.NOT_FOUND;

    return this.handleExceptionInternal(ex, body, headers, status, request);
  }
}
