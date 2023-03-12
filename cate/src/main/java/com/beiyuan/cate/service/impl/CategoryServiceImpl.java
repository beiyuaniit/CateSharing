package com.beiyuan.cate.service.impl;

import cate.entity.Category;
import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.A;
import com.beiyuan.cate.mapper.CategoryMapper;
import com.beiyuan.cate.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author beiyuan
 * @since 2022-12-03
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public void deleteByName(String name) {
        categoryMapper.deleteByName(name);
    }
}
