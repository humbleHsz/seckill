package com.example.seckill.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.seckill.pojo.doo.TbSeckillGoods;
import com.example.seckill.service.SeckillGoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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


}
