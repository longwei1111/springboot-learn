package com.coolw.mybatisplus.domain.req;

import com.coolw.mybatisplus.util.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TODO
 *
 * @author coolw
 * @date 2021/12/21 13:51
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserReportReq extends PageRequest {

    private String userName;

}
