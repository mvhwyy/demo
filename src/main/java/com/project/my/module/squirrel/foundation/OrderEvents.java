package com.project.my.module.squirrel.foundation;

/**
 * @author mawei
 * @version 1.0
 * @name OrderEvents
 * @description TODO
 * @menu TODO
 * @date 2022/9/28 8:05 下午
 */
public enum OrderEvents {
    FOUND, //创建订单

    SAOMA, //提交订单

    PAY, //付款

    USING_REFUNDING,

    COM_REFUNDING;

    public static OrderEvents getEvent(String event) {

        for (OrderEvents orderEvent : OrderEvents.values()) {

            if (orderEvent.name().equals(event)) {

                return orderEvent;

            }

        }

        return null;

    }
}
