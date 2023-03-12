package com.beiyuan.user.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import user.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import user.vo.UserQueryVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author beiyuan
 * @since 2022-12-03
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    List<UserQueryVo> selectUserList(@Param("cur") Long cur, @Param("limit") Long limit);

    List<UserQueryVo> selectListCondition(@Param("cur")Long cur, @Param("limit") Long limit,
                                          @Param("nickname") String nickname, @Param("level") Integer level);

    User getUserByName(String name);
}
