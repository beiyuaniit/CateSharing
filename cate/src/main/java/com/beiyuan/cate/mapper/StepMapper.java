package com.beiyuan.cate.mapper;

import cate.entity.Step;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author beiyuan
 * @since 2022-12-03
 */
@Repository
public interface StepMapper extends BaseMapper<Step> {

    //一个参数好像也不用加@Param,多个才要吧
    List<Step> getByCateId(Integer id);

    void deleteByCateId(Integer id);
}
