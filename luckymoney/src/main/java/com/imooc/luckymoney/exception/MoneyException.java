package com.imooc.luckymoney.exception;

public class MoneyException extends RuntimeException {
    private Integer code;

    public MoneyException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
