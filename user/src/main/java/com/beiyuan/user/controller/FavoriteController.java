package com.beiyuan.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.beiyuan.common.result.Result;
import com.beiyuan.user.service.FavoriteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import user.entity.Favorite;
import user.entity.History;
import user.vo.FavoriteSaveVo;
import user.vo.HistorySaveVo;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author beiyuan
 * @since 2022-12-03
 */
@RestController
@RequestMapping("/catesharing/user/favorite")

public class FavoriteController {
    @Autowired
    FavoriteService favoriteService;
    @GetMapping("list/{cur}/{limit}")
    public Result getList(@PathVariable Long cur, @PathVariable Long limit){

        List<Favorite> list=favoriteService.pageList(cur, limit);
        return Result.ok(list);
    }

    @GetMapping("getByUserId/{id}")
    public Result getByUserId(@PathVariable Long id){
        QueryWrapper<Favorite> wrapper=new QueryWrapper<>();
        wrapper.eq("user_id",id);//这里还得用数据库中的列名
        return Result.ok(favoriteService.list(wrapper));
    }

    @DeleteMapping("remove/{id}")
    public Result removeHistory(@PathVariable Long id){
        return Result.bool(favoriteService.removeById(id));
    }

    @PostMapping("add")
    public Result addHistory(@RequestBody FavoriteSaveVo favoriteSaveVo){
        Favorite favorite=new Favorite();
        BeanUtils.copyProperties(favoriteSaveVo,favorite);
        return Result.bool(favoriteService.save(favorite));
    }
}

