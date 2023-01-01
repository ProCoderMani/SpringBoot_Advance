package com.crud.error;

import com.crud.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
// responsible for showing exact message to client
public class RestResponseEntityExecptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentbyIdNotFoundExecption.class)
    public ResponseEntity<ErrorMessage> DepartmentbyIdNotFoundExecptionHandler(DepartmentbyIdNotFoundExecption execption, WebRequest request) {

        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,execption.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);

    }

}
