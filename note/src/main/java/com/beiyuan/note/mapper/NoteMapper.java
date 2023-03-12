package com.beiyuan.note.mapper;

import note.entity.Note;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author beiyuan
 * @since 2022-12-03
 */
public interface NoteMapper extends BaseMapper<Note> {

    List<Note> getByUserId(@Param("id") Long id);

    List<Integer> getNoteIds(@Param("userId") Integer userId);
}
