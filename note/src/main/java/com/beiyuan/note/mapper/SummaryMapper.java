package com.beiyuan.note.mapper;

import note.entity.Summary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author beiyuan
 * @since 2022-12-03
 */
@Repository
public interface SummaryMapper extends BaseMapper<Summary> {


    void insertReturnSummaryId(Summary summary);
}
