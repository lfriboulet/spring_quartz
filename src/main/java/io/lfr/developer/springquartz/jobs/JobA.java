package io.lfr.developer.springquartz.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JobA implements Job {

    private final Logger LOG = LoggerFactory.getLogger(JobA.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOG.info("Je suis le JOB A");
    }
}
