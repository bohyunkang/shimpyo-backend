package kr.bohyunkang.shimpyo.controllers;

import kr.bohyunkang.shimpyo.dtos.LoginRequestDto;
import kr.bohyunkang.shimpyo.dtos.LoginResponseDto;
import kr.bohyunkang.shimpyo.exceptions.LoginFailed;
import kr.bohyunkang.shimpyo.models.User;
import kr.bohyunkang.shimpyo.models.valueobjects.Email;
import kr.bohyunkang.shimpyo.models.valueobjects.Password;
import kr.bohyunkang.shimpyo.services.LoginService;
import kr.bohyunkang.shimpyo.utils.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class SessionController {
    private LoginService loginService;
    private JwtUtil jwtUtil;

    public SessionController(LoginService loginService, JwtUtil jwtUtil) {
        this.loginService = loginService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LoginResponseDto login(
            @RequestBody LoginRequestDto loginRequestDto
    ) {
        Email email = new Email(loginRequestDto.getEmail());
        Password password = new Password(loginRequestDto.getPassword());

        User user = loginService.login(email, password);

        String accessToken = jwtUtil.encode(user.getEmail().value());
        String nickname = user.getNickname().value();
        
        return new LoginResponseDto(accessToken, nickname);
    }

    @ExceptionHandler(LoginFailed.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String loginFailed() {
        return "Login failed!";
    }
}
