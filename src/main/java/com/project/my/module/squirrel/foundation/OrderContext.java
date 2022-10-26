package com.project.my.module.squirrel.foundation;

/**
 * @author mawei
 * @version 1.0
 * @name OrderContext
 * @description TODO
 * @menu TODO
 * @date 2022/9/28 8:04 下午
 */
public class OrderContext {

    public OrderContext(Order eOrder, Long orderId) {

        this.Order = Order;

        this.orderId = orderId;

    }


    public OrderContext() {

    }


    private Order Order;

//逻辑参数

    private Long orderId;


    public Order getOrder() {

        return Order;

    }


    public void seteOrder(Order Order) {

        this.Order = Order;

    }


    public Long getOrderId() {

        return orderId;

    }


    public void setOrderId(Long orderId) {

        this.orderId = orderId;

    }
}
