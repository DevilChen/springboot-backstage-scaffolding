package com.backstage.scaffolding.mapper;

import com.backstage.scaffolding.model.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author DevilChen
 */
@Repository
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 根据用户ID获取商品列表
     * @param userId 用户ID
     * @return List
     */
    @Select(value = "SELECT\n" +
            "\tid,\n" +
            "\t`name`,\n" +
            "\tdescription,\n" +
            "\timage,\n" +
            "\tcount,\n" +
            "\tuser_id \n" +
            "FROM\n" +
            "\tproduct \n" +
            "WHERE\n" +
            "\tuser_id =#{userId}")
    List<Product> getProductListByUserId(String userId);

}
