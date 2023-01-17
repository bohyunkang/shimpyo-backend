package kr.bohyunkang.shimpyo.models.valueobjects;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NameTest {
    final Name name = new Name("백련사");

    @Test
    void value() {
        assertThat(name.value())
                .isEqualTo("백련사");
    }

    @Test
    void equals() {
        assertThat(name)
                .isEqualTo(new Name("백련사"));

        assertThat(name)
                .isNotEqualTo(new Name("해동용궁사"));

        assertThat(name)
                .isNotEqualTo(null);

        assertThat(name)
                .isNotEqualTo("백련사");
    }
}
