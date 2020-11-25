package spring.boot.com.sbparser.service;

import java.util.List;
import spring.boot.com.sbparser.dto.UserResponseDto;

public interface UserService {
    List<UserResponseDto> findMostActive(int quantity);
}
