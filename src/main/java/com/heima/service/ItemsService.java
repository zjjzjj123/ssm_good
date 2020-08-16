package com.heima.service;

import com.heima.domain.Items;
import com.heima.domain.ItemsCustom;
import com.heima.domain.ItemsQueryVo;

import java.util.List;

public interface ItemsService {

    ItemsCustom findItemsById(Integer id);

    void insertItem(Items items);

    List<ItemsCustom> findItemList(ItemsQueryVo itemsQueryVo);

    void updateById(Integer id,ItemsCustom itemsCustom);
}
