package kr.bohyunkang.shimpyo.models.valueobjects;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PickUpTest {
    final PickUp pickUp = new PickUp(false);

    @Test
    void value() {
        assertThat(pickUp.value())
                .isEqualTo(false);
    }

    @Test
    void equals() {
        assertThat(pickUp).
                isEqualTo(new PickUp(false));

        assertThat(pickUp).
                isNotEqualTo(new PickUp(true));

        assertThat(pickUp).
                isNotEqualTo(null);

        assertThat(pickUp).
                isNotEqualTo(false);
    }
}
