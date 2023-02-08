package kr.bohyunkang.shimpyo.dtos;

public class UserCreationDto {
    private Long id;
    private String email;
    private String name;
    private String nickname;

    public UserCreationDto() {
    }

    public UserCreationDto(Long id, String email, String name, String nickname) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.nickname = nickname;
    }

    public Long getId() {
        return id;
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
