package com.coolw.common.api;

import com.coolw.common.enums.ResFlagEnum;
import lombok.Data;

import java.util.Objects;

/**
 * @Classname ResultResponse
 * @Description 统一结果响应
 * @Date 2021/1/19 10:06
 * @Author lw
 */
@Data
public class ResultResponse<T> extends BaseDomain {

    private static final long serialVersionUID = 8176438273722608810L;

    /** 交易标识 S:成功, F:失败 */
    private String flag;

    private String code;

    private String msg;

    private T data;

    public ResultResponse success() {
        ResultResponse resultResponse = new ResultResponse<>();
        resultResponse.setFlag(ResFlagEnum.SUCCESS.getResponseCode());
        return resultResponse;
    }

    public ResultResponse success(T data) {
        ResultResponse resultResponse = success();
        resultResponse.setData(data);
        return resultResponse;
    }

    public ResultResponse fail() {
        ResultResponse resultResponse = new ResultResponse<>();
        resultResponse.setFlag(ResFlagEnum.FAIL.getResponseCode());
        return resultResponse;
    }

    public ResultResponse fail(String code, String msg) {
        ResultResponse resultResponse = fail();
        resultResponse.setCode(code);
        resultResponse.setMsg(msg);
        return resultResponse;
    }

    public ResultResponse fail(String msg) {
        ResultResponse resultResponse = fail();
        resultResponse.setMsg(msg);
        return resultResponse;
    }

    public ResultResponse fail(ResponseService responseService) {
        ResultResponse resultResponse = fail();
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
