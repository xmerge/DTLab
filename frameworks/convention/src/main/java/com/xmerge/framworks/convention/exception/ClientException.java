package com.xmerge.framworks.convention.exception;


import com.xmerge.framworks.convention.exception.errorcode.ClientErrorCode;
import com.xmerge.framworks.convention.exception.errorcode.IErrorCode;

/**
 * 客户端异常
 * @author Xmerge
 */
public class ClientException extends AbstractException {

    public ClientException(IErrorCode errorCode) {
        this(null, errorCode, errorCode.getMessage());
    }

    public ClientException(String message) {
        this(null, ClientErrorCode.BASE_ERROR, message);
    }

    public ClientException(IErrorCode errorCode, String message) {
        this(null, errorCode, message);
    }
    public ClientException(Throwable throwable, IErrorCode errorCode, String message) {
        super(throwable, errorCode, message);
    }

    @Override
    public String toString() {
        return "ClientException: {" +
                "code: '" + errorCode + "'," +
                "message: '" + errorMessage + "'" +
                '}';
    }
}
