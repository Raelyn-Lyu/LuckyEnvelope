package com.imooc.luckymoney.Service;

import com.imooc.luckymoney.domain.Luckymoney;
import com.imooc.luckymoney.repository.LuckymoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
@Service
public class LuckymoneyService {

    @Autowired
    private LuckymoneyRepository repository;

//    数据库事务
    @Transactional
    public void createTwo() {
        Luckymoney luckymoney1 = new Luckymoney();
        luckymoney1.setProducer("raelyn");
        luckymoney1.setMoney(new BigDecimal(520));
        repository.save(luckymoney1);

        Luckymoney luckymoney2 = new Luckymoney();
        luckymoney2.setProducer("raelyn");
        luckymoney2.setMoney(new BigDecimal(1314));
        repository.save(luckymoney2);

    }
}
