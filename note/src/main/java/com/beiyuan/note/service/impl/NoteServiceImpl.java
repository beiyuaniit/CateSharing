package com.beiyuan.note.service.impl;

import note.entity.Note;
import com.beiyuan.note.mapper.NoteMapper;
import com.beiyuan.note.service.NoteService;
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
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note> implements NoteService {

}
