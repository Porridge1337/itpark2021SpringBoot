package tech.itpark.itpark2021.lesson35.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.itpark.itpark2021.lesson35.dto.UserDto;
import tech.itpark.itpark2021.lesson35.mapper.RoleMapper;
import tech.itpark.itpark2021.lesson35.mapper.UserMapper;
import tech.itpark.itpark2021.lesson35.model.type.Status;
import tech.itpark.itpark2021.lesson35.repository.RoleReposotory;
import tech.itpark.itpark2021.lesson35.repository.UserRepository;
import tech.itpark.itpark2021.lesson35.service.UserService;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final RoleMapper roleMapper;
    private final RoleReposotory roleReposotory;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        String encrypt = passwordEncoder.encode(userDto.getPassword());
        userDto.setStatus(Status.OK);
        userDto.setRole(roleMapper.toDtos(roleReposotory.findByName("ADMIN")));
        userDto.setPassword(encrypt);
        return userMapper.toDto(userRepository.save(userMapper.toEntity(userDto)));
    }
}
