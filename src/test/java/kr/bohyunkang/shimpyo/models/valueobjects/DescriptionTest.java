package kr.bohyunkang.shimpyo.models.valueobjects;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DescriptionTest {
    final Description description = new Description("이건 장소에 대한 설명이 들어가는 곳입니다.");

    @Test
    void value() {
        assertThat(description.value())
                .isEqualTo("이건 장소에 대한 설명이 들어가는 곳입니다.");
    }

    @Test
    void equals() {
        assertThat(description)
                .isEqualTo(new Description("이건 장소에 대한 설명이 들어가는 곳입니다."));

        assertThat(description)
                .isNotEqualTo(new Description("XXX"));

        assertThat(description)
                .isNotEqualTo(null);

        assertThat(description)
                .isNotEqualTo("이건 장소에 대한 설명이 들어가는 곳입니다.");
    }
}
