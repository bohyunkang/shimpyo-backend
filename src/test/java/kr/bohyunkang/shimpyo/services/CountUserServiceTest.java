package kr.bohyunkang.shimpyo.services;

import kr.bohyunkang.shimpyo.models.User;
import kr.bohyunkang.shimpyo.models.valueobjects.Email;
import kr.bohyunkang.shimpyo.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class CountUserServiceTest {
    private CountUserService countUserService;
    private UserRepository userRepository;

    @BeforeEach
    void setup() {
        userRepository = mock(UserRepository.class);
        countUserService = new CountUserService(userRepository);
    }

    @Test
    void countWithExistingEmail() {
        Email email = new Email("healing@shimpyo.com");

        given(userRepository.findAllByEmail(email))
                .willReturn(List.of(User.fake()));

        Integer count = countUserService.countUser(email);

        assertThat(count).isEqualTo(1);
    }

    @Test
    void countWithNotExistingEmail() {
        Email email = new Email("healing@shimpyo.com");

        Integer count = countUserService.countUser(email);

        assertThat(count).isEqualTo(0);
    }
}
