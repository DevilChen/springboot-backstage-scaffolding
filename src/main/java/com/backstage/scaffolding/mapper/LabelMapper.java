package com.backstage.scaffolding.mapper;

import com.backstage.scaffolding.model.Label;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author DevilChen
 */
@Repository
public interface LabelMapper extends BaseMapper<Label> {

    /**
     * 根据商品ID获取标签
     * @param productId 商品ID
     * @return Object
     */
    @Select(value = "SELECT\n" +
            "\tid,\n" +
            "\t`name`,\n" +
            "\tproduct_id \n" +
            "FROM\n" +
            "\tlabel \n" +
            "WHERE\n" +
            "\tproduct_id =#{productId}")
    Label getLabelByProductId(String productId);
}
