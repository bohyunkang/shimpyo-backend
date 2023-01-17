package kr.bohyunkang.shimpyo.models.valueobjects;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ImageUrlTest {
    final ImageUrl imageUrl = new ImageUrl("http://shimpyo.bohyunkang.kr/7.png");

    @Test
    void value() {
        assertThat(imageUrl.value())
                .isEqualTo("http://shimpyo.bohyunkang.kr/7.png");
    }

    @Test
    void equals() {
        assertThat(imageUrl)
                .isEqualTo(new ImageUrl("http://shimpyo.bohyunkang.kr/7.png"));

        assertThat(imageUrl)
                .isNotEqualTo(new ImageUrl("http://"));

        assertThat(imageUrl)
                .isNotEqualTo(null);

        assertThat(imageUrl)
                .isNotEqualTo("http://shimpyo.bohyunkang.kr/7.png");
    }
}
