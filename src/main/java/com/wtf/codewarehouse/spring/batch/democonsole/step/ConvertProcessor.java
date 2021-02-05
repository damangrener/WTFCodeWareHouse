package com.wtf.codewarehouse.spring.batch.democonsole.step;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: WTF
 * @Date: 2021/2/5 11:11
 */
@Slf4j
public class ConvertProcessor implements ItemProcessor<String, String> {


    @Override
    public String process(String s) throws Exception {
        String dataProcessed = s.toUpperCase();
        log.debug("ConvertProcessor process data " + s + "-->" + dataProcessed);
        return dataProcessed;
    }
}
