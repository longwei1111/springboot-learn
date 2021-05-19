package com.coolw.common.api;

import com.coolw.common.enums.ResFlagEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @Description 统一结果响应
 * @Date 2021/1/19 10:06
 * @Author coolw
 */
@Getter
@Setter
public class Response<T> extends BaseDomain {

    private static final long serialVersionUID = 8176438273722608810L;

    /** 交易标识 S:成功, F:失败 */
    private String flag;

    private String code;

    private String msg;

    private T data;

    public Response success() {
        Response resultResponse = new Response<>();
        resultResponse.setFlag(ResFlagEnum.SUCCESS.getResponseCode());
        return resultResponse;
    }

    public Response success(T data) {
        Response resultResponse = success();
        resultResponse.setData(data);
        return resultResponse;
    }

    public Response fail() {
        Response resultResponse = new Response<>();
        resultResponse.setFlag(ResFlagEnum.FAIL.getResponseCode());
        return resultResponse;
    }

    public Response fail(String code, String msg) {
        Response resultResponse = fail();
        resultResponse.setCode(code);
        resultResponse.setMsg(msg);
        return resultResponse;
    }

    public Response fail(String msg) {
        Response resultResponse = fail();
        resultResponse.setMsg(msg);
        return resultResponse;
    }

    public Response fail(ResponseService responseService) {
        Response resultResponse = fail();
        resultResponse.setCode(responseService.getResponseCode());
        resultResponse.setMsg(responseService.getResponseMessage());
        return resultResponse;
    }

    public boolean checkIfSuccess() {
        return Objects.equals(ResFlagEnum.SUCCESS.getResponseCode(), flag);
    }

    public boolean checkIfFail() {
        return !checkIfSuccess();
    }
}
