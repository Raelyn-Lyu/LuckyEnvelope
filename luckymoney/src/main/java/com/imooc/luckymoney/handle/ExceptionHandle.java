package com.imooc.luckymoney.handle;

import com.imooc.luckymoney.domain.Result;
import com.imooc.luckymoney.exception.MoneyException;
import com.imooc.luckymoney.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof MoneyException) {
            MoneyException moneyException = (MoneyException) e;
            return ResultUtil.error(moneyException.getCode(), moneyException.getMessage());
        } else {
            return ResultUtil.error(-1, "unknow error");
        }

    }
}
