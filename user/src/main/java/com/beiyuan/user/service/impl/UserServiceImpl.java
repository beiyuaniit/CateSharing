
package com.beiyuan.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import user.entity.User;
import com.beiyuan.user.mapper.UserMapper;
import com.beiyuan.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import user.vo.UserQueryVo;

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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public List<UserQueryVo> selectUserList(Long cur,Long limit) {
        return userMapper.selectUserList(cur,limit);
    }

    @Override
    public List<UserQueryVo> selectListCondition(Long cur, Long limit, String nickname, Integer level) {
        return userMapper.selectListCondition(cur,limit,nickname,level);
    }

    @Override
    public User getByName(String name) {
        return userMapper.getUserByName(name);
    }

}
