package com.coody.springboot05.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname User
 * @Description TODO
 * @Author lw
 * @Date 2020-02-22 20:03
 */
@ApiModel(value = "用户实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @ApiModelProperty(value = "用户唯一标识")
    private Integer id;

    @ApiModelProperty(value = "用户姓名")
    private String username;

    @ApiModelProperty(value = "用户密码")
    private String password;
}
