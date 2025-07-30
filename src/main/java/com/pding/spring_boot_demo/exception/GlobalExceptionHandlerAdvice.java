package com.pding.spring_boot_demo.exception;

import com.pding.spring_boot_demo.Response;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常统一处理
 */
@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {
    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandlerAdvice.class);

    @ExceptionHandler({Exception.class})
    public Response<Object> handleException(Exception e, HttpServletRequest request, HttpServletResponse response) {
        logger.error("处理请求发生错误: ", e);
        // TODO
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            StringBuilder sb = new StringBuilder("参数校验失败: ");
            ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
                sb.append(fieldError.getField())
                        .append(": ")
                        .append(fieldError.getDefaultMessage())
                        .append("; ");
            });
            return Response.error(sb.toString());
        } else if (e instanceof IllegalArgumentException) {
            // 处理非法参数异常
            return Response.error(e.getMessage());
        } else if (e instanceof NullPointerException) {
            // 处理空指针异常
            return Response.error("发生空指针异常，请检查请求参数。");
        }
        return Response.error("服务器发生错误，请稍后再试。");
    }

}
