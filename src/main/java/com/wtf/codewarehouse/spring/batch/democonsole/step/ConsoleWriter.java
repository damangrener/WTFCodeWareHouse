package com.wtf.codewarehouse.spring.batch.democonsole.step;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * @Author: WTF
 * @Date: 2021/2/5 11:10
 */
@Slf4j
public class ConsoleWriter implements ItemWriter<String> {
    @Override
    public void write(List<? extends String> list) throws Exception {
        for (String msg: list
             ) {
            log.debug("ConsoleWriter write data: "+msg);
            System.err.println("ConsoleWriter write data: "+msg);
        }
    }
}
