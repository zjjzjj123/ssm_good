package com.heima.service.impl;

import com.heima.dao.ItemsCustomMapper;
import com.heima.dao.ItemsMapper;
import com.heima.domain.Items;
import com.heima.domain.ItemsCustom;
import com.heima.domain.ItemsQueryVo;
import com.heima.service.ItemsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemServiceImpl implements ItemsService {
    //注入bean文件
    @Autowired
    ItemsMapper itemsMapper;

    @Autowired
    ItemsCustomMapper itemsCustomMapper; //


    @Override
    public ItemsCustom findItemsById(Integer id) {

        System.out.println("业务层:::查询数据");
        Items items =  itemsMapper.selectByPrimaryKey(id) ;
        ItemsCustom itemsCustom = new ItemsCustom();
        BeanUtils.copyProperties(items,itemsCustom);
        return itemsCustom;
    }

    @Override
    public void insertItem(Items items) {
        itemsMapper.insert(items);
    }

    @Override
    public List<ItemsCustom> findItemList(ItemsQueryVo itemsQueryVo) {
        System.out.println("服务层：");
        return itemsCustomMapper.findItemList(itemsQueryVo);
    }

    @Override
    public void updateById(Integer id, ItemsCustom itemsCustom) {

        if(id == null)
        {
            return;
        }
        itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);  //根据这个里面的额key更新
    }
}
