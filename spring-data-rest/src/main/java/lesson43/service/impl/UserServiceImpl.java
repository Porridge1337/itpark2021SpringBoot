package lesson43.service.impl;


import lesson43.model.User;
import lesson43.model.type.Status;
import lesson43.repository.RoleReposotory;
import lesson43.repository.UserRepository;
import lesson43.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {


    private final RoleReposotory roleReposotory;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User save(User userDto) {
        String encrypt = passwordEncoder.encode(userDto.getPassword());
        userDto.setStatus(Status.OK);
        userDto.setRole(roleReposotory.findByName("ADMIN"));
        userDto.setPassword(encrypt);
        return userRepository.save((userDto));
    }
}
