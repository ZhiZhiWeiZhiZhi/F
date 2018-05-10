package com.f.utils;

import org.quartz.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by f on 2017/9/11.
 */
@Service
public class QuartzManager {
    @Resource
    private Scheduler scheduler ;

    public  void addJob(String className,String jobName,String jobGroup,String triggerName,String triggerGroup,String cron)throws Exception{

        JobDetail job2 = newJob((Class<? extends Job>) Class.forName(className))
                .withIdentity(jobName, jobGroup)
                .build();
        Trigger trigger2 = newTrigger()
                .withIdentity(triggerName, triggerGroup)
                .withSchedule(cronSchedule(cron))
                .build();
        scheduler.scheduleJob(job2, trigger2);
    }
    public  void deleteJob(String jobName,String jobGroup)throws Exception{
        scheduler.deleteJob( new JobKey(jobName,jobGroup));

    }
    public  void rescheduleJob(String triggerName,String triggerGroup,String cron)throws Exception{
        TriggerKey triggerKey = new TriggerKey(triggerName,triggerGroup);
        Trigger trigger3 = newTrigger()
                .withIdentity(triggerName, triggerGroup)
                .withSchedule(cronSchedule(cron))
                .build();
        scheduler.rescheduleJob(triggerKey,trigger3);
    }
    public  void startJob()throws Exception{
        scheduler.start();
    }
    public  void shutdownJob(boolean waitForJobsToComplete)throws Exception{
        scheduler.shutdown(waitForJobsToComplete);
    }
}
