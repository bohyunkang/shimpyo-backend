package kr.bohyunkang.shimpyo.models.valueobjects;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PhoneNumberTest {
    final PhoneNumber phoneNumber = new PhoneNumber("01012345678");

    @Test
    void value() {
        assertThat(phoneNumber.value())
                .isEqualTo("01012345678");
    }

    @Test
    void equals() {
        assertThat(phoneNumber)
                .isEqualTo(new PhoneNumber("01012345678"));

        assertThat(phoneNumber)
                .isNotEqualTo(new PhoneNumber("00000000000"));

        assertThat(phoneNumber)
                .isNotEqualTo(null);

        assertThat(phoneNumber)
                .isNotEqualTo("01012345678");
    }
}
