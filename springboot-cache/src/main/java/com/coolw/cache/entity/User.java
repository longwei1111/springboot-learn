package com.coolw.cache.entity;

import com.coolw.common.api.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Classname User
 * @Description
 * @Author lw
 * @Date 2020-03-05 15:50
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    private static final long serialVersionUID = -6423227239244356899L;

    private String username;
    private String password;
}
