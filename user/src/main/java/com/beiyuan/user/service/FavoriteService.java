package com.beiyuan.user.service;

import user.entity.Favorite;
import com.baomidou.mybatisplus.extension.service.IService;
import user.entity.History;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author beiyuan
 * @since 2022-12-03
 */
public interface FavoriteService extends IService<Favorite> {

    List<Favorite> pageList(Long cur, Long limit);
}
