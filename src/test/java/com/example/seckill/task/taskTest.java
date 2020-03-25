package com.example.seckill.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class taskTest {

    @Scheduled(cron="0/5 * * * * ?")
    public void importToRedis(){
        System.out.println("哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈");
    }
}
