package com.imooc.luckymoney.controller;

import com.imooc.luckymoney.domain.LimitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@Controller + @ResponseBody = @RestController
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private LimitConfig limitConfig;

    @GetMapping("/say")
//    @GetMapping("/say/{id}")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId){
//        return "说明：" + limitConfig.getDescription();
//        return "index";
        return "id:" + myId;
    }
}
