package kr.bohyunkang.shimpyo.models.valueobjects;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TitleTest {
    final Title title = new Title("따뜻한 위로의 차담, 만덕산 옛길 산책");

    @Test
    void value() {
        assertThat(title.value())
                .isEqualTo("따뜻한 위로의 차담, 만덕산 옛길 산책");
    }

    @Test
    void equals() {
        assertThat(title)
                .isEqualTo(new Title("따뜻한 위로의 차담, 만덕산 옛길 산책"));

        assertThat(title)
                .isNotEqualTo(new Title("깨어있는 휴식, 여러가지 명상 체험"));

        assertThat(title)
                .isNotEqualTo(null);

        assertThat(title)
                .isNotEqualTo("따뜻한 위로의 차담, 만덕산 옛길 산책");
    }

}
