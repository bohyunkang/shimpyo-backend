package kr.bohyunkang.shimpyo.models.valueobjects;

import kr.bohyunkang.shimpyo.exceptions.InvalidEmail;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailTest {
    final Email email = new Email("healing@shimpyo.com");

    @Test
    void correctEmail() {
        assertDoesNotThrow(() -> {
            new Email("healing@shimpyo.com");
        });
    }

    @Test
    void invalidEmail() {
        assertThrows(InvalidEmail.class, () -> {
            new Email("incorrectEmail");
        });
    }

    @Test
    void value() {
        assertThat(email.value())
                .isEqualTo("healing@shimpyo.com");
    }

    @Test
    void equals() {
        assertThat(email)
                .isEqualTo(new Email("healing@shimpyo.com"));

        assertThat(email)
                .isNotEqualTo(new Email("xxx@shimpyo.com"));

        assertThat(email)
                .isNotEqualTo(null);

        assertThat(email)
                .isNotEqualTo("healing@shimpyo.com");
    }
}
