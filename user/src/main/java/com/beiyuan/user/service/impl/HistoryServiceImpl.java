package com.beiyuan.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import user.entity.History;
import com.beiyuan.user.mapper.HistoryMapper;
import com.beiyuan.user.service.HistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class HistoryServiceImpl extends ServiceImpl<HistoryMapper, History> implements HistoryService {

    @Autowired
    HistoryMapper historyMapper;
    @Override
    public List<History> pageList(Long cur, Long limit) {
        return historyMapper.pageList(cur,limit);
    }
}
