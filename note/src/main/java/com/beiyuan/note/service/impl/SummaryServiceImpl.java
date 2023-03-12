package com.beiyuan.note.service.impl;

import note.entity.Summary;
import com.beiyuan.note.mapper.SummaryMapper;
import com.beiyuan.note.service.SummaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SummaryServiceImpl extends ServiceImpl<SummaryMapper, Summary> implements SummaryService {


    @Autowired
    SummaryMapper summaryMapper;
    @Override
    public int addSummary() {
        Summary summary = new Summary();
        summaryMapper.insertReturnSummaryId(summary);
        return summary.getSummaryId();
    }
}
