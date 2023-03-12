package com.beiyuan.user.service;

import user.entity.History;
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
public interface HistoryService extends IService<History> {

    List<History> pageList(Long cur, Long limit);
}
