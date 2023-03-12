package com.beiyuan.user.service;

import user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import user.vo.UserQueryVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author beiyuan
 * @since 2022-12-03
 */
public interface UserService extends IService<User> {

    List<UserQueryVo> selectUserList(Long cur,Long limit);


    List<UserQueryVo> selectListCondition(Long cur, Long limit, String nickname, Integer level);

    User getByName(String name);
}
