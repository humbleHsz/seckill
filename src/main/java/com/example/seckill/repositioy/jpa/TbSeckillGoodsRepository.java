package com.example.seckill.repositioy.jpa;

import com.example.seckill.pojo.doo.TbSeckillGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TbSeckillGoodsRepository extends JpaRepository<TbSeckillGoods,Integer> {

    @Query(value = "select  * from  tb_seckill_goods",nativeQuery = true)
    List<TbSeckillGoods> findAllGoods();
}
