package com.beiyuan.cate.service.impl;

import cate.entity.Step;
import com.beiyuan.cate.mapper.StepMapper;
import com.beiyuan.cate.service.StepService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author beiyuan
 * @since 2022-12-03
 */
@Service
public class StepServiceImpl extends ServiceImpl<StepMapper, Step> implements StepService {

    @Autowired
    StepMapper stepMapper;
    @Override
    public List<Step> getByCateId( Integer id) {
        return stepMapper.getByCateId(id);
    }

    @Override
    public void deleteByCateId(Integer id) {
        stepMapper.deleteByCateId(id);
    }
}
