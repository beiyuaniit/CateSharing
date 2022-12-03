package com.beiyuan.user.service.impl;

import user.entity.User;
import com.beiyuan.user.mapper.UserMapper;
import com.beiyuan.user.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
