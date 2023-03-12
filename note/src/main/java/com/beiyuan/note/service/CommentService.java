package com.beiyuan.note.service;

import note.entity.Comment;
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
public interface CommentService extends IService<Comment> {

    List<Comment> getCommentByNoteId(Integer noteId);


    void removeByNoteId(Integer id);
}
