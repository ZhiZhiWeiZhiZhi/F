package com.f.service.task;

import com.f.utils.QuartzManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by F on 2017/9/14.
 */

public class StartTimedTask {
    @Autowired
    private QuartzManager quartzManager;
//    @Autowired
//    private TimedTaskDao timedTaskMapper;
    //项目启动时启动所有定时任务
    public void   startTimedTask() throws Exception {
//        List<TimedTask> list = timedTaskMapper.findAll();
//        if(list!=null && list.size()>0) {
//            quartzManage.startJob();
//        }
//        for(TimedTask timedTask:list){
//            try {
//                quartzManage.addJob(timedTask.getClassName(),
//                        timedTask.getJobName(),
//                        timedTask.getJobGroup(),
//                        timedTask.getTriggerName(),
//                        timedTask.getTriggerGroup(),
//                        timedTask.getCron());
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
    }
}
