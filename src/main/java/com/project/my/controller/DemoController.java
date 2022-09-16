package com.project.my.controller;

import com.project.my.module.retry.RetryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @ClassName DemoController
 * @Description 重试方法
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

}
