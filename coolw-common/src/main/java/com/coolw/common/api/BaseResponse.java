package com.coolw.common.api;

import com.coolw.common.enums.RespCodeEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @Description 统一结果响应
 * @Date 2021/1/19 10:06
 * @Author coolw
 */
@Getter
@Setter
public class BaseResponse<T> extends BaseDomain {

    private static final long serialVersionUID = 8176438273722608810L;

    private String code;

    private String message;

    private T data;

    public static <T> BaseResponse<T> success() {
        return success(null, null);
    }

    public static <T> BaseResponse<T> success(T data) {
        return success(null, data);
    }

    public static <T> BaseResponse<T> success(String message, T data) {
        BaseResponse<T> response = new BaseResponse();
        response.setCode(RespCodeEnum.SUCCESS.getRespCode());
        response.setMessage(StringUtils.hasLength(message) ? message : RespCodeEnum.SUCCESS.getRespMsg());
        response.setData(data);
        return response;
    }

    public static <T> BaseResponse<T> fail() {
        return fail(null, null);
    }

    public static <T> BaseResponse<T> fail(String message) {
        return fail(null, message);
    }

    public static <T> BaseResponse<T> fail(ResponseService responseService) {
        return fail(responseService.getRespCode(), responseService.getRespMsg());
    }

    public static <T> BaseResponse<T> fail(String code, String message) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(StringUtils.hasLength(code) ? code : RespCodeEnum.FAIL.getRespCode());
        response.setMessage(StringUtils.hasLength(message) ? message : RespCodeEnum.FAIL.getRespMsg());
        return response;
    }

    public boolean checkIfSuccess() {
        return Objects.equals(RespCodeEnum.SUCCESS.getRespCode(), this.code);
    }

    public boolean checkIfFail() {
        return !checkIfSuccess();
    }
}
