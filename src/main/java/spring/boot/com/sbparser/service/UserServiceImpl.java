package spring.boot.com.sbparser.service;

import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import spring.boot.com.sbparser.dto.UserResponseDto;
import spring.boot.com.sbparser.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponseDto> findMostActive(int quantity) {
        return userRepository.findMostActive(PageRequest.of(0, quantity));
    }
}
