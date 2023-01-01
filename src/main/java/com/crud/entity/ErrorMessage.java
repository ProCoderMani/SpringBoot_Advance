package com.crud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
// this class is being used to display the desired execption message to the client with restResponse
public class ErrorMessage {
    private HttpStatus status;
    private String message;
}
