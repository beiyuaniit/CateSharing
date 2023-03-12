package com.beiyuan.note.controller;



import com.beiyuan.common.result.Result;
import com.beiyuan.note.service.SummaryService;
import note.entity.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author beiyuan
 * @since 2022-12-03
 */
@RestController
@RequestMapping("/catesharing/note/summary")
public class SummaryController {

    @Autowired
    SummaryService summaryService;

    @GetMapping("getSummaryById/{id}")
    public Result getSummaryById(Integer id){
        Summary summary=summaryService.getById(id);
        return Result.ok(summary);
    }

//    @GetMapping("testAdd")
//    public void testAdd(){
//        System.out.println(summaryService.addSummary());
//    }


}

