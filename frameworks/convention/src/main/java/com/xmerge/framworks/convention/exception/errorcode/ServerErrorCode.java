package com.xmerge.framworks.convention.exception.errorcode;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Xmerge
 */

@Getter
@AllArgsConstructor
public enum ServerErrorCode implements IErrorCode {

    BASE_ERROR("B10000", "服务端异常"),

    SERVICE_TIMEOUT("B10001", "服务超时"),
    SERVICE_ERROR("B10002", "服务异常"),
    SERVICE_NOT_FOUND("B10003", "服务未找到"),
    SERVICE_NOT_IMPLEMENT("B10004", "服务未实现"),
    SERVICE_NOT_SUPPORT("B10005", "服务不支持"),
    SERVICE_NOT_SUPPORT_METHOD("B10006", "服务不支持该方法"),

    SERVICE_BUSY("B10007", "服务繁忙"),
    SERVICE_UNAVAILABLE("B10008", "服务不可用"),

    SERVER_NOT_FOUND("B10009", "服务器未找到"),
    SERVER_NOT_AVAILABLE("B10010", "服务当前不可用，请稍后重试"),
    SERVER_OFFLINE("B10011", "服务器已离线，请联系管理员"),
    ;

    private final String code;
    private final String message;
}
