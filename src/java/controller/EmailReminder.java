/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Hp
 */
import model.Job1;
import org.apache.log4j.BasicConfigurator;
import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class EmailReminder {

    public void SendEmailReminder(String schedule) {
        BasicConfigurator.configure();
        try {
            JobDetail job1 = JobBuilder.newJob(Job1.class)
                    .withIdentity("job1", "group1").build();

            Trigger trigger1 = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger1", "group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule(schedule))
                    .build();

            Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
            scheduler1.start();
            scheduler1.scheduleJob(job1, trigger1);

            Thread.sleep(100000);

            scheduler1.shutdown();

        } catch (InterruptedException | SchedulerException e) {
        }
    }

    public static void main(String[] args) {
        EmailReminder e = new EmailReminder();
        e.SendEmailReminder("* 6 * * * ?");
    }

}
