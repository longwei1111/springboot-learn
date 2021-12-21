package com.coolw.mybatisplus.util;

import lombok.Data;

import java.util.List;

/**
 * 分页结果
 *
 * @author coolw
 * @date 2021/12/21 11:14
 * @since 1.0
 */
@Data
public class PageResult<T> {

    /** 当前页码 */
    private int pageNum;

    /** 每页数量 */
    private int pageSize;

    /** 记录总数 */
    private long totalSize;

    /** 总页数 */
    private int totalPages;

    /** 业务数据列表 */
    private List<T> data;
}
