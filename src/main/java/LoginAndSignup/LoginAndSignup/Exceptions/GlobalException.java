package LoginAndSignup.LoginAndSignup.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(userException.class)
    public ResponseEntity<ApiError> handlePrimeException(userException e, WebRequest request){
        ApiError apiError=new ApiError();
        if(null==e.getMessage() || e.getMessage().isEmpty()){
            apiError.setMessage(e.getMessage());
        }
        else{
            apiError.setMessage(e.getMessage().toString());
        }
        apiError.setHttpStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);
    }
}
