package com.f.test;

import com.f.utils.QuartzManager;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by F on 2017/9/15.
 */
public class QuartzTest extends BaseTest {
    @Resource
    private QuartzManager quartzManager;
    @Test
    public void test()throws Exception{
        quartzManager.startJob();
        quartzManager.addJob(
                "com.f.service.MyJobService",
                "job1","group1",
                "trigger1",
                "group1","0/1 * * * * ?");
        Thread.sleep(30000);
    }
}
