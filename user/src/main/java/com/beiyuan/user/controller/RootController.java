package com.beiyuan.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.beiyuan.user.common.result.Result;
import com.beiyuan.user.service.RootService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import user.entity.Root;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author beiyuan
 * @since 2022-12-03
 */
@Api("Root")
@RestController
@RequestMapping("/catesharing/user/root")
public class RootController {

    @Autowired
    RootService service;


    @PostMapping("login")
    public Result login(@RequestBody Root root) {
        String name= root.getName();
        String password=root.getPassword();
        if(!StringUtils.isEmpty(name) && !StringUtils.isEmpty(password)){
            QueryWrapper<Root> wrapper=new QueryWrapper<>();
            wrapper.eq("name",name);
            wrapper.eq("password",password);
            if(service.count(wrapper)==1){
                Map<String,Object> map=new HashMap<>();
                map.put("token","admin-token");
                return Result.ok(map);
                
            }
        }
        return Result.fail(null);
    }

}

