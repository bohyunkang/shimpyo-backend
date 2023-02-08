package kr.bohyunkang.shimpyo.services;

import kr.bohyunkang.shimpyo.models.User;
import kr.bohyunkang.shimpyo.models.valueobjects.Email;
import kr.bohyunkang.shimpyo.models.valueobjects.Name;
import kr.bohyunkang.shimpyo.models.valueobjects.Nickname;
import kr.bohyunkang.shimpyo.models.valueobjects.Password;
import kr.bohyunkang.shimpyo.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CreateUserServiceTest {
    private CreateUserService createUserService;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setup() {
        passwordEncoder = new Argon2PasswordEncoder(16, 32, 1, 2, 2);
        userRepository = mock(UserRepository.class);

        createUserService = new CreateUserService(userRepository, passwordEncoder);
    }

    @Test
    void create() {
        Email email = new Email("healing@shimpyo.com");
        Password password = new Password("Healing1234!");
        Name name = new Name("강힐링");
        Nickname nickname = new Nickname("힐링이필요해");

        User user = createUserService.create(email, password, name, nickname);

        assertThat(user).isNotNull();
        assertThat(user.getNickname()).isEqualTo(nickname);
        verify(userRepository).save(any());
    }
}
