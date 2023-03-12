package com.beiyuan.user.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * @author: beiyuan
 * @date: 2022/12/3  10:38
 */
@RequestMapping("/catesharing/user")
@RestController
@Api("test")

public class TestController {

    @GetMapping("sayhi")
    public String sayhi(){
        System.out.println("hi ");
        return "hijjkk";
    }

    @GetMapping("getMsg")
    public String oneParam(@RequestParam String msg){
        return "ok"+msg;
    }


}
