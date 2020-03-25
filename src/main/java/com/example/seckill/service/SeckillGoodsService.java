package com.example.seckill.service;

import com.example.seckill.pojo.doo.TbSeckillGoods;
import com.example.seckill.repositioy.jpa.TbSeckillGoodsRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SeckillGoodsService {

    @Resource
    private TbSeckillGoodsRepository tbSeckillGoodsRepository;

    public List<TbSeckillGoods> finaAll(){
        return tbSeckillGoodsRepository.findAllGoods();
    }
}
