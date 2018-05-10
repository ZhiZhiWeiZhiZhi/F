package com.f.service.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by F on 2017/9/11.
 */
public class MyJobService implements Job {
    private static final Logger logger= LoggerFactory.getLogger(MyJobService.class);
//    @Autowired
//    NumTestMapper numTestMapper;
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
//            logger.info("查询结果："+numTestMapper.selectAll().size());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
