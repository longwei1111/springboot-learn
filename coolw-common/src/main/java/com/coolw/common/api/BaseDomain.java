package com.coolw.common.api;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * @Description
 * @Date 2021/1/19 10:07
 * @Author coolw
 */
public class BaseDomain implements Serializable {

    private static final long serialVersionUID = 240903659670897183L;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
