package io.lfr.developer.springquartz.config;

import io.lfr.developer.springquartz.jobs.JobA;
import io.lfr.developer.springquartz.jobs.JobB;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
public class QuartzConfig {

    @Bean(name = "beanJobDetailA")
    public JobDetailFactoryBean jobDetailJobA() {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(JobA.class);
        jobDetailFactoryBean.setDescription("Invoke JobA");
        jobDetailFactoryBean.setDurability(true);
        return jobDetailFactoryBean;
    }

    @Bean(name = "beanJobDetailB")
    public JobDetailFactoryBean jobDetailJobB() {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(JobB.class);
        jobDetailFactoryBean.setDescription("Invoke JobB");
        jobDetailFactoryBean.setDurability(true);
        return jobDetailFactoryBean;
    }

    @Bean(name = "beanTriggerJobA")
    public SimpleTriggerFactoryBean triggerJobA(@Qualifier("beanJobDetailA") JobDetail jobA) {
        SimpleTriggerFactoryBean triggerFactoryBean = new SimpleTriggerFactoryBean();
        triggerFactoryBean.setJobDetail(jobA);
        triggerFactoryBean.setRepeatInterval(10000);
        triggerFactoryBean.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
        triggerFactoryBean.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_RESCHEDULE_NEXT_WITH_REMAINING_COUNT);
        return triggerFactoryBean;
    }

    @Bean(name = "beanTriggerJobB")
    public SimpleTriggerFactoryBean triggerJobB(@Qualifier("beanJobDetailB") JobDetail jobB) {
        SimpleTriggerFactoryBean triggerFactoryBean = new SimpleTriggerFactoryBean();
        triggerFactoryBean.setJobDetail(jobB);
        triggerFactoryBean.setRepeatInterval(1000);
        triggerFactoryBean.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
        triggerFactoryBean.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_RESCHEDULE_NEXT_WITH_REMAINING_COUNT);
        return triggerFactoryBean;
    }

}
