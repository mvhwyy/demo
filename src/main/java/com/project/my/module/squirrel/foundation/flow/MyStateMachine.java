//package com.project.my.module.squirrel.foundation.flow;
//
///**
// * @author mawei
// * @version 1.0
// * @name MyStateMachine
// * @description TODO
// * @menu TODO
// * @date 2022/9/28 8:12 下午
// */
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.ApplicationContext;
//
///**
// * 定义 触发事件、状态变化时，调用的方法
// */
//@Slf4j
//public class MyStateMachine extends AbstractStateMachine<MyStateMachine, MyState, MyEvent, MyContext> {
//
//    private MyService myService;
//    protected ApplicationContext applicationContext;
//
//    //定义构造函数接受ApplicationContext注入
//    public SubmitOrderStateMachine(ApplicationContext applicationContext) {
//        this.applicationContext = applicationContext;
//        // 通过applicationContext注入orderService
//        this.myService = applicationContext.getBean(MyService.class);
//    }
//
//    // 状态转换时调用的方法，需要将方法名配置在 callMethod 内
//    // 若【方法名】符合 transitFrom[fromStateName]To[toStateName] 格式，不需要配置 callMethod
//    public void MyCallMethod(MyState fromState, OrderState MyState,MyEvent Event, MyContext Context) {
//        log.info("转换事件 {}=>{} on {} with {}.", fromState, toState, event, context);
//        myService.myMethod(toState);
//    }
//
//	...
//
//    // ==========================================================================================
//    // 如果不想用 DeclarativeEventListener 这种声明在单独类里的方法，可以直接重写以下方法，效果是一样的
//    // 两者同时用也可以，为了代码方便最好别这样
//    // ==========================================================================================
//    @Override
//    protected void afterTransitionCausedException(Object fromState, Object toState, Object event, Object context) {
//        /**
//         * 当状态转换过程中出现异常，已执行的action列表将失效并且状态机会进入error状态，意思就是状态机实例不会再处理任何event。
//         * 假如用户继续向状态机发送event，便会抛出IllegalStateException异常。所有状态转换过程中发生的异常，包括action执行和外部listener调用，会被包装成TransitionException（未检查异常）。
//         * 目前，默认的异常处理策略非常简单并且粗暴的连续抛出异常，可以参阅AbstractStateMachine.afterTransitionCausedException方法。
//         */
//        log.info("Override 发生错误 {}", getLastException().getMessage());
//        Throwable targeException = getLastException().getTargetException();
//        // recover from IllegalArgumentException thrown out from state 'A' to 'B' caused by event 'ToB'
//        if(targeException instanceof IllegalArgumentException &&
//            fromState.equals("A") && toState.equals("B") && event.equals("ToB")) {
//            // 在这里做一些错误清理工作
//            // ...
//            // 恢复此异常后，将状态机状态恢复为正常状态
//            setStatus(StateMachineStatus.IDLE);
//        } else if(...) {
//            // 从其他异常中恢复...
//        } else {
//            // afterTransitionCausedException 默认的实现是直接抛异常
//            super.afterTransitionCausedException(fromState, toState, event, context);
//        }
//    }
//    @Override
//    protected void beforeTransitionBegin(Object fromState, Object event, Object context) {
//        // 转换开始时被调用
//        System.out.println();
////        super.beforeTransitionBegin(fromState, event, context);
//        log.info("Override beforeTransitionBegin");
//    }
//    @Override
//    protected void afterTransitionCompleted(Object fromState, Object toState, Object event, Object context) {
//        // 转换完成时被调用
////        super.afterTransitionCompleted(fromState, toState, event, context);
//        log.info("Override afterTransitionCompleted");
//    }
//    @Override
//    protected void afterTransitionEnd(Object fromState, Object toState, Object event, Object context) {
//        // 转换结束时被调用
//        //       super.afterTransitionEnd(fromState, toState, event, context);
//        log.info("Override afterTransitionEnd");
//    }
//    @Override
//    protected void afterTransitionDeclined(Object fromState, Object event, Object context) {
//        // 当转换被拒绝时被调用。实际是调用 callMethod 中的方法被调用时，抛出异常时被调用
////        super.afterTransitionDeclined(fromState, event, context);
//        log.info("Override afterTransitionDeclined");
//    }
//    @Override
//    protected void beforeActionInvoked(Object fromState, Object toState, Object event, Object context) {
//        // 当转换开始时被调用。实际是 callMethod 中的方法被调用时，先调用该方法。类似于 AOP 的效果
//        //       super.beforeActionInvoked(fromState, toState, event, context);
//        log.info("Override beforeActionInvoked");
//    }
//    @Override
//    protected void afterActionInvoked(Object fromState, Object toState, Object event, Object context) {
//        // 当转换结束时被调用。实际是 callMethod 被调用后，调用该方法。类似于 AOP 的效果
//        //       super.afterActionInvoked(fromState, toState, event, context);
//        log.info("Override afterActionInvoked");
//    }
//}