package com.backstage.scaffolding.mapper;

import com.backstage.scaffolding.model.ShoppingCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author DevilChen
 */
@Repository
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {

    /**
     * 根据用户ID获取购物车
     * @param userId 用户ID
     * @return Object
     */
    @Select(value = "SELECT\n" +
            "\tid,\n" +
            "\tuser_id \n" +
            "FROM\n" +
            "\tshopping_cart \n" +
            "WHERE\n" +
            "\tuser_id =#{userId}")
    ShoppingCart getShoppingCartByUserId(String userId);
}
