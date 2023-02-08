package kr.bohyunkang.shimpyo.models;

import kr.bohyunkang.shimpyo.models.valueobjects.Email;
import kr.bohyunkang.shimpyo.models.valueobjects.Name;
import kr.bohyunkang.shimpyo.models.valueobjects.Nickname;
import kr.bohyunkang.shimpyo.models.valueobjects.Password;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void creationAndChangePassword() {
        PasswordEncoder passwordEncoder = new Argon2PasswordEncoder(16, 32, 1, 2, 2);

        Email email = new Email("healing@shimpyo.com");
        Password password = new Password("Healing1234!");
        Name name = new Name("강힐링");
        Nickname nickname = new Nickname("힐링이필요해");

        User user = new User(email, name, nickname);
        user.changePassword(password, passwordEncoder);

        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getPassword()).isNotNull();
        assertThat(user.getPassword()).isNotEqualTo(password);
        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getNickname()).isEqualTo(nickname);
    }

    @Test
    void authenticate() {
        PasswordEncoder passwordEncoder = new Argon2PasswordEncoder(16, 32, 1, 2, 2);

        User user = new User();
        user.changePassword(new Password("Healing1234!"), passwordEncoder);

        assertThat(user.authenticate(new Password("Healing1234!"), passwordEncoder)).isTrue();
        assertThat(user.authenticate(new Password("Healing1234?"), passwordEncoder)).isFalse();
    }
}
