package com.beiyuan.note.service.impl;

import note.entity.Comment;
import com.beiyuan.note.mapper.CommentMapper;
import com.beiyuan.note.service.CommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
