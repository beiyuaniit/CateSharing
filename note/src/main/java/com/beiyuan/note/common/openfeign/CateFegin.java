package com.beiyuan.note.common.openfeign;

import com.beiyuan.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: beiyuan
 * @date: 2022/12/3  14:32
 */
@FeignClient(value = "cate-server",path ="/catesharing/cate")
public interface CateFegin {
    @GetMapping("/cate/get/{id}")
    public Result get(@PathVariable(value = "id") Integer id);
}
