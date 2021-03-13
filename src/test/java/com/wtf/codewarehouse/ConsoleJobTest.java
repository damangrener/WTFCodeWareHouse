package com.wtf.codewarehouse;

import com.alibaba.fastjson.JSON;
import com.wtf.codewarehouse.spring.batch.democonsole.config.ConsoleBatchConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: WTF
 * @Date: 2021/2/5 11:43
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CodeWarehouseApplication.class, ConsoleBatchConfig.class})
public class ConsoleJobTest {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job consoleJob;

    public void test() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
        JobExecution run = jobLauncher.run(consoleJob, jobParameters);
        ExitStatus exitStatus=run.getExitStatus();
        log.debug(JSON.toJSONString(exitStatus));
    }

}
