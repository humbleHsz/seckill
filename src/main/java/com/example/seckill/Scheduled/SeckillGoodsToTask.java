package com.example.seckill.Scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务 向redis中添加数据
 */
@Component
public class SeckillGoodsToTask {

    @Scheduled(cron = "0/30 * * * * ?")
    public void importToRedis(){

        //查询合法商品  状态为有效（status） 库存量》0

    }

}
