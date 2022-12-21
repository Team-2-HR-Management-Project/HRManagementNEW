package team2.exception;

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
    LOGIN_ERROR_WRONG(1000, "Incorrect username or password.", INTERNAL_SERVER_ERROR),
    LOGIN_ERROR_REQUIRED_PASSWORD(1001, "Password does not fulfill the pre-conditions, please enter a valid password.", INTERNAL_SERVER_ERROR),
    LOGIN_ERROR_COMPANY_ERROR(1002, "Please enter a valid company name.", INTERNAL_SERVER_ERROR),
    COMPANY_NAME_DUPLICATE(1003, "This company already exists.", INTERNAL_SERVER_ERROR),
    COMPANY_NOT_FOUND(1004, "Company not found", INTERNAL_SERVER_ERROR),
    COMPANY_NOT_CREATED(1005, "Company could not be saved", INTERNAL_SERVER_ERROR),
    INVALID_ACTIVATION_CODE(1006, "Activation Code not found", INTERNAL_SERVER_ERROR),
    COMPANY_NOT_UPDATED(1008, "Company information could not be updated.", INTERNAL_SERVER_ERROR);
    private int code;
    private String message;
    HttpStatus httpStatus;
}
