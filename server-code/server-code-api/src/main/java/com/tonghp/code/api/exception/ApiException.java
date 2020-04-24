package com.tonghp.code.api.exception;

/**
 * @Description: Api异常超类
 * @Author: Tonghp
 * @CreateDate: 2020/04/24 10:53
 * @Version: 1.0
 */
public class ApiException extends RuntimeException {
    protected Long errorCode;
    protected Object data;

    public ApiException(Long errorCode, String message, Object data, Throwable e){
        super(message, e);
        this.errorCode = errorCode;
        this.data = data;
    }

    public ApiException(Long errorCode, String message, Object data){
        this(errorCode, message, data, null);
    }

    public ApiException(Long errorCode, String message){
        this(errorCode, message, null, null);
    }

    public ApiException(String message, Object data){
        this(null, message, data, null);
    }

    public ApiException(){
    }

    public ApiException(Throwable e){
        super(e);
    }

    public Long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Long errorCode) {
        this.errorCode = errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}