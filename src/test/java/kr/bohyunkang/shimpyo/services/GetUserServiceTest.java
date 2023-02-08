package kr.bohyunkang.shimpyo.services;

import kr.bohyunkang.shimpyo.exceptions.UserNotFound;
import kr.bohyunkang.shimpyo.models.User;
import kr.bohyunkang.shimpyo.models.valueobjects.Email;
import kr.bohyunkang.shimpyo.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GetUserServiceTest {
    private GetUserService getUserService;
    private UserRepository userRepository;

    @BeforeEach
    void setup() {
        userRepository = mock(UserRepository.class);
        getUserService = new GetUserService(userRepository);

        Email email = new Email("healing@shimpyo.com");
        given(userRepository.findByEmail(email))
                .willReturn(Optional.of(User.fake(email)));
    }

    @Test
    void user() {
        Email email = new Email("healing@shimpyo.com");

        User user = getUserService.getUser(email);

        verify(userRepository).findByEmail(email);

        assertThat(user.getEmail()).isEqualTo(email);
    }

    @Test
    void userNotFound() {
        Email email = new Email("xxx@shimpyo.com");

        assertThrows(UserNotFound.class, () -> getUserService.getUser(email));
    }
}
