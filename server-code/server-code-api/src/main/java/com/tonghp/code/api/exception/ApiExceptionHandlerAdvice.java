package com.tonghp.code.api.exception;

import com.tonghp.code.api.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @Description: api异常转化
 * @Author: Tonghp
 * @CreateDate: 2020/04/24 14:28
 * @Version: 1.0
 */
@RestControllerAdvice
class ApiExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    public ApiResponse exception(Exception exception) {
        ApiResponse apiResponse = new ApiResponse();
        if(exception instanceof ApiException){//api异常
            ApiException apiException = (ApiException)exception;
            apiResponse.setCode(apiException.getErrorCode());
        }else{//未知异常
            apiResponse.setCode(500L);
        }
        apiResponse.setMessage(exception.getMessage());
        return apiResponse;
    }
}