package com.beiyuan.cate.openfegin;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: beiyuan
 * @date: 2022/12/3  14:28
 */
@FeignClient(value = "user-server",path = "/catesharing/user")
public interface UserFegin {

}
