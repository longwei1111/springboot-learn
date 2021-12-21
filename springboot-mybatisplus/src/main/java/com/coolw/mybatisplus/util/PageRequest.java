package com.coolw.mybatisplus.util;

import lombok.Data;

/**
 * 分页请求
 *
 * @author coolw
 * @date 2021/12/21 11:17
 * @since 1.0
 */
@Data
public class PageRequest {

    private Integer pageNum = 1;

    private Integer pageSize = 10;
}
