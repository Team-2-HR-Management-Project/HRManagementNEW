package com.team2.exception;

import lombok.Getter;

@Getter
public class ExpenseManagerException extends RuntimeException{

    private final ErrorType errorType;

    public ExpenseManagerException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public ExpenseManagerException(ErrorType errorType, String customMessage){
        super(customMessage);
        this.errorType = errorType;
    }

}
