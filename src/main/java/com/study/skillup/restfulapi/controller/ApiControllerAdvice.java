package com.study.skillup.restfulapi.controller;

import com.study.skillup.restfulapi.error.ErrorMessage;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
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
    ErrorMessage res = new ErrorMessage();
    res.setErrorMassage(ex.getMessage());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
          HttpMediaTypeNotSupportedException ex,
          HttpHeaders headers,
          HttpStatus status,
          WebRequest webRequest) {
    ErrorMessage res = new ErrorMessage();
    res.setErrorMassage(ex.getMessage());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(
          HttpMediaTypeNotAcceptableException ex,
          HttpHeaders headers,
          HttpStatus status,
          WebRequest webRequest) {
    ErrorMessage res = new ErrorMessage();
    res.setErrorMassage(ex.getMessage());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleMissingPathVariable(
          MissingPathVariableException ex,
          HttpHeaders headers,
          HttpStatus status,
          WebRequest webRequest) {
    ErrorMessage res = new ErrorMessage();
    res.setErrorMassage(ex.getMessage());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleMissingServletRequestParameter(
          MissingServletRequestParameterException ex,
          HttpHeaders headers,
          HttpStatus status,
          WebRequest webRequest) {
    ErrorMessage res = new ErrorMessage();
    res.setErrorMassage(ex.getMessage());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleServletRequestBindingException(
          ServletRequestBindingException ex,
          HttpHeaders headers,
          HttpStatus status,
          WebRequest webRequest) {
    ErrorMessage res = new ErrorMessage();
    res.setErrorMassage(ex.getMessage());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleConversionNotSupported(
          ConversionNotSupportedException ex,
          HttpHeaders headers,
          HttpStatus status,
          WebRequest webRequest) {
    ErrorMessage res = new ErrorMessage();
    res.setErrorMassage(ex.getMessage());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleTypeMismatch(
          TypeMismatchException ex,
          HttpHeaders headers,
          HttpStatus status,
          WebRequest webRequest) {
    ErrorMessage res = new ErrorMessage();
    res.setErrorMassage(ex.getMessage());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(
          HttpMessageNotReadableException ex,
          HttpHeaders headers,
          HttpStatus status,
          WebRequest webRequest) {
    ErrorMessage res = new ErrorMessage();
    res.setErrorMassage(ex.getMessage());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleHttpMessageNotWritable(
          HttpMessageNotWritableException ex,
          HttpHeaders headers,
          HttpStatus status,
          WebRequest webRequest) {
    ErrorMessage res = new ErrorMessage();
    res.setErrorMassage(ex.getMessage());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
          MethodArgumentNotValidException ex,
          HttpHeaders headers,
          HttpStatus status,
          WebRequest webRequest) {
    ErrorMessage res = new ErrorMessage();
    res.setErrorMassage(ex.getMessage());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleMissingServletRequestPart(
          MissingServletRequestPartException ex,
          HttpHeaders headers,
          HttpStatus status,
          WebRequest webRequest) {
    ErrorMessage res = new ErrorMessage();
    res.setErrorMassage(ex.getMessage());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleBindException(
          BindException ex,
          HttpHeaders headers,
          HttpStatus status,
          WebRequest webRequest) {
    ErrorMessage res = new ErrorMessage();
    res.setErrorMassage(ex.getMessage());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleNoHandlerFoundException(
          NoHandlerFoundException ex,
          HttpHeaders headers,
          HttpStatus status,
          WebRequest webRequest) {
    ErrorMessage res = new ErrorMessage();
    res.setErrorMassage(ex.getMessage());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }

  @Override
  protected ResponseEntity<Object> handleAsyncRequestTimeoutException(
          AsyncRequestTimeoutException ex,
          HttpHeaders headers,
          HttpStatus status,
          WebRequest webRequest) {
    ErrorMessage res = new ErrorMessage();
    res.setErrorMassage(ex.getMessage());
    return super.handleExceptionInternal(ex, res, headers, status, webRequest);
  }
}
