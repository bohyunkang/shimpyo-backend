package kr.bohyunkang.shimpyo.dtos;

public class UserRegistrationDto {
    private String email;
    private String password;
    private String confirmPassword;
    private String name;
    private String nickname;

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String email, String password, String confirmPassword,
                               String name, String nickname) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.name = name;
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }
}
