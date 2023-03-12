package com.beiyuan.user.mapper;

import org.apache.ibatis.annotations.Param;
import user.entity.Favorite;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import user.entity.History;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author beiyuan
 * @since 2022-12-03
 */
public interface FavoriteMapper extends BaseMapper<Favorite> {

    List<Favorite> pageList(@Param("cur") Long cur, @Param("limit") Long limit);
}
