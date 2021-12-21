package com.coolw.mybatisplus.util;

import com.alibaba.excel.EasyExcel;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Excel工具类
 *
 * @author coolw
 * @date 2021/12/21 9:38
 * @since 1.0
 */
public class ExcelUtils {

    /**
     * 写入Excel数据
     * @param response
     * @param fileName 文件名称
     * @param sheetName Excel页签名称
     * @param data 数据列表
     * @param <T>
     * @throws IOException
     */
    public static <T> void writeExcel(HttpServletResponse response, String fileName, String sheetName
            , List<T> data, Class<?> clazz) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 通知浏览器以附件的形式下载处理
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        // 数据写完后,文件流会自动关闭
        EasyExcel.write(response.getOutputStream(), clazz)
                .sheet(sheetName)
                .doWrite(data);
    }

}
