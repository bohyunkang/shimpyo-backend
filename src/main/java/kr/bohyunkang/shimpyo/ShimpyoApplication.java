package kr.bohyunkang.shimpyo;

import kr.bohyunkang.shimpyo.interceptors.AuthenticationInterceptor;
import kr.bohyunkang.shimpyo.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ShimpyoApplication {
    @Value("${jwt.secret}")
    private String jwtSecret;

    public static void main(String[] args) {
        SpringApplication.run(ShimpyoApplication.class, args);
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/**");
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("*");
            }


            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(authenticationInterceptor());
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        int saltLength = 16;
        int hashLength = 32;
        int parallelism = 1;
        int memory = 2;
        int iterations = 2;

        return new Argon2PasswordEncoder(saltLength, hashLength, parallelism, memory, iterations);
    }


    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor(jwtUtil());
    }

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil(jwtSecret);
    }
}
