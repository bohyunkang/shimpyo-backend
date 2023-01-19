package kr.bohyunkang.shimpyo.models;

import kr.bohyunkang.shimpyo.models.enums.Category;
import kr.bohyunkang.shimpyo.models.valueobjects.ImageUrl;
import kr.bohyunkang.shimpyo.models.valueobjects.Price;
import kr.bohyunkang.shimpyo.models.valueobjects.Title;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
class ProgramTest {

    @Test
    void creation() {
        Title title = new Title("따뜻한 위로의 차담, 만덕산 옛길 산책");
        Price price = new Price(70000L);
        ImageUrl imageUrl = new ImageUrl("http://shimpyo.bohyunkang.kr/7.png)");
        Category category = Category.TEMPLE;
        Long placeId = 1L;
        Set<String> offers = Set.of("주차가능", "수련복", "사찰음식", "일출", "다도", "연등", "카페테리아", "명상");
        List<String> rules = List.of(
                "여름에 소매 없는 옷과 무릎 위 짧은 바지는 삼가주세요.",
                "수건, 칫솔 등 개인 세면도구는 각자 준비하셔야 합니다.",
                "운동화 또는 등산화를 꼭 준비하세요.",
                "미성년자는 보호자나 인솔 교사의 동반 시에만 참가가 가능합니다."
        );

        Program program = new Program(title, price, imageUrl, category, placeId, offers, rules);

        assertThat(program.getTitle()).isEqualTo(title);
        assertThat(program.getPrice()).isEqualTo(price);
        assertThat(program.getImageUrl()).isEqualTo(imageUrl);
        assertThat(program.getCategory()).isEqualTo(category);
    }
}
