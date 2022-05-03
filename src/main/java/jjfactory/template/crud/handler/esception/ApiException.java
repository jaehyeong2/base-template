package jjfactory.template.crud.handler.esception;

public class ApiException extends RuntimeException{
    public ApiException(String message) {
        super(message);
    }
}
