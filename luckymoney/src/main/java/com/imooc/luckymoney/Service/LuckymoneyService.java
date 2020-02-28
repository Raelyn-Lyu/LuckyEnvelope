package com.imooc.luckymoney.Service;

import com.imooc.luckymoney.domain.Luckymoney;
import com.imooc.luckymoney.exception.MoneyException;
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

    public void getValue(Integer id) throws Exception{
        Luckymoney luckymoney = repository.getOne(id);
        BigDecimal money = luckymoney.getMoney();
        if (money.compareTo(new BigDecimal(10)) == 0 ) {
            throw new MoneyException(100, "非法金额" + money);
        } else if (money.compareTo(new BigDecimal(16)) == 0){
            throw new MoneyException(101, "非法金额" + money);
        }
    }
}
