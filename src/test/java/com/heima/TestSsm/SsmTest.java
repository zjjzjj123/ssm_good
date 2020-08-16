package com.heima.TestSsm;


import com.heima.dao.ItemsMapper;
import com.heima.domain.Items;
import com.heima.service.ItemsService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SsmTest {
//    @Test
//    public void Mbg() throws Exception
//    {
//
//        System.out.println("start");
//        List<String> warnings = new ArrayList<String>();
//        boolean overwrite = true;
//        File configFile = new File("E:\\java\\Mybatis\\ssm_good\\src\\main\\resources\\mbg.xml");
//        ConfigurationParser cp = new ConfigurationParser(warnings);
//        Configuration config = cp.parseConfiguration(configFile);
//        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
//        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
//        myBatisGenerator.generate(null);
//        System.out.println("end ");
//    }

    @Test
    public void findAll() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        ItemsMapper itemsMapper = session.getMapper(ItemsMapper.class);

        Items items = itemsMapper.selectByPrimaryKey(2);
        System.out.println(items.toString());
    }

    @Test
    public void testSpring()
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ItemsService itemsService = ac.getBean("itemServiceImpl",ItemsService.class);
        Items it = itemsService.findItemsById(2);
        System.out.println(it);

        //设置的可能是自动提交
        System.out.println("over");
    }
}
