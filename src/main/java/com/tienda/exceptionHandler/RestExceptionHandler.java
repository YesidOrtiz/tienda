package com.tienda.exceptionHandler;

import com.tienda.exceptionHandler.excepciones.InvalidInputException;
import com.tienda.exceptionHandler.excepciones.ItemAlreadyExistException;
import com.tienda.exceptionHandler.excepciones.SearchItemNotFoundException;
import com.tienda.exceptionHandler.models.ModelResponseForREST;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(SearchItemNotFoundException.class)
    public ModelResponseForREST handleSearchItemNotFoundException(SearchItemNotFoundException e){
        return new ModelResponseForREST(e.getMessage());
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ItemAlreadyExistException.class)
    public ModelResponseForREST handleItemAlreadyExistException(ItemAlreadyExistException e){
        return new ModelResponseForREST(e.getMessage());
    }
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(InvalidInputException.class)
    public ModelResponseForREST handleInvalidInputException(InvalidInputException e){
        return new ModelResponseForREST(e.getMessage());
    }
    /*

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException e) {
        Map<String, String> errorMap = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ItemAlreadyExistException.class)
    public Map<String,String> handleItemAlreadyExistException(ItemAlreadyExistException e){
        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("errorMessage",e.getMessage());
        return errorMap;
    }
}
    * */
}
