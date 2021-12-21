package com.coolw.mybatisplus.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.commons.collections4.CollectionUtils;

/**
 * 数据分页工具类
 *
 * @author coolw
 * @date 2021/12/21 11:16
 * @since 1.0
 */
public class PageUtils {

    /**
     * 分页统一结果转换
     *
     * @param page
     * @param <T>
     * @return 分页结果
     */
    public static <T> PageResult<T> convertPageResult(IPage<T> page) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(Integer.parseInt(String.valueOf(page.getCurrent())));
        pageResult.setPageSize(Integer.parseInt(String.valueOf(page.getSize())));
        pageResult.setTotalPages(Integer.parseInt(String.valueOf(page.getPages())));
        pageResult.setTotalSize(page.getTotal());
        pageResult.setData(page.getRecords());
        return pageResult;
    }

}
