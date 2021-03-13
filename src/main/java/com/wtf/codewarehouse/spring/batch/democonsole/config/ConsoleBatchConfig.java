package com.wtf.codewarehouse.spring.batch.democonsole.config;

import com.wtf.codewarehouse.spring.batch.democonsole.listener.ConsoleJobEndListener;
import com.wtf.codewarehouse.spring.batch.democonsole.step.ConsoleWriter;
import com.wtf.codewarehouse.spring.batch.democonsole.step.ConvertProcessor;
import com.wtf.codewarehouse.spring.batch.democonsole.step.StringReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: WTF
 * @Date: 2021/2/5 11:10
 */
@Configuration
@EnableBatchProcessing
public class ConsoleBatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job consoleJob(Step consoleStep, JobExecutionListener consoleListener) {
        String funcName = Thread.currentThread().getStackTrace()[1].getMethodName();
        return jobBuilderFactory
                .get(funcName)
                .listener(consoleListener)
                .flow(consoleStep)
                .end().build();
    }

    @Bean
    public Step consoleStep(ItemReader stringReader, ItemProcessor convertProcessor,
                            ItemWriter consoleWriter, JobExecutionListener consoleJobEndListener){
        String funcName = Thread.currentThread().getStackTrace()[1].getMethodName();
        return stepBuilderFactory.get(funcName)
                .listener(consoleJobEndListener)
                .<String,String>chunk(3)
                .reader(stringReader)
                .processor(convertProcessor)
                .writer(consoleWriter)
                .build();
    }

    @Bean
    public ItemReader<String> stringReader(){
        return new StringReader();
    }

    @Bean
    public ItemWriter<String> consoleWriter(){
        return new ConsoleWriter();
    }

    @Bean
    public ItemProcessor<String, String> convertProcessor(){
        return new ConvertProcessor();
    }

    @Bean
    public JobExecutionListener consoleListener(){
        return new ConsoleJobEndListener();
    }

    public static void main(String[] args) {
        Integer a=null;
        ConsoleBatchConfig.b(a);
    }

    static void b(int c){
        System.out.println(c);
    }

}
