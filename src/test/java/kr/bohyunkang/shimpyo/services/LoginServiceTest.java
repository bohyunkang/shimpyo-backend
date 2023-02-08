package kr.bohyunkang.shimpyo.services;

import kr.bohyunkang.shimpyo.exceptions.LoginFailed;
import kr.bohyunkang.shimpyo.models.User;
import kr.bohyunkang.shimpyo.models.valueobjects.Email;
import kr.bohyunkang.shimpyo.models.valueobjects.Password;
import kr.bohyunkang.shimpyo.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class LoginServiceTest {
    private LoginService loginService;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setup() {
        userRepository = mock(UserRepository.class);
        passwordEncoder = new Argon2PasswordEncoder(16, 32, 1, 2, 2);
        loginService = new LoginService(userRepository, passwordEncoder);
    }

    @Test
    void loginSuccess() {
        Email email = new Email("healing@shimpyo.com");
        Password password = new Password("Healing1234!");

        User user = User.fake(email);

        user.changePassword(password, passwordEncoder);

        given(userRepository.findByEmail(email)).willReturn(Optional.of(user));

        User found = loginService.login(email, password);

        assertThat(found.getEmail()).isEqualTo(email);
    }

    @Test
    void loginWithIncorrectUsername() {
        Email email = new Email("xxx@shimpyo.com");
        Password password = new Password("Healing1234!");

        assertThrows(LoginFailed.class, () -> {
            loginService.login(email, password);
        });
    }

    @Test
    void loginWithIncorrectPassword() {
        Email email = new Email("healing@shimpyo.com");
        Password password = new Password("Testing1234!");

        assertThrows(LoginFailed.class, () -> {
            loginService.login(email, password);
        });
    }
}
