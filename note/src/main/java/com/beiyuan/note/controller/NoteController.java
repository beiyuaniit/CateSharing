package com.beiyuan.note.controller;

import com.beiyuan.common.result.Result;
import com.beiyuan.note.common.openfeign.CateFegin;
import com.beiyuan.note.service.CommentService;
import com.beiyuan.note.service.NoteService;
import com.beiyuan.note.service.SummaryService;
import io.swagger.models.auth.In;
import note.entity.Comment;
import note.entity.Note;
import note.entity.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import user.entity.User;


import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author beiyuan
 * @since 2022-12-03
 */
@RestController
@RequestMapping("/catesharing/note/note")
public class NoteController {

    @Autowired
    NoteService noteService;

    @Autowired
    SummaryService summaryService;

    @Autowired
    CommentService commentService;

    @Autowired
    CateFegin cateFegin;
    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    StringRedisTemplate redisTemplate;

    @PostConstruct
    public void viewCountInit(){
        if(!redisTemplate.hasKey("viewCount")){
            redisTemplate.opsForValue().set("viewCount","0");
        }
    }

//    @GetMapping("testRedisInc")
//    public Result testRedisInc(){
//        redisTemplate.opsForValue().increment("viewCount",1);
//        return Result.ok(null);
//    }
//
//    @GetMapping("testRedis")
//    public Result testRedis(){
//        redisTemplate.opsForValue().set("firstKey","first value");
//
//        String vaule=redisTemplate.opsForValue().get("firstKey");
//        return Result.ok(vaule);
//    }

    @GetMapping("viewCount")
    //返回请求访问数（网站访问量，并不是访问量，访问量还要过滤
    public Result returnViewCount(){
        return Result.ok(redisTemplate.opsForValue().get("viewCount"));
    }

    @GetMapping("getById/{id}")
    public Result getNoteById(@PathVariable Integer id){

        //请求数加一
        redisTemplate.opsForValue().increment("viewCount",1);


        Note note=noteService.getById(id);
        if(note==null){
            return Result.ok(null);
        }
        Integer summary_id=note.getSummaryId();

        Summary summary=summaryService.getById(summary_id);
        note.getOtherData().put("summary",summary);

        List<Comment> list=commentService.getCommentByNoteId(id);
        note.getOtherData().put("comment",list);

        Result result= cateFegin.get(note.getCateId());
        note.getOtherData().put("cate",result.getData());
        return Result.ok(note);
    }

    @PostMapping("add/{userId}/{cateId}")
    public Result addNote(@PathVariable Integer userId, @PathVariable Integer cateId){
        //先创建汇总
        int summaryId=summaryService.addSummary();
        Note note=new Note();
        note.setUserId(userId);
        note.setCateId(cateId);
        note.setSummaryId(summaryId);
        boolean res=noteService.save(note);
        return Result.ok(res);
    }


    @DeleteMapping("deleteById/{id}")
    public void deleteNoteById(@PathVariable Integer id){
        //先删除评论
        commentService.removeByNoteId(id);
        //再笔记
        Note note=noteService.getById(id);
        noteService.removeById(id);
        if(note!=null){
            //再最后汇总
            summaryService.removeById(note.getSummaryId());
        }
    }
    @GetMapping("getByUserId/{id}")
    public Result getByUserId(@PathVariable Long id){
        List<Note>list=noteService.getByUserId(id);

        for(Note note:list){
            Integer summary_id=note.getSummaryId();
            Summary summary=summaryService.getById(summary_id);
            note.getOtherData().put("summary",summary);
            List<Comment> comments=commentService.getCommentByNoteId(note.getNoteId());
            note.getOtherData().put("comment",comments);
        }

        return Result.ok(list);
    }

    //删除一个用户下的所有笔记
    @DeleteMapping("deleteByUserId/{id}")
    public Result deleteByUserId(@PathVariable Integer id){
        List<Integer>noteIdList=noteService.getNoteIds(id);

        for (Integer noteId : noteIdList){
            deleteNoteById(noteId);
        }
        return Result.ok(null);
    }
}

