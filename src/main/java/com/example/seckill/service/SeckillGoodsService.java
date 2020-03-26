package com.example.seckill.service;

import com.example.seckill.common.Utils.IdWorker;
import com.example.seckill.common.Utils.Result;
import com.example.seckill.common.Utils.ReturnDTO;
import com.example.seckill.common.Utils.SystemConst;
import com.example.seckill.pojo.doo.TbSeckillGoods;
import com.example.seckill.pojo.doo.TbSeckillOrder;
import com.example.seckill.repositioy.jpa.TbSeckillGoodsRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SeckillGoodsService {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private TbSeckillGoodsRepository tbSeckillGoodsRepository;

    @Resource
    private IdWorker idWorker;


    public List<TbSeckillGoods> finaAll(){
        return tbSeckillGoodsRepository.findAllGoods();
    }

    public TbSeckillGoods findOne(Long id){
        return  tbSeckillGoodsRepository.findById(id);
    }

    /**
     * 生成订单操作
     * @param id
     * @param userId
     * @return
     */
    public Result saveOrder(Long id,String userId){

        //从redis 队列中获取
        Long goodsId = (Long)redisTemplate.boundListOps(SystemConst.CONST_SECKILLGOODS_ID_PREFIX + id).rightPop();
        //现根据id去redis查询对应的商品
        TbSeckillGoods goods = (TbSeckillGoods)redisTemplate.boundHashOps(TbSeckillGoods.class.getSimpleName()).get(goodsId);
        //判断商品是否存在  或者数据库是存量是否<=0
        if(null==goods || goods.getStockCount()<=0){
            return new Result(false," 对不起商品已售罄，请您选择其他商品");
        }
        //生成秒杀订单 将订单保存到redis
        TbSeckillOrder order=TbSeckillOrder.builder().
                userId(userId).
                seckillId(idWorker.nextId()).sellerId(goods.getSellerId()).money(goods.getCostPrice())
                .status("0").createTime(new Date()).build();  //status 0 未支付
        redisTemplate.boundHashOps(TbSeckillOrder.class.getSimpleName()).put(userId,order);

        //秒杀商品的库存-1
        goods.setStockCount(goods.getStockCount()-1);
        //判断商品的库存是否<=0,如果<=0 将商品更新到数据库 将redis中的商品删除
        if(goods.getStockCount()<=0){
            TbSeckillGoods save = tbSeckillGoodsRepository.save(goods);
            redisTemplate.boundHashOps(TbSeckillGoods.class.getSimpleName()).delete(id);
        }else{ //否 将商品更新的到缓存
            redisTemplate.boundHashOps(TbSeckillGoods.class.getSimpleName()).put(id,goods);
        }

        return new Result(true,"秒杀成功，请您尽快支付");


    }


}
