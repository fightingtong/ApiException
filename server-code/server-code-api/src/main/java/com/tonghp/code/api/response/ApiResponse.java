package com.tonghp.code.api.response;

/**
 * @Description:
 * @Author: Tonghp
 * @CreateDate: 2020/04/24 14:12
 * @Version: 1.0
 */
public class ApiResponse<T> {
    /// <summary>
    /// 一个状态码，用于表示WebAPI方法的调用过程是否有异常。
    /// 0表示无异常；其他值为异常。非0时的具体值可根据使用场景定义。
    /// </summary>
    private Long code;

    /// <summary>
    /// 附加信息。通常可在WebAPI方法的调用过程出现错误时，提供更详细的描述信息。
    /// </summary>
    private String message;

    /// <summary>
    /// 当WebAPI方法调用无异常时，存储其返回值。否则为返回值类型的默认值。
    /// </summary>
    private T data;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /// <summary>
    /// 创建<see cref="ApiResponse{T}"/>的新实例。
    /// 此实例表示一次无异常的WebAPI方法调用，且该方法没有返回值。
    /// </summary>
    public ApiResponse()
    {
        this(null);
    }

    /// <summary>
    /// 创建<see cref="ApiResponse{T}"/>的新实例。
    /// 此实例表示一次无异常的WebAPI方法调用，并指定了该方法的返回值。
    /// </summary>
    public ApiResponse(Long code, String message) {
        this(code, message, null);
    }

    /// <summary>
    /// 创建<see cref="ApiResponse{T}"/>的新实例。
    /// 此实例表示一次无异常的WebAPI方法调用，并指定了该方法的返回值。
    /// </summary>
    public ApiResponse(T data) {
        this(0L, "", data);
    }

    /// <summary>
    /// 创建<see cref="ApiResponse{T}"/>的新实例。
    /// </summary>
    public ApiResponse(Long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}