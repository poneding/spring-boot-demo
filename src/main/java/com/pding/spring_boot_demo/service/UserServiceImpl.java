package com.pding.spring_boot_demo.service;

import com.pding.spring_boot_demo.dao.UserRepository;
import com.pding.spring_boot_demo.dto.UserDTO;
import com.pding.spring_boot_demo.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User add(UserDTO userDTO) {

        User user = new User();
        BeanUtils.copyProperties(userDTO,user);

        return userRepository.save(user);
    }

    @Override
    public UserDTO getById(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(String.format("根据 ID %d 获取用户失败", id)));
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

}
