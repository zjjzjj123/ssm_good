package com.heima.controller;

import com.heima.domain.Items;
import com.heima.domain.ItemsCustom;
import com.heima.service.ItemsService;
import com.sun.tracing.dtrace.ModuleAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemsService itemServiceImpl;

    @RequestMapping("/queryItems")
    public ModelAndView queryItems()
    {
        System.out.println("进入query");
        List<ItemsCustom> itemsList = itemServiceImpl.findItemList(null);
        ModelAndView mv = new ModelAndView();
        mv.addObject("itemsList",itemsList);
        mv.setViewName("itemsList"); //指定要跳转的网页
//        return "itemsList";
        return mv;
    }


    //id是提交的参数
    @RequestMapping("/editItems")
    public String editItems(Model model,Integer id)
    {
        model.addAttribute("id",id);
        System.out.println(id);
        ItemsCustom itemsCustom = itemServiceImpl.findItemsById(id);  //这个id是固定的
        model.addAttribute("item",itemsCustom);
        return "editItem";
    }

//    @RequestMapping("/editItemSubmit")
//    public String editItemSubmit(Model model, Integer id, @ModelAttribute(value = "itemsCustom") ItemsCustom itemsCustom)
//    {
//        //根据id进行更新
//        System.out.println("编辑提交");
//        model.addAttribute("id",id); //添加到request域中
//        System.out.println(id);
//        System.out.println(itemsCustom.toString());
//        itemServiceImpl.updateById(id,itemsCustom);
//        return "editItem";
//    }

    @RequestMapping("/editItemSubmit")
    public String editItemSubmit(Model model, Integer id, @ModelAttribute(value = "itemsCustom") ItemsCustom itemsCustom)
    {
        //根据id进行更新
        System.out.println("编辑提交");
        model.addAttribute("id",id); //添加到request域中
        System.out.println(id);
//        System.out.println(itemsCustom.toString());
        //这个时间的数据怎么弄啊
//        ItemsCustom itemsCustom1 = itemServiceImpl.findItemsById(1);  //这个时间的格式到底怎么调整呢
//        itemsCustom.setCreatetime(itemsCustom1.getCreatetime());
        System.out.println(itemsCustom.toString());
        itemServiceImpl.updateById(id,itemsCustom);
        return "editItem";
    }


}
