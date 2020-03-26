package com.example.seckill.Scheduled;

import com.example.seckill.common.Utils.SystemConst;
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

    @Scheduled(cron = "0/10 * * * * ?")
    public void importToRedis(){
        //查询合法商品  状态为有效（status） 库存量》0
        List<TbSeckillGoods> goodsList = tbSeckillGoodsRepository.findGoodsToRedis(startTime, endTime);
        goodsList.stream().forEach(item->{
            //为每一个商品创建一个队列，队列中放和库存量相同的商品id，这样为了解决并发下的超卖问题。

            createQueue(item.getId(),item.getStockCount());
           redisTemplate.boundHashOps(TbSeckillGoods.class.getSimpleName()).put(item.getId(),item);
        });


    }

    private void createQueue(Long id,Integer stockCount){
        if(stockCount>0){
           for(int i=0;i<stockCount;i++){
               redisTemplate.boundListOps(SystemConst.CONST_SECKILLGOODS_ID_PREFIX+id).leftPush(id);
           }
        }else {return;}
    }

}
