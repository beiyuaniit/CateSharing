package com.beiyuan.cate.service;

import cate.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author beiyuan
 * @since 2022-12-03
 */
public interface CategoryService extends IService<Category> {

    void deleteByName(String name);
}
