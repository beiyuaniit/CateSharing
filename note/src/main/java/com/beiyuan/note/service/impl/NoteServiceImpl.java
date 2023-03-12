package com.beiyuan.note.service.impl;

import note.entity.Note;
import com.beiyuan.note.mapper.NoteMapper;
import com.beiyuan.note.service.NoteService;
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
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note> implements NoteService {


    @Autowired
    NoteMapper noteMapper;
    @Override
    public List<Note> getByUserId(Long id) {
        return noteMapper.getByUserId(id);
    }

    @Override
    public List<Integer> getNoteIds(Integer userId) {
        return noteMapper.getNoteIds(userId);
    }


}
