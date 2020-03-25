package com.example.seckill;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;

@SpringBootTest
class SeckillApplicationTests {


    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    void contextLoads() throws IOException {

        while (true){
            System.in.read();
        }
    }

}
