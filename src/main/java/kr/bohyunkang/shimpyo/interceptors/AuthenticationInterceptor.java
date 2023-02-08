package kr.bohyunkang.shimpyo.interceptors;

import com.auth0.jwt.exceptions.JWTDecodeException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bohyunkang.shimpyo.exceptions.AuthenticationError;
import kr.bohyunkang.shimpyo.utils.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthenticationInterceptor implements HandlerInterceptor {
    private JwtUtil jwtUtil;

    public AuthenticationInterceptor(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");

        if (authorization == null || !authorization.startsWith("Bearer ")) {
            return true;
        }

        String accessToken = authorization.substring("Bearer ".length());

        try {
            String email = jwtUtil.decode(accessToken);

            request.setAttribute("email", email);

            return true;
        } catch (JWTDecodeException exception) {
            throw new AuthenticationError();
        }
    }
}
