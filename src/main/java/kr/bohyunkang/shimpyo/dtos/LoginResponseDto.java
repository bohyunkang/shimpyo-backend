package kr.bohyunkang.shimpyo.dtos;

public class LoginResponseDto {
    public String accessToken;
    public String nickname;

    public LoginResponseDto() {
    }

    public LoginResponseDto(String accessToken, String nickname) {
        this.accessToken = accessToken;
        this.nickname = nickname;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getNickname() {
        return nickname;
    }
}
