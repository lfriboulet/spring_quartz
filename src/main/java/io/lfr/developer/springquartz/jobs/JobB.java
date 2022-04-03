package io.lfr.developer.springquartz.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JobB implements Job {

    private final Logger LOG = LoggerFactory.getLogger(JobB.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOG.warn("Je suis le job B ........");
    }
}
