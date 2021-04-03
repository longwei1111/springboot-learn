package com.coolw.function.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname User
 * @Description
 * @Author lw
 * @Date 2020-02-22 20:03
 */
@ApiModel(value = "用户实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * @ApiModel 注解用于实体类，表示对类进行说明，用于参数用实体类接收
     * @ApiModelProperty 注解用于类中属性，表示对 model 属性的说明或者数据操作更改
     */

    @ApiModelProperty(value = "用户唯一标识")
    private Integer id;

    @ApiModelProperty(value = "用户姓名")
    private String username;

    @ApiModelProperty(value = "用户密码")
    private String password;
}
