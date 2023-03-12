package com.beiyuan.note.common.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: beiyuan
 * @date: 2022/12/3  10:36
 */
@FeignClient(value = "user-server",path = "/catesharing/user")
public interface UserFeign {
    @GetMapping("sayhi")
    public String sayhi();

    @GetMapping("getMsg")
    public String oneParam(@RequestParam String msg);
}
