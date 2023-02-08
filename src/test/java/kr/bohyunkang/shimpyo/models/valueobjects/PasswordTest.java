package kr.bohyunkang.shimpyo.models.valueobjects;

import kr.bohyunkang.shimpyo.exceptions.InvalidPassword;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PasswordTest {
    @Test
    void correctPassword() {
        assertDoesNotThrow(() -> {
            new Password("Healing1234!");
        });
    }

    @Test
    void shortPassword() {
        assertThrows(InvalidPassword.class, () -> {
            new Password("He123!");
        });
    }

    @Test
    void passwordWithoutLowerCase() {
        assertThrows(InvalidPassword.class, () -> {
            new Password("HEALING1234!");
        });
    }

    @Test
    void passwordWithoutUpperCase() {
        assertThrows(InvalidPassword.class, () -> {
            new Password("healing1234!");
        });
    }

    @Test
    void passwordWithoutNumber() {
        assertThrows(InvalidPassword.class, () -> {
            new Password("healing!");
        });
    }

    @Test
    void passwordWithoutSpecialCharacter() {
        assertThrows(InvalidPassword.class, () -> {
            new Password("Healing1234");
        });
    }

    @Test
    void value() {
        Password password = new Password("Healing1234!");

        assertThat(password.value())
                .isEqualTo("Healing1234!");
    }

    @Test
    void equals() {
        Password password = new Password("Healing1234!");

        assertThat(password)
                .isEqualTo(new Password("Healing1234!"));

        assertThat(password)
                .isNotEqualTo(new Password("Xxx1234!"));

        assertThat(password)
                .isNotEqualTo(null);

        assertThat(password)
                .isNotEqualTo("Healing1234!");
    }
}
