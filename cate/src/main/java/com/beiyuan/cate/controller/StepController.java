package com.beiyuan.cate.controller;


import cate.entity.Step;
import com.beiyuan.cate.service.StepService;
import com.beiyuan.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author beiyuan
 * @since 2022-12-03
 */
@RestController
@RequestMapping("/catesharing/cate/step")
public class StepController {

    @Autowired
    StepService stepService;

    @PostMapping("add")
    //传入参数过来时可以不用传step_id
    public Result add(@RequestBody Step step){
        return Result.ok(stepService.save(step));
    }

    @PostMapping("update")
    public Result update(@RequestBody Step step){
        return Result.ok(stepService.updateById(step));
    }

    @DeleteMapping("delete/{id}")
    public Result delete(@PathVariable Integer id){
        return Result.ok(stepService.removeById(id));
    }
}

