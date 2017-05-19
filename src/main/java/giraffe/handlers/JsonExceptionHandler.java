package giraffe.handlers;

import giraffe.domain.GiraffeException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Handle errors from Ajax requests
 *
 * @author Olga Gushchyna
 * @version 0.0.1
 */
@ControllerAdvice
@Order(2)
public class JsonExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public GiraffeException.ErrorResponse handleErrorJson(Exception e) {

        GiraffeException.ErrorResponse errorResponse = new GiraffeException.ErrorResponse();

        errorResponse.setMessage(e.getMessage());
        if (e instanceof GiraffeException) errorResponse.setErrorCode(((GiraffeException) e).getErrorCode());

        return errorResponse;
    }

}
