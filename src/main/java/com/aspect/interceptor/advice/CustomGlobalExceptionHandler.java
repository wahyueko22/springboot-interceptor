package com.aspect.interceptor.advice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.aspect.interceptor.constant.EnumerationMessage;
import com.aspect.interceptor.object.BaseDTO;
import com.aspect.interceptor.object.CustomException;
import com.aspect.interceptor.object.ValidationDTO;
import com.aspect.interceptor.object.ValidationMessage;

import org.springframework.validation.BindException;
import javax.validation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomGlobalExceptionHandler{
    private Logger logger = LoggerFactory.getLogger(CustomGlobalExceptionHandler.class);

 

    private ResponseEntity<Object> buildResponseEntity(BaseDTO baseDTO) {
        return new ResponseEntity<Object>(baseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Object> buildResponseEntityValidation(ValidationDTO validationDTO) {
        return new ResponseEntity<Object>(validationDTO, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> conflict(CustomException e) {
        logger.error("main exception", e.getException());
        logger.error("custom exception ", e);
        return buildResponseEntity(new BaseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getEnumerationMessage().getCode(),
        		e.getEnumerationMessage().getMessage(), "tacer"));
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        List<ValidationMessage> validationMessages = new ArrayList<ValidationMessage>();
        for (FieldError validation : e.getBindingResult().getFieldErrors()) {
            validationMessages.add(new ValidationMessage(validation.getField(), validation.getDefaultMessage()));
        }
        ValidationDTO validationDTO = new ValidationDTO(HttpStatus.UNPROCESSABLE_ENTITY.value(), EnumerationMessage.ERROR_VALIDATION_INPUT.getCode(),
                EnumerationMessage.ERROR_VALIDATION_INPUT.getMessage(), "12334", validationMessages);
        return buildResponseEntityValidation(validationDTO);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ValidationDTO> handleConstraintViolation(ConstraintViolationException e) {
        List<ValidationMessage> validationMessages = new ArrayList<ValidationMessage>();
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            logger.info(violation.getRootBeanClass().getName() + " -> " + 
              violation.getPropertyPath() + ": " + violation.getMessage());
            validationMessages.add(new ValidationMessage(violation.getPropertyPath().toString(), violation.getMessage()));
        }
        ValidationDTO validationDTO = new ValidationDTO(HttpStatus.UNPROCESSABLE_ENTITY.value(), EnumerationMessage.ERROR_VALIDATION_INPUT.getCode(),
                EnumerationMessage.ERROR_VALIDATION_INPUT.getMessage(), "12334", validationMessages);
        return  new ResponseEntity<ValidationDTO>(validationDTO, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    
    @ExceptionHandler(Exception.class) 
    public ResponseEntity<Object> errException(Exception e) {
        logger.error(e.getMessage(), e);
        BaseDTO baseDto = new BaseDTO();
        baseDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        baseDto.setCode(500);
        baseDto.setMessage("Oops something when wrong kkkkkk");
        baseDto.setTraceID("sdsfsd");
        ValidationDTO val = new ValidationDTO();
        val.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        val.setCode(500);
        val.setMessage("Oops something when wrong kkkkkk");
        val.setTraceID("sdsfsd");
        List<ValidationMessage> validationMessages = new ArrayList<ValidationMessage>();
        validationMessages.add(new ValidationMessage("key", "value"));
        val.setData(validationMessages);
        //return this.buildResponseEntity(val);
       return  buildResponseEntityValidation(val);
    }


   /*
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());

        //Get all errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>("suksessssss", headers, status);

    }
  */  
	/*
	 * @ExceptionHandler({MethodArgumentNotValidException.class,
	 * BindException.class}) public ResponseEntity<Object>
	 * handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
	 * List<ValidationDTO.ValidationMessage> validationMessages = new ArrayList<>();
	 * for (FieldError validation : e.getBindingResult().getFieldErrors()) {
	 * validationMessages.add(new
	 * ValidationDTO.ValidationMessage(validation.getField(),
	 * validation.getDefaultMessage())); } ValidationDTO validationDTO = new
	 * ValidationDTO(HttpStatus.UNPROCESSABLE_ENTITY.value(),
	 * EnumerationMessage.ERROR_VALIDATION_INPUT.getCode(),
	 * EnumerationMessage.ERROR_VALIDATION_INPUT.getMessage(),"tracer",
	 * validationMessages); return buildResponseEntityValidation(validationDTO); }
	 */

   

}