package jjfactory.template.crud.handler.aop;

import jjfactory.template.crud.handler.esception.ValidationApiException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.xml.bind.ValidationException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Aspect
public class ValidationAOP {

    @Around("execution(* jjfactory.template.crud.controller.*Controller.*(..))")
    public Object advice(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("컨트롤러 호출");

        Object[] args = joinPoint.getArgs();
        for(Object arg : args){
            if(arg instanceof BindingResult) {
                BindingResult bindingResult = (BindingResult) arg;

                if(bindingResult.hasErrors()){
                    Map<String,String> errorMap = new HashMap<>();

                    for(FieldError error : bindingResult.getFieldErrors()){
                        errorMap.put(error.getField(),error.getDefaultMessage());
                        throw new ValidationException("유효성 검사 실패");
                    }
                }

            }
        }
        return joinPoint.proceed();
    }

    @Around("execution(* jjfactory.template.crud.controller.api.*Controller.*(..))")
    public Object apiAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("api컨트롤러 호출");

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult bindingResult = (BindingResult) arg;

                if (bindingResult.hasErrors()) {
                    Map<String, String> errorMap = new HashMap<>();

                    for (FieldError error : bindingResult.getFieldErrors()) {
                        errorMap.put(error.getField(), error.getDefaultMessage());
                        throw new ValidationApiException("유효성 검사 실패");
                    }
                }

            }
        }
        return joinPoint.proceed();
    }
}
