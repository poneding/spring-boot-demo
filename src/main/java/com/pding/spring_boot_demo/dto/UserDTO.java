package com.pding.spring_boot_demo.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UserDTO {
    private long id;

    // @NotNull // 不能为 NULL
    @NotBlank(message = "用户名不能为空") // 不能为 NULL 或空
    @Length(min=2,max=32,message = "用户名长度必须在 2 到 32 之间")
    private String username;
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;
    @Min(0)
    @Max(150)
    private Integer age;
}
