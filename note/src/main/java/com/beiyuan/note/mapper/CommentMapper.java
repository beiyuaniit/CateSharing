package com.beiyuan.note.mapper;

import note.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author beiyuan
 * @since 2022-12-03
 */
@Repository
public interface CommentMapper extends BaseMapper<Comment> {

    List<Comment> getCommentByNoteId(Integer noteId);


    void removeByNoteId(Integer id);
}
