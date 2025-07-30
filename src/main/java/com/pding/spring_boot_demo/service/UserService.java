package com.pding.spring_boot_demo.service;

import com.pding.spring_boot_demo.dto.UserDTO;
import com.pding.spring_boot_demo.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {
    /**
     * 添加用户
     * @param userDTO 用户数据传输对象
     * @return 添加后的用户实体
     */
    User add(UserDTO userDTO);

    /**
     * 根据 ID 获取用户
     * @param id 用户 ID
     * @return 用户数据传输对象
     */
    UserDTO getById(long id);
}
