package com.heima.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


//自定义转换器
public class StringToDate implements Converter<String, Date> {

    @Override
    public Date convert(String s) {

        try {

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            Date date = df.parse(s);
            return date;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



        return null;
    }
}
