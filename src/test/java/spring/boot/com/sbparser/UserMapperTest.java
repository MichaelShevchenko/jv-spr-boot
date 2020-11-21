package spring.boot.com.sbparser;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;
import spring.boot.com.sbparser.dto.ReviewDto;
import spring.boot.com.sbparser.mapper.UserMapper;
import spring.boot.com.sbparser.model.Role;
import spring.boot.com.sbparser.model.User;

public class UserMapperTest {
    private static final String DEFAULT_PASSWORD = "1111";
    private static final String DEFAULT_ROLENAME = "USER";
    private static final UserMapper userMapper = new UserMapper();
    private static final ReviewDto properReviewDto = new ReviewDto();
    private static final ReviewDto noUserReviewDto = new ReviewDto();

    static {
        properReviewDto.setReviewId(14);
        properReviewDto.setProductId("B001GVISJM");
        properReviewDto.setUserId("A18ECVX2RJ7HUE");
        properReviewDto.setProfileName("\"willie \"\"roadie\"\"\"");
        properReviewDto.setHelpfulnessNumerator(2);
        properReviewDto.setHelpfulnessDenominator(2);
        properReviewDto.setScore(4);
        properReviewDto.setTime(LocalDateTime
                .ofInstant(Instant.ofEpochSecond(1288915200), ZoneId.systemDefault()));
        properReviewDto.setSummary("fresh and greasy!");
        properReviewDto.setText("good flavor! these came securely packed... they were "
                + "fresh and delicious! i love these Twizzlers!");

        noUserReviewDto.setReviewId(14);
        properReviewDto.setProductId("B001GVISJM");
        noUserReviewDto.setHelpfulnessNumerator(2);
        noUserReviewDto.setHelpfulnessDenominator(2);
        noUserReviewDto.setScore(4);
        noUserReviewDto.setTime(LocalDateTime
                .ofInstant(Instant.ofEpochSecond(1288915200), ZoneId.systemDefault()));
        noUserReviewDto.setSummary("fresh and greasy!");
        noUserReviewDto.setText("good flavor! these came securely packed... they were "
                + "fresh and delicious! i love these Twizzlers!");
    }

    @Test
    public void convertReviewDtoToUserOk() {
        User expected = new User(DEFAULT_PASSWORD, Set.of(Role.of(DEFAULT_ROLENAME)));
        expected.setExternalUserId("A18ECVX2RJ7HUE");
        expected.setProfileName("\"willie \"\"roadie\"\"\"");
        User actual = userMapper.convertDtoToUser(properReviewDto);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void convertReviewDtoWithNoUserInfo() {
        User expected = new User(DEFAULT_PASSWORD, Set.of(Role.of(DEFAULT_ROLENAME)));
        User actual = userMapper.convertDtoToUser(noUserReviewDto);
        Assert.assertEquals(expected, actual);
    }
}
