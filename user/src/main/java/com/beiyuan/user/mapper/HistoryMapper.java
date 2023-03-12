package com.beiyuan.user.mapper;

import org.apache.ibatis.annotations.Param;
import user.entity.History;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author beiyuan
 * @since 2022-12-03
 */
public interface HistoryMapper extends BaseMapper<History> {

    List<History> pageList(@Param("cur") Long cur, @Param("limit") Long limit);
}
