package com.example.seckill.web.controller;

import com.example.seckill.common.Utils.Result;
import com.example.seckill.common.Utils.ReturnDTO;
import com.example.seckill.pojo.doo.TbSeckillGoods;
import com.example.seckill.service.SeckillGoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/")
public class seckillController {


    @Resource
    private SeckillGoodsService seckillGoodsService;

    @GetMapping("/pay")
    public String getPay(){
        return "pay";
    }

    @GetMapping("/")
    public String getIndex(){
        return "seckill-index";
    }

    @GetMapping("/item")
    public String getItem(){
        return "seckill-item";
    }

    @ResponseBody
    @RequestMapping("/seckillGoods/findAll")
    public List<TbSeckillGoods> findAll(){
        return seckillGoodsService.finaAll();
    }


    @ResponseBody
    @GetMapping("/seckillGoods/findOne/{id}")
    public TbSeckillGoods findOne(@PathVariable("id") Long id){
        return seckillGoodsService.findOne(id);
    }

    @ResponseBody
    @GetMapping("/seckillGoods/saveOrder/{id}")
    public Result saveOrder(@PathVariable("id") Long id){
        String userId="hsz";
        return seckillGoodsService.saveOrder(id,userId);
    }


}
