package com.beiyuan.cate.mapper;

import cate.entity.Category;
import com.alibaba.nacos.shaded.io.grpc.stub.annotations.RpcMethod;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author beiyuan
 * @since 2022-12-03
 */
@Repository
public interface CategoryMapper extends BaseMapper<Category> {

    void deleteByName(String name);
}
