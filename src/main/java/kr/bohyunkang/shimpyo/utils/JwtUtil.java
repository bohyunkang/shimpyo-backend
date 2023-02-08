package kr.bohyunkang.shimpyo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtUtil {
    private Algorithm algorithm;

    public JwtUtil(String secret) {
        this.algorithm = Algorithm.HMAC256(secret);
    }

    public String encode(String email) {
        return JWT.create()
                .withClaim("email", email)
                .sign(algorithm);
    }

    public String decode(String token) {
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT verify = verifier.verify(token);

        return verify.getClaim("email").asString();
    }
}
