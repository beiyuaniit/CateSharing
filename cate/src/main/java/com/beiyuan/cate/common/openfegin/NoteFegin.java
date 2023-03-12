package com.beiyuan.cate.common.openfegin;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: beiyuan
 * @date: 2022/12/3  14:31
 */
@FeignClient(value = "note-server",path = "/catesharing/note")
public interface NoteFegin {
}
