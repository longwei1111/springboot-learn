package com.coolw.function.sms.config;

/**
 * @Classname MDYConfig
 * @Description 秒滴云配置
 * @Date 2021/4/9 16:01
 * @Author lw
 */
public class MDYConfig {

    /**
     * 秒滴云短信登陆：http://api.miaodiyun.com/login.html
     * 账号：15000994425
     * 密码：Lw199411+
     *
     *  开发文档：http://www.miaodiyun.com/developer.html#guide
     * 以下信息需要获取：开发者注册后系统自动生成的账号，可在官网登录后查看
     */

    /** 验证码通知短信->API配置。 API地址 */
    public static final String BASE_URL = "https://openapi.danmi.com/distributor/sendSMS";

    /** 验证码通知短信->API配置。ACCOUNT SID*/
    public static final String ACCOUNT_SID = "39a01df7a86ae5a864514c064f21018e";

    /** 验证码通知短信->API配置。AUTH TOKEN */
    public static final String AUTH_TOKEN = "2a4fa7d9b877bc8a0336bb169aa4555c";

    /** 响应数据类型 */
    public static final String RESP_DATA_TYPE = "JSON";

}
