package kr.bohyunkang.shimpyo.models.valueobjects;

import kr.bohyunkang.shimpyo.exceptions.InvalidNickname;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NicknameTest {

    @Test
    void lessThanThreeCharacters() {
        assertThrows(InvalidNickname.class, () -> {
            new Nickname("힐링");
        });
    }

    @Test
    void moreThanEightCharacters() {
        assertThrows(InvalidNickname.class, () -> {
            new Nickname("힐링이 필요해 난 네가 필요해");
        });
    }

    @Test
    void value() {
        Nickname nickname = new Nickname("힐링이필요해");

        assertThat(nickname.value())
                .isEqualTo("힐링이필요해");
    }

    @Test
    void equals() {
        Nickname nickname = new Nickname("힐링이필요해");

        assertThat(nickname)
                .isEqualTo(new Nickname("힐링이필요해"));

        assertThat(nickname)
                .isNotEqualTo(new Nickname("통못자쿨냥이"));

        assertThat(nickname)
                .isNotEqualTo(null);

        assertThat(nickname)
                .isNotEqualTo("힐링이필요해");
    }
}
