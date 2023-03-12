package com.beiyuan.cate.service;

import cate.entity.Step;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author beiyuan
 * @since 2022-12-03
 */
public interface StepService extends IService<Step> {

    List<Step> getByCateId(Integer id);

    void deleteByCateId(Integer id);
}
