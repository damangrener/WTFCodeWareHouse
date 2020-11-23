package com.wtf.codewarehouse.util.date;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author wangtengfei
 * @since 2020/10/9 15:38
 */
@RestController
@RequestMapping("/date")
public class DateDateController {

    @PostMapping("test")
    public DateFormat getDate(@RequestBody DateFormat vo){
        System.out.println("date1:"+vo.getDate());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(vo.getDate());
        System.out.println("date2:"+date);

        DateFormat vo2 = new DateFormat();
        vo2.setDate(new Date());
        return vo2;
    }



    @PostMapping("/test11111")
    public List<String> refreshTargetHistory(@RequestBody List<String> list) {
        return list;
    }
}
