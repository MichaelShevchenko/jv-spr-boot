package spring.boot.com.sbparser.dto;

public class UserResponseDto {
    private String profileName;

    public UserResponseDto() {
    }

    public UserResponseDto(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }
}
