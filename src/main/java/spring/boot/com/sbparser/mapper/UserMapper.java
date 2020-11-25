package spring.boot.com.sbparser.mapper;

import java.util.Set;
import org.springframework.stereotype.Component;
import spring.boot.com.sbparser.dto.ReviewDto;
import spring.boot.com.sbparser.model.Role;
import spring.boot.com.sbparser.model.User;

@Component
public class UserMapper {
    private static final String DEFAULT_PASSWORD = "1111";
    private static final String DEFAULT_ROLENAME = "USER";

    public User convertDtoToUser(ReviewDto reviewDto) {
        User newUser = new User(DEFAULT_PASSWORD, Set.of(Role.of(DEFAULT_ROLENAME)));
        newUser.setExternalUserId(reviewDto.getUserId());
        newUser.setProfileName(reviewDto.getProfileName());
        return newUser;
    }
}
