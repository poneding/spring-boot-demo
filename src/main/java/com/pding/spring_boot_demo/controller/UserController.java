package com.pding.spring_boot_demo.controller;

import com.pding.spring_boot_demo.Response;
import com.pding.spring_boot_demo.dto.UserDTO;
import com.pding.spring_boot_demo.entity.User;
import com.pding.spring_boot_demo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/api/v1/users")
@RestController
@Tag(name = "用户管接口", description = "提供用户信息的增删改查功能")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public Response<UserDTO> add(@Validated @RequestBody UserDTO userDTO) {
        User user = userService.add(userDTO);

        BeanUtils.copyProperties(user, userDTO);

        return Response.success(userDTO);
    }

    @GetMapping("/{id}")
    public Response<UserDTO> getById(@PathVariable("id") long id) {
        UserDTO userDTO = userService.getById(id);
        return Response.success(userDTO);
    }
}
