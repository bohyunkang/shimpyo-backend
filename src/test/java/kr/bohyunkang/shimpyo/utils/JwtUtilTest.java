package kr.bohyunkang.shimpyo.utils;

import com.auth0.jwt.exceptions.JWTDecodeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JwtUtilTest {
    private static final String SECRET = "SECRET";

    private JwtUtil jwtUtil;

    @BeforeEach
    void setup() {
        jwtUtil = new JwtUtil(SECRET);
    }

    @Test
    void encodeAndDecode() {
        String original = "healing@shimpyo.com";

        String token = jwtUtil.encode(original);

        String email = jwtUtil.decode(token);

        assertThat(email).isEqualTo(original);
    }

    @Test
    void decodeError() {
        assertThrows(JWTDecodeException.class, () -> {
            jwtUtil.decode("xxx@shimpyo.com");
        });
    }
}
