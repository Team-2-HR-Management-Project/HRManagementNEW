package com.team2.exception;

import lombok.Getter;

@Getter
public class LeaveManagerException extends RuntimeException{

    private final ErrorType errorType;

    public LeaveManagerException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public LeaveManagerException(ErrorType errorType, String customMessage){
        super(customMessage);
        this.errorType = errorType;
    }

}
