package com.project.my.module.squirrel.foundation.flow;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author mawei
 * @version 1.0
 * @name StateMachineEngine
 * @description TODO
 * @menu TODO
 * @date 2022/9/28 8:11 下午
 */
public class StateMachineEngine implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    protected StateMachineBuilder<MyStateMachine, MyState, MyEvent, MyContext> builder;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
