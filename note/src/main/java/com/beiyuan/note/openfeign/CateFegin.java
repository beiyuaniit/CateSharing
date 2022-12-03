package com.beiyuan.note.openfeign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: beiyuan
 * @date: 2022/12/3  14:32
 */
@FeignClient(value = "cate-server",path ="/catesharing/cate")
public interface CateFegin {
}
