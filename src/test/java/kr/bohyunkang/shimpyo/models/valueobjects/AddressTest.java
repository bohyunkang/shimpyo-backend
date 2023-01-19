package kr.bohyunkang.shimpyo.models.valueobjects;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AddressTest {
    final Address address = new Address("전라남도 강진군 도암면 백련사길 145");

    @Test
    void value() {
        assertThat(address.value())
                .isEqualTo("전라남도 강진군 도암면 백련사길 145");
    }

    @Test
    void equals() {
        assertThat(address)
                .isEqualTo(new Address("전라남도 강진군 도암면 백련사길 145"));

        assertThat(address)
                .isNotEqualTo(new Address("서울시 사랑구 행복동 777"));

        assertThat(address)
                .isNotEqualTo(null);

        assertThat(address)
                .isNotEqualTo("전라남도 강진군 도암면 백련사길 145");
    }
}
