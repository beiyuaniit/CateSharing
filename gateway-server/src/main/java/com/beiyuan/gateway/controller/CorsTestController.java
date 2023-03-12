package com.beiyuan.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: beiyuan
 * @date: 2022/12/14  18:32
 */
@RestController
public class CorsTestController {

    @GetMapping("test")
    public String test(){

        return "test ok";
    }
}
