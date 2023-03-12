package com.beiyuan.note.service;

import note.entity.Note;
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
public interface NoteService extends IService<Note> {

    List<Note> getByUserId(Long id);

    List<Integer> getNoteIds(Integer userId);
}
