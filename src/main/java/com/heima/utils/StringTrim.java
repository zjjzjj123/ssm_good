package com.heima.utils;

import org.springframework.core.convert.converter.Converter;

public class StringTrim implements Converter<String,String> {

    @Override
    public String convert(String s) {

        try
        {
            if(s!=null)
                s =  s.trim();
            if(s=="")
                return null;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return s;
    }
}
