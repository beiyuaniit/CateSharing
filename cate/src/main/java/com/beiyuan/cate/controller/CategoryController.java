package com.beiyuan.cate.controller;


import cate.entity.Category;
import cate.vo.CategoryVo;
import com.beiyuan.cate.service.CategoryService;
import com.beiyuan.common.result.Result;
import org.springframework.beans.BeanUtils;
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
@RequestMapping("/catesharing/cate/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("add")
    public Result add(@RequestBody CategoryVo categoryVo){
        Category category=new Category();
        BeanUtils.copyProperties(categoryVo,category);
        return Result.bool(categoryService.save(category));
    }

    @DeleteMapping("delete/{id}")
    public Result delete(@PathVariable Integer id){
        return Result.bool(categoryService.removeById(id));
    }

    @DeleteMapping("deleteByName/{name}")
    //名字唯一
    public Result deleteByName(@PathVariable String name){
        categoryService.deleteByName(name);
        return Result.ok(null);
    }

    @PostMapping("update")
    public Result update(@RequestBody Category category){

        categoryService.updateById(category);
        return Result.ok(null);
    }

}

