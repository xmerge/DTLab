package com.xmerge.framworks.convention.result;


import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Xmerge
 */
@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {

    /**
     * 正确返回码
     */
    public static final String SUCCESS_CODE = "0";

    /**
     * 返回码
     */
    private String code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 请求ID
     */
    private String requestId;

    /**
     * 判断是否成功
     * 序列化时自动转化为success字段
     */
    public boolean isSuccess() {
        return SUCCESS_CODE.equals(code);
    }
}
