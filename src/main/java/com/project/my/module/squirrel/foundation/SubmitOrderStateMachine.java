package com.project.my.module.squirrel.foundation;

import org.springframework.context.ApplicationContext;
import org.squirrelframework.foundation.fsm.UntypedStateMachine;
import org.squirrelframework.foundation.fsm.annotation.State;
import org.squirrelframework.foundation.fsm.annotation.StateMachineParameters;
import org.squirrelframework.foundation.fsm.annotation.States;
import org.squirrelframework.foundation.fsm.annotation.Transit;
import org.squirrelframework.foundation.fsm.annotation.Transitions;
import org.squirrelframework.foundation.fsm.impl.AbstractStateMachine;

import javax.annotation.Resource;

/**
 * @author mawei
 * @version 1.0
 * @name SubmitOrderStateMachine
 * @description TODO
 * @menu TODO
 * @date 2022/9/28 8:01 下午
 */

@States({

    @State(name = "UNFOUND", entryCallMethod = "entryStateInit", exitCallMethod = "exitStateInit", initialState = true),

    @State(name = "USING", entryCallMethod = "entryStateWaitPay", exitCallMethod = "exitStateWaitPay"),

    @State(name = "COMPLETE", entryCallMethod = "entryStateWaitSend", exitCallMethod = "exitStateWaitSend"),

    @State(name = "REFUND", entryCallMethod = "entryStatePartSend", exitCallMethod = "exitStatePartSend"),

    @State(name = "NOUSE", entryCallMethod = "entryStatePartSend", exitCallMethod = "exitStatePartSend")

})

@Transitions({

    @Transit(from = "UNFOUND", to = "UNFOUND", on = "FOUND", callMethod = "createOrder"),

    @Transit(from = "UNFOUND", to = "USING", on = "SAOMA", callMethod = "submitOrder"),

    @Transit(from = "USING", to = "COMPLETE", on = "PAY", callMethod = "pay"),

    @Transit(from = "USING", to = "REFUND", on = "USING_REFUNDING", callMethod = "usingRefund"),

    @Transit(from = "COMPLETE", to = "REFUND", on = "COM_REFUNDING", callMethod = "comRefund")

})

//该地方向AbstractStateMachine传递的参数
@StateMachineParameters(stateType = OrderStates.class, eventType = OrderEvents.class, contextType = OrderContext.class)
public class SubmitOrderStateMachine extends AbstractStateMachine<UntypedStateMachine, Object, Object, Object> implements UntypedStateMachine {
    private OrderService OrderService;
    protected ApplicationContext applicationContext;

    //定义构造函数接受ApplicationContext注入([参看New State Machine Instance](http://hekailiang.github.io/squirrel/))
    public SubmitOrderStateMachine(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        // 通过applicationContext注入orderService，这样就可以通过service操作数据库
        OrderService = (OrderService) this.applicationContext.getBean("OrderService");
    }


    //创建订单，依旧处于待使用状态
    public void createOrder(OrderStates fromState, OrderStates toState, OrderEvents OrderEvents,
                            OrderContext OrderContext) {
        //可以做一些创建订单等等操作
    }


    //提交订单
    public void submitOrder(OrderStates fromState, OrderStates toState, OrderEvents OrderEvents,
                            OrderContext OrderContext) {
    }


    //支付订单
    public void pay(OrderStates fromState, OrderStates toState, OrderEvents OrderEvents, OrderContext OrderContext) {

    }


    public void usingRefund(OrderStates fromState, OrderStates toState, OrderEvents OrderEvents,
                            OrderContext OrderContext) {

    }


    public void comRefund(OrderStates fromState, OrderStates toState, OrderEvents OrderEvents,
                          OrderContext OrderContext) {

    }


}
