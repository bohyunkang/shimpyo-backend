package kr.bohyunkang.shimpyo.models.valueobjects;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TimeTest {
    final Time time = new Time("12");

    @Test
    void value() {
        assertThat(time.value())
                .isEqualTo("12");
    }

    @Test
    void equals() {
        assertThat(time)
                .isEqualTo(new Time("12"));

        assertThat(time)
                .isNotEqualTo(new Time("24"));

        assertThat(time)
                .isNotEqualTo(null);

        assertThat(time)
                .isNotEqualTo("12");
    }
}
