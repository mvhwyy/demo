package com.project.my.module.retry;

import com.project.my.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

/**
 * @ClassName RetryService
 * @Description TODO
 * @Author mawei
 * @Date 2019/11/19 11:36 上午
 * @Version 1.0
 */
@Service
@Slf4j
public class RetryService {

    /**
     * Retryable注解
     * 被注解的方法发生异常时会重试
     * value:指定发生的异常进行重试
     * include:和value一样，默认空，当exclude也为空时，所有异常都重试
     * exclude:指定异常不重试，默认空，当include也为空时，所有异常都重试
     * maxAttemps:重试次数，默认3
     * backoff:重试补偿机制，默认没有
     * <p>
     * Backoff注解
     * delay:指定延迟后重试
     * multiplier:指定延迟的倍数，比如delay=5000l,multiplier=2时，第一次重试为5秒后，第二次为10秒，第三次为20秒
     */
    @Retryable(value = {BizException.class}, maxAttempts = 4, backoff = @Backoff(delay = 5000L))
    public void retry() {
        log.info("retry重试:{}", LocalTime.now());
        throw new BizException(10001, "retry测试");
    }

    /**
     * Recover：用于@Retryable重试失败后处理方法，此方法里的异常一定要是@Retryable方法里抛出的异常，否则不会调用
     *
     * @param bizEx 异常信息
     */
    @Recover
    public void recover(BizException bizEx) {
        System.out.println(bizEx.getMessage());
    }
}
