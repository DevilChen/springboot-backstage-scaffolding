package com.backstage.scaffolding.service.impl;

import com.backstage.scaffolding.mapper.*;
import com.backstage.scaffolding.model.*;
import com.backstage.scaffolding.service.UserViewService;
import com.backstage.scaffolding.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DevilChen
 */
@Service
public class UserViewServiceImpl implements UserViewService {


    private final UserViewMapper userViewMapper;

    private final ShoppingCartMapper shoppingCartMapper;

    private final ProductMapper productMapper;

    private final LabelMapper labelMapper;

    private final StockMapper stockMapper;

    public UserViewServiceImpl(UserViewMapper userViewMapper, ShoppingCartMapper shoppingCartMapper, ProductMapper productMapper, LabelMapper labelMapper, StockMapper stockMapper) {
        this.userViewMapper = userViewMapper;
        this.shoppingCartMapper = shoppingCartMapper;
        this.productMapper = productMapper;
        this.labelMapper = labelMapper;
        this.stockMapper = stockMapper;
    }

    @Override
    public UserVO getUserShoppingCartById(String id) {

        UserVO userVO = userViewMapper.getUserShoppingCartById(id);
        ShoppingCart shoppingCart = shoppingCartMapper.getShoppingCartByUserId(id);
        List<Product> productList = productMapper.getProductListByUserId(id);
        for (Product product : productList) {
            Label label = labelMapper.getLabelByProductId(String.valueOf(product.getId()));
            product.setLabel(label);
            Stock stock = stockMapper.getStockByProductId(String.valueOf(product.getId()));
            product.setStock(stock);
        }
        shoppingCart.setProductList(productList);
        userVO.setShoppingCart(shoppingCart);
        return userVO;
    }
}
