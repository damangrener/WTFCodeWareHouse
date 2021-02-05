package com.wtf.codewarehouse.spring.batch.democonsole.step;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * @Author: WTF
 * @Date: 2021/2/5 11:11
 */
@Slf4j
public class StringReader implements ItemReader<String> {

    private String[] messages = {"aaa", "bbb", "ccc", "ddd"};

    private int count = 0;


    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (count < messages.length) {
            String message=messages[count++];
            log.debug("StringReader read data: "+message);
        }else {
            log.debug("StringReader read data end.");
            count=0;
        }
        return null;
    }
}
