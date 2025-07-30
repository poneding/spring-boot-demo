package com.pding.spring_boot_demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

public class Response<T> {
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    @Getter
    @Setter
    private Integer code;
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorMsg;

    public static <T> Response<T> success(T data){
    Response<T> response = new Response<>();
        response.setData(data);
        response.setCode(1); // Assuming 1 means success
        return response;
    }

    public static <T> Response<T> success(){
        return success(null);
    }

    public static <T> Response<T> error(String errorMsg){
        Response<T> response = new Response<>();
        response.setCode(0); // Assuming 0 means error
        response.setErrorMsg(errorMsg);
        return response;
    }

//    public T getData() {
//        return data;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }
//
//    public Integer getCode() {
//        return code;
//    }
//
//    public void setCode(Integer code) {
//        this.code = code;
//    }

    // Spring Boot 使用 Jackson 进行 JSON 序列化时，会自动把 getXxx()
    // 或 isXxx() 的方法序列化为 JSON 字段，可以使用 @JsonIgnore 标注
    @JsonIgnore
    public boolean isSuccess() {
        return code != null && code == 1;
    }

//    public String getErrorMsg() {
//        return errorMsg;
//    }
//
//    public void setErrorMsg(String errorMsg) {
//        this.errorMsg = errorMsg;
//    }
}
