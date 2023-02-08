package kr.bohyunkang.shimpyo.dtos;

public class UserDto {
    private String email;
    private String name;
    private String nickname;

    public UserDto() {
    }

    public UserDto(String email, String name, String nickname) {
        this.email = email;
        this.name = name;
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }
}
