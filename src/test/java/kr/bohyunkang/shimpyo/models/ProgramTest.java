package kr.bohyunkang.shimpyo.models;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
class ProgramTest {

    @Test
    void creation() {
        Location location = new Location("백련사");
        Title title = new Title("따뜻한 위로의 차담, 만덕산 옛길 산책");
        Price price = new Price(70000L);
        Address address = new Address("전라남도 강진군 도암면 백련사길 145");
        Category category = Category.TEMPLE;

        Program program = new Program(location, title, price, address, category);

        assertThat(program.location()).isEqualTo(location);
        assertThat(program.title()).isEqualTo(title);
        assertThat(program.price()).isEqualTo(price);
        assertThat(program.address()).isEqualTo(address);
        assertThat(program.category()).isEqualTo(category);
    }
}
