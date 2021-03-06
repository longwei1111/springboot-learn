package com.coolw.common.api;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Description
 * @Date 2021/1/19 10:46
 * @Author coolw
 */
@Getter
@Setter
public class BaseEntity extends BaseDomain {

    private static final long serialVersionUID = -8720665848011608399L;

    private long id;
    private Date crtTime;
    private Date uptTime;
}
