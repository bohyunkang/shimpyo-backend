package kr.bohyunkang.shimpyo.models.enums;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CategoryTest {

    @Test
    void of() {
        String type = "TEMPLE";

        Category category = Category.of(type);

        assertThat(category.value()).isEqualTo(type);
    }
}
