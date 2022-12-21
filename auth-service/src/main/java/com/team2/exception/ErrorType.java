package com.team2.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorType {
    INTERNAL_ERROR(2000, "Internal Server Error", INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(2001, "Invalid Parameter Error", BAD_REQUEST),
    INVALID_TOKEN(2002, "Invalid Token", BAD_REQUEST),
    LOGIN_ERROR_WRONG(1000, "Incorrect email or password.", INTERNAL_SERVER_ERROR),
    LOGIN_ERROR_REQUIRED_PASSWORD(1001, "Password does not fulfill the pre-conditions, please enter a valid password.", INTERNAL_SERVER_ERROR),
    LOGIN_ERROR_USERNAME_ERROR(1002, "Please enter a valid username", INTERNAL_SERVER_ERROR),
    USERNAME_DUPLICATE(1003, "This username already exists, please choose another username", INTERNAL_SERVER_ERROR),
    AUTH_NOT_FOUND(1004, "The auth could not be found.", INTERNAL_SERVER_ERROR),
    AUTH_NOT_CREATED(1005, "The auth could not be created", INTERNAL_SERVER_ERROR),
    INVALID_ACTIVATION_CODE(1006, "Activation Code not found", INTERNAL_SERVER_ERROR),
    ROLE_NOT_FOUND(1007, "Role not found.", INTERNAL_SERVER_ERROR),
    AUTH_NOT_DELETED(1008, "The auth could not be deleted.", INTERNAL_SERVER_ERROR);

    private int code;
    private String message;
    HttpStatus httpStatus;
}