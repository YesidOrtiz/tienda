package com.tienda.exceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
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

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(SearchItemNotFoundException.class)
    public Map<String,String> handleSearchItemNotFoundException(SearchItemNotFoundException e){
        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("errorMessage",e.getMessage());
        return errorMap;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(GenericException.class)
    public Map<String,String> handleGenericException(GenericException e){
        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("errorMessage",e.getMessage());
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
