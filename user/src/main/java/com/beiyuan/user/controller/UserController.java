package com.beiyuan.user.controller;


import com.beiyuan.common.result.Result;
import com.beiyuan.user.service.UserService;
import io.swagger.models.auth.In;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import user.entity.User;
import user.vo.UserCondVo;
import user.vo.UserQueryVo;
import user.vo.UserSaveVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author beiyuan
 * @since 2022-12-03
 */
@RestController
@RequestMapping("/catesharing/user/user")

public class UserController {

    @Autowired
    UserService userService;
    private Result boolResult(boolean isSuccess){
        if(isSuccess){
            return Result.ok(null);
        }
        return Result.fail(null);
    }

    @GetMapping("list/{cur}/{limit}")

    private Result getUserList(@PathVariable Long cur,
                               @PathVariable Long limit){
        Map<String ,Object>result=new HashMap<>();
        List<UserQueryVo> list=userService.selectUserList(cur,limit);

        int total=userService.count();

        result.put("records",list);
        result.put("total",total);
        return Result.ok(result);
    }

    @PostMapping("login/{name}/{password}")
    public Result login(@PathVariable String name,@PathVariable String password){
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token=new UsernamePasswordToken(name,password);
        try{
            subject.login(token);
            return Result.ok(null).message("登陆成功");
        }catch (AuthenticationException e){
            e.printStackTrace();
            return Result.fail(null).message("登陆失败");
        }
    }

    @GetMapping("listCondition/{cur}/{limit}")
    public Result getListCondition(
            @PathVariable Long cur, @PathVariable Long limit,
           @RequestBody(required = false) UserCondVo userCondVo){

        String nickname=null;
        Integer level=null;
        System.out.println(userCondVo);
        if(userCondVo!=null){
            nickname=userCondVo.getNickname();
            level=userCondVo.getLevel();
        }
        System.out.println(nickname+" "+level);
        Map<String ,Object>map=new HashMap<>();
        List<UserQueryVo> list=userService.selectListCondition(cur,limit,nickname,level);

        int total=list.size();

        map.put("records",list);
        map.put("total",total);


        return Result.ok(map);

    }
    @PostMapping("add")
    //不需要id，自增生成
    public Result saveUser(@RequestBody UserSaveVo userSaveVo){
        User newUser=new User();
        BeanUtils.copyProperties(userSaveVo,newUser);
        return boolResult(userService.save(newUser));
    }

    @DeleteMapping("remove/{id}")
    public Result removeUser(@PathVariable Long id){
        return boolResult(userService.removeById(id));
    }

    @GetMapping("get/{id}")
    public Result getUser(@PathVariable Long id){
        return Result.ok(userService.getById(id));
    }

    @PostMapping("update")
    public Result updateUser(@RequestBody User user){
        return boolResult(userService.updateById(user));
    }

}

