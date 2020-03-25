package com.example.seckill.repositioy.jpa;

import com.example.seckill.pojo.doo.TbSeckillGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TbSeckillGoodsRepository extends JpaRepository<TbSeckillGoods,Integer> {

    @Query(value = "select  * from  tb_seckill_goods",nativeQuery = true)
    List<TbSeckillGoods> findAllGoods();

    @Query(value = "SELECT * FROM tb_seckill_goods good " +
            "WHERE `status`=1 and start_time BETWEEN ?1 and ?2 and stock_count>0",nativeQuery = true)
     List<TbSeckillGoods> findGoodsToRedis(String startTime,String endTime);
}
