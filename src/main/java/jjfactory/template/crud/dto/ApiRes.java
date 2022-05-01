package jjfactory.template.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ApiRes<T> {
    T data;
    String message;

    public ApiRes(T data) {
        this.data = data;
    }

    public ApiRes(String message) {
        this.message = message;
    }
}
