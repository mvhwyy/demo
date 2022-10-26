package com.project.my.module.squirrel.foundation;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * @author mawei
 * @version 1.0
 * @name OrderStates
 * @description TODO
 * @menu TODO
 * @date 2022/9/28 8:05 下午
 */
public enum OrderStates implements IEnum<Integer> {


    UNFOUND(1,"待使用"),

    USING(2,"正使用"),

    COMPLETE(3,"已完成"),

    REFUND(4,"退款"),

    NOUSE(5,"放弃订单");


    private String desc;

    private int code;


    private OrderStates(int code,String desc) {

        this.code = code;

        this.desc = desc;

    }


    public String getDesc() {

        return desc;

    }

    public void setDesc(String desc) {

        this.desc = desc;

    }


    public int getCode() {

        return code;

    }

    public void setCode(int code) {

        this.code = code;

    }


    public static OrderStates getState(int code) {

        for (OrderStates orderState : OrderStates.values()) {

            if (orderState.ordinal()+1 == code) {

                return orderState;

            }

        }

        return null;

    }



    @Override

    public Integer getValue() {

// TODO Auto-generated method stub

        return code;
}
