package com.beiyuan.cate.controller;


import cate.entity.Cate;
import cate.entity.Category;
import cate.entity.Step;
import com.beiyuan.cate.service.CateService;
import com.beiyuan.cate.service.CategoryService;
import com.beiyuan.cate.service.StepService;
import com.beiyuan.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/catesharing/cate/cate")
public class CateController {

    @Autowired
    CateService cateService;

    @Autowired
    StepService stepService;

    @Autowired
    CategoryService categoryService;


    @GetMapping("get/{id}")
    public Result get(@PathVariable(value = "id") Integer id){
        Cate cate=cateService.getById(id);
        List<Step> stepList=stepService.getByCateId(cate.getCateId());
        Category category=categoryService.getById(cate.getCategoryId());

        cate.getOtherData().put("steps", stepList);
        cate.getOtherData().put("category", category);

        return Result.ok(cate);
    }

    @DeleteMapping("delete/{id}")
    public Result delete(@PathVariable Integer id){
        //删除美食
        cateService.removeById(id);
        //删除步骤
        stepService.deleteByCateId(id);
        return Result.ok(null);
    }

    @PostMapping("update")
    public Result update(@RequestBody Cate cate){
        return Result.bool(cateService.updateById(cate));
    }

    @PostMapping("add")
    public Result add(@RequestBody Cate cate){
        return Result.bool(cateService.save(cate));
    }
}

