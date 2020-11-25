package spring.boot.com.sbparser.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.com.sbparser.dto.UserResponseDto;
import spring.boot.com.sbparser.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final String DEFAULT_USERS_QUANTITY = "1000";
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/most-active")
    public List<UserResponseDto> getUser(
            @RequestParam(defaultValue = DEFAULT_USERS_QUANTITY) int usersQuantity) {
        return userService.findMostActive(usersQuantity);
    }
}
