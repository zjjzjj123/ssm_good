package com.heima.dao;

import com.heima.domain.ItemsCustom;
import com.heima.domain.ItemsQueryVo;

import java.util.List;

public interface ItemsCustomMapper {

    //查询商品列表
    List<ItemsCustom> findItemList(ItemsQueryVo itemsQueryVo);
}
