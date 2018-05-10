package com.f.test;

import com.f.bean.DataTypeTest;
import com.f.service.DataTypeTestService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by F on 2017/9/15.
 */
public class ServiceTest extends BaseTest{
    @Autowired
    DataTypeTestService dataTypeTestService;

    @org.junit.Test
    public void test()throws Exception{

        DataTypeTest dataTypeTest = new DataTypeTest();
        dataTypeTest.setDataTypeDatetime(new Date());
        dataTypeTest.setDataTypeDecimal(new BigDecimal(0));
        dataTypeTest.setDataTypeTimestamp(new Date());
        dataTypeTest.setDataTypeVarchar("test");
        System.out.println(dataTypeTestService.insert( dataTypeTest));
        //Test.setId(1);
//        System.out.println(testService.insertSelective(Test));
//        System.out.println(testService.select(Test));
//        Example example= new Example(Test.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("id","1");
//        System.out.println(testService.selectByExample(example));
//        System.out.println(testService.selectByPrimaryKey(Test));
//        System.out.println(testService.selectOne(Test));
//        System.out.println(testService.selectAll().size());

//        PageHelper.startPage(3, 2);
//        List<Test> list= testService.select(Test);
//        PageInfo<Test> pageInfo = new PageInfo<Test>(list);
//        System.out.println("总条数："+pageInfo.getTotal());
    }
}
