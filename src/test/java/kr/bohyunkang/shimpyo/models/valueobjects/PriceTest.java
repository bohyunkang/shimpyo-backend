package kr.bohyunkang.shimpyo.models.valueobjects;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PriceTest {
    final Price price = new Price(70000L);

    @Test
    void value() {
        assertThat(price.value())
                .isEqualTo(70000L);
    }

    @Test
    void equals() {
        assertThat(price)
                .isEqualTo(new Price(70000L));

        assertThat(price)
                .isNotEqualTo(new Price(100000L));

        assertThat(price)
                .isNotEqualTo(null);

        assertThat(price)
                .isNotEqualTo(70000L);
    }
}
