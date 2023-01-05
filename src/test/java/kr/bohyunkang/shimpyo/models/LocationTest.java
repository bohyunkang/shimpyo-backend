package kr.bohyunkang.shimpyo.models;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LocationTest {
    final Location location = new Location("백련사");

    @Test
    void value() {
        assertThat(location.value())
                .isEqualTo("백련사");
    }

    @Test
    void equals() {
        assertThat(location)
                .isEqualTo(new Location("백련사"));

        assertThat(location)
                .isNotEqualTo(new Location("해동용궁사"));

        assertThat(location)
                .isNotEqualTo(null);

        assertThat(location)
                .isNotEqualTo("백련사");
    }
}
