package com.imooc.luckymoney.controller;

import com.imooc.luckymoney.aspect.HttpAspect;
import com.imooc.luckymoney.domain.LimitConfig;
import com.imooc.luckymoney.domain.Luckymoney;
import com.imooc.luckymoney.repository.LuckymoneyRepository;
import com.imooc.luckymoney.Service.LuckymoneyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckeyMoneyController {

    private final static Logger logger = LoggerFactory.getLogger(LuckeyMoneyController.class);

    @Autowired
    private LuckymoneyRepository repository;

    @Autowired
    private LimitConfig limitConfig;

    @Autowired
    private LuckymoneyService service;

    @GetMapping("/luckymoneys")
    public List<Luckymoney> list() {
        logger.info("GET ALL LIST");
        return repository.findAll();
    }

    @PostMapping("/luckymoneys")
    public Luckymoney create(@Valid Luckymoney luckymoney, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        logger.info("POST MONEY");
        luckymoney.setProducer(luckymoney.getProducer());
        luckymoney.setMoney(luckymoney.getMoney());
        return repository.save(luckymoney);
    }

    @RequestMapping("/luckymoneys/{id}")
    public Luckymoney findById(@PathVariable("id") Integer id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/luckymoneys/{id}")
    public Luckymoney update(@PathVariable("id") Integer id,
                             @RequestParam("consumer") String consumer
    ) {
        Optional<Luckymoney> optional = repository.findById(id);
        if(optional.isPresent()) {
            Luckymoney luckymoney = optional.get();
            luckymoney.setId(id);
            luckymoney.setConsumer(consumer);
            return repository.save(luckymoney);
        }

        return null;
    }

    @PostMapping("/luckymoneys/two")
    public void createTwo() {
        service.createTwo();
    }


}
