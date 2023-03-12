package com.beiyuan.note.service.impl;

import com.beiyuan.note.mapper.SummaryMapper;
import note.entity.Comment;
import com.beiyuan.note.mapper.CommentMapper;
import com.beiyuan.note.service.CommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {


    @Autowired
    CommentMapper commentMapper;
    @Override
    public List<Comment> getCommentByNoteId(Integer noteId) {

        return  commentMapper.getCommentByNoteId(noteId);
    }

    @Override
    public void removeByNoteId(Integer id) {
        commentMapper.removeByNoteId(id);
    }

}
