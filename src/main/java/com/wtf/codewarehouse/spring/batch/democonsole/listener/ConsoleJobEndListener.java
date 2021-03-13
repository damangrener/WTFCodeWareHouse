package com.wtf.codewarehouse.spring.batch.democonsole.listener;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

/**
 * @Author: WTF
 * @Date: 2021/2/5 11:10
 */
@Slf4j
public class ConsoleJobEndListener extends JobExecutionListenerSupport {

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info(JSON.toJSONString(jobExecution));
        if(jobExecution.getStatus()== BatchStatus.COMPLETED){
            log.debug("console batch job complete");
            System.err.println("console batch job complete");
        }
    }
}
