package com.example.seckill.common.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Result implements Serializable {

    private boolean success;
    private String message;
}
