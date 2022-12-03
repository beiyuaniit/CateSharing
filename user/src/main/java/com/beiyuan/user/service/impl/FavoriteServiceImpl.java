package com.beiyuan.user.service.impl;

import user.entity.Favorite;
import com.beiyuan.user.mapper.FavoriteMapper;
import com.beiyuan.user.service.FavoriteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class FavoriteServiceImpl extends ServiceImpl<FavoriteMapper, Favorite> implements FavoriteService {

}
