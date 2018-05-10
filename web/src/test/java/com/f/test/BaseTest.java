package com.f.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by F on 2016/11/28 10:13.
 */
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)

//@Transactional
//如果是true不会改变数据库数据，如果是false会改变数据
//@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true)
public class BaseTest {
    @Test
    public void test()throws Exception{
    }


}
