package com.project.my.controller;

import com.project.my.retry.RetryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName DemoController
 * @Description TODO
 * @Author mawei
 * @Date 2019/11/19 5:01 下午
 * @Version 1.0
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @Resource
    private RetryService retryService;

    @RequestMapping(value = "/retry")
    public void retry() {
        retryService.retry();
    }

    public static void main(String[] args) {
        // 获取当月第一天和最后一天
        SimpleDateFormat formatTemp = new SimpleDateFormat("yyyy-MM-dd");
        String lastday;
        // 获取当前月的最后一天
        Calendar cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        lastday = formatTemp.format(cale.getTime());
        System.out.println("lastday:"+lastday);
        System.out.println(new Date().compareTo(cale.getTime()));
    }
}
