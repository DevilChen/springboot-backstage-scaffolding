package com.backstage.scaffolding.mapper;

import com.backstage.scaffolding.model.Stock;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


/**
 * @author DevilChen
 */
@Repository
public interface StockMapper extends BaseMapper<Stock> {

    /**
     * 根据商品ID获取库存
     *
     * @param productId 商品ID
     * @return Object
     */
    @Select(value = "SELECT\n" +
            "\tid,\n" +
            "\tcount,\n" +
            "\tproduct_id \n" +
            "FROM\n" +
            "\tstock \n" +
            "WHERE\n" +
            "\tproduct_id =#{productId}")
    Stock getStockByProductId(String productId);
}
