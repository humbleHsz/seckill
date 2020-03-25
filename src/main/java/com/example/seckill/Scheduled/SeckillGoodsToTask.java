package com.example.seckill.Scheduled;

import com.example.seckill.pojo.doo.TbSeckillGoods;
import com.example.seckill.repositioy.jpa.TbSeckillGoodsRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 定时任务 向redis中添加数据
 */
@Component
public class SeckillGoodsToTask {

    private  static String startTime="2017-10-10";
    private  static String endTime="2017-10-28";

    @Resource
    private TbSeckillGoodsRepository tbSeckillGoodsRepository;

    @Resource
    private RedisTemplate redisTemplate;

    @Scheduled(cron = "0/30 * * * * ?")
    public void importToRedis(){
        //查询合法商品  状态为有效（status） 库存量》0
        List<TbSeckillGoods> goodsList = tbSeckillGoodsRepository.findGoodsToRedis(startTime, endTime);
        goodsList.stream().forEach(item->{
            redisTemplate.boundHashOps();
        });

    }

}
