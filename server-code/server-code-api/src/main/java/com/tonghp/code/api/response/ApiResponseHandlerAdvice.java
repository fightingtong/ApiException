package com.tonghp.code.api.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tonghp.code.api.exception.ApiException;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Description:
 * @Author: Tonghp
 * @CreateDate: 2020/04/24 15:56
 * @Version: 1.0
 */
@RestControllerAdvice
public class ApiResponseHandlerAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> aClass) {
        // 如果接口返回的类型本身就是 ApiResponse 那就没有必要进行额外的操作，返回false
        return !returnType.getGenericParameterType().equals(ApiResponse.class);
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter returnType, MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest request, ServerHttpResponse response) {
        // String类型不能直接包装，所以要进行些特别的处理
        if (returnType.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // 将数据包装在 ApiResponse 里后，再转换为json字符串响应给前端
                return objectMapper.writeValueAsString(new ApiResponse<>(data));
            } catch (JsonProcessingException e) {
                throw new ApiException(500L, "类型转换错误");
            }
        }
        // 将原本的数据包装在 ApiResponse 里
        return new ApiResponse<>(data);
    }
}