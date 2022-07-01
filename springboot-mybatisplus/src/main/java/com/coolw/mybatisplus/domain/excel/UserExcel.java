package com.coolw.mybatisplus.domain.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * TODO
 *
 * @author coolw
 * @date 2021/12/21 13:26
 * @since 1.0
 */
@Data
public class UserExcel {

    @ExcelProperty(value = "用户编号")
    private Integer id;

    @ExcelProperty(value = "身份证号")
    private String idCard;

    @ExcelProperty(value = "用户名")
    private String userName;

    @ExcelProperty(value = "手机号")
    private String mobile;

    @ExcelProperty(value = "居住地址")
    private String address;

    @ExcelProperty("创建时间")
    private Date createTime;
}
