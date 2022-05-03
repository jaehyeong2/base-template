package jjfactory.template.crud.handler.esception;

import java.util.Map;

public class ValidationApiException extends RuntimeException{

    private Map<String,String> errorMap;

    public ValidationApiException(String message) {
        super(message);
    }

    public ValidationApiException(String message, Map<String, String> errorMap) {
        super(message);
        this.errorMap = errorMap;
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }
}
