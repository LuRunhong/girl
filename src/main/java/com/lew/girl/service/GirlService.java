package com.lew.girl.service;

import com.lew.girl.domain.Girl;
import com.lew.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional   //事务操作注解
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setAge(19);
        girlRepository.save(girlB);
    }
}
