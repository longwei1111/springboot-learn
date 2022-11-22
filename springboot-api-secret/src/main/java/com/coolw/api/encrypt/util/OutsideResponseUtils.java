package com.coolw.api.encrypt.util;

import com.coolw.api.encrypt.model.OutsideResponse;
import com.coolw.common.api.BaseResponse;

/**
 * 外部响应工具类类
 *
 * @author coolw
 * @date 2022/11/22 9:09
 * @since 1.0
 */
public final class OutsideResponseUtils {
    
    /**
     * 外部响应结果统一转换格式 
     */
    public static <T> OutsideResponse<T> convert(BaseResponse<T> response) {
        OutsideResponse<T> outputResponse = new OutsideResponse();
        if (response.checkIfSuccess()) {
            outputResponse.setCode(0);
            outputResponse.setMsg("ok");
            outputResponse.setData(response.getData());
        } else {
            outputResponse.setCode(1);
            outputResponse.setMsg("fail");
        }
        return outputResponse;
    }
}
