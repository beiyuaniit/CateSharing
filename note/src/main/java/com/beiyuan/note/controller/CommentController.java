package com.beiyuan.note.controller;



import com.beiyuan.common.result.Result;
import com.beiyuan.note.service.CommentService;
import note.entity.Comment;
import note.vo.CommentSaveVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author beiyuan
 * @since 2022-12-03
 */
@RestController
@RequestMapping("/catesharing/note/comment")
public class CommentController {


    @Autowired
    CommentService commentService;

//    @PostMapping("updateById")   //评论只能删除吧
//    public Result updateById(Integer id,String comment){
//        commentService.updateByCommentId(id,comment);
//
//        return Result.ok(null);
//    }

    @DeleteMapping("delete/{id}")
    public Result deleteById(@PathVariable Integer id){

        return Result.ok(commentService.removeById(id));
    }

    @PostMapping("add")
    public Result addComment(@RequestBody CommentSaveVo commentSaveVo){
        Comment comment=new Comment();
        BeanUtils.copyProperties(commentSaveVo,comment);
        return Result.bool(commentService.save(comment));
    }
}

