package jjfactory.template.sns.entity;

import lombok.Getter;

@Getter
public enum Code {
    ERROR_CODE,
    NORMAL;

    private String hi = "";

    Code() {
    }

    Code(String hi) {
        this.hi = hi;
    }
}
