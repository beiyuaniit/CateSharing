package com.beiyuan.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.beiyuan.common.result.Result;
import com.beiyuan.user.service.HistoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import user.entity.History;
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
@RequestMapping("/catesharing/user/history")

public class HistoryController {

    @Autowired
    HistoryService historyService;

    @GetMapping("list/{cur}/{limit}")
    public Result getList(@PathVariable Long cur, @PathVariable Long limit){

        List<History>list=historyService.pageList(cur, limit);
        return Result.ok(list);
    }

    @GetMapping("getByUserId/{id}")
    public Result getByUserId(@PathVariable Long id){
        QueryWrapper<History>wrapper=new QueryWrapper<>();
        wrapper.eq("user_id",id);//这里还得用数据库中的列名
        return Result.ok(historyService.list(wrapper));
    }

    @DeleteMapping("remove/{id}")
    public Result removeHistory(@PathVariable Long id){
        return Result.bool(historyService.removeById(id));
    }

    @PostMapping("add")
    public Result addHistory(@RequestBody HistorySaveVo historySaveVo){
        History history=new History();
        BeanUtils.copyProperties(historySaveVo,history);
        return Result.bool(historyService.save(history));
    }
}

