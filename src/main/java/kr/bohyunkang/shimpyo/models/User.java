package kr.bohyunkang.shimpyo.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.bohyunkang.shimpyo.dtos.UserCreationDto;
import kr.bohyunkang.shimpyo.dtos.UserDto;
import kr.bohyunkang.shimpyo.models.valueobjects.Email;
import kr.bohyunkang.shimpyo.models.valueobjects.Name;
import kr.bohyunkang.shimpyo.models.valueobjects.Nickname;
import kr.bohyunkang.shimpyo.models.valueobjects.Password;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Email email;

    @Embedded
    private Password password;

    @Embedded
    private Name name;

    @Embedded
    private Nickname nickname;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public User() {
    }

    public User(Email email, Name name, Nickname nickname) {
        this.email = email;
        this.name = name;
        this.nickname = nickname;
    }

    public User(Long id, Email email, Name name, Nickname nickname) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.nickname = nickname;
    }

    public Email getEmail() {
        return email;
    }

    public Password getPassword() {
        return password;
    }

    public Name getName() {
        return name;
    }

    public Nickname getNickname() {
        return nickname;
    }

    public boolean authenticate(Password password, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(password.value(), this.password.value());
    }

    public void changePassword(Password password, PasswordEncoder passwordEncoder) {
        this.password = new Password(password, passwordEncoder);
    }

    public static User fake() {
        return new User(1L, new Email("healing@shimpyo.com"), new Name("강힐링"), new Nickname("힐링이필요해"));
    }

    public static User fake(Email email) {
        return new User(1L, email, new Name("강힐링"), new Nickname("힐링이필요해"));
    }

    public UserDto toDto() {
        return new UserDto(
                email.value(),
                name.value(),
                nickname.value()
        );
    }

    public UserCreationDto toCreationDto() {
        return new UserCreationDto(
                id,
                email.value(),
                name.value(),
                nickname.value()
        );
    }
}
