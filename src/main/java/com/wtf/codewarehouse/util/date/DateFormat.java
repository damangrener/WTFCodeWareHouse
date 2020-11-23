package com.wtf.codewarehouse.util.date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 注解
 * 入参：@DateTimeFormat
 * 出参：@JsonFormat
 *
 * @author wangtengfei
 * @since 2020/10/9 15:26
 */
@Data
public class DateFormat {

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date date;


}
