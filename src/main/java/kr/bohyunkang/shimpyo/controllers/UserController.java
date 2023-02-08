package kr.bohyunkang.shimpyo.controllers;

import jakarta.validation.Valid;
import kr.bohyunkang.shimpyo.dtos.UserCountDto;
import kr.bohyunkang.shimpyo.dtos.UserCreationDto;
import kr.bohyunkang.shimpyo.dtos.UserDto;
import kr.bohyunkang.shimpyo.dtos.UserRegistrationDto;
import kr.bohyunkang.shimpyo.exceptions.AlreadyExistingEmail;
import kr.bohyunkang.shimpyo.exceptions.NotMatchedPassword;
import kr.bohyunkang.shimpyo.exceptions.RegisterFailed;
import kr.bohyunkang.shimpyo.exceptions.UserNotFound;
import kr.bohyunkang.shimpyo.models.User;
import kr.bohyunkang.shimpyo.models.valueobjects.Email;
import kr.bohyunkang.shimpyo.models.valueobjects.Name;
import kr.bohyunkang.shimpyo.models.valueobjects.Nickname;
import kr.bohyunkang.shimpyo.models.valueobjects.Password;
import kr.bohyunkang.shimpyo.services.CountUserService;
import kr.bohyunkang.shimpyo.services.CreateUserService;
import kr.bohyunkang.shimpyo.services.GetUserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private GetUserService getUserService;
    private CreateUserService createUserService;
    private CountUserService countUserService;

    public UserController(GetUserService getUserService,
                          CreateUserService createUserService,
                          CountUserService countUserService) {
        this.getUserService = getUserService;
        this.createUserService = createUserService;
        this.countUserService = countUserService;
    }

    @GetMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    public UserDto user(
            @RequestAttribute("email") String email
    ) {
        User user = getUserService.getUser(new Email(email));

        return user.toDto();
    }

    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    public UserCountDto count(
            @RequestParam String email
    ) {
        return new UserCountDto(countUserService.countUser(new Email(email)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserCreationDto register(
            @Valid @RequestBody UserRegistrationDto userRegistrationDto
    ) {
        Email email = new Email(userRegistrationDto.getEmail());
        Password password = new Password(userRegistrationDto.getPassword());
        Name name = new Name(userRegistrationDto.getName());
        Nickname nickname = new Nickname(userRegistrationDto.getNickname());

        if (!userRegistrationDto.getConfirmPassword().equals(userRegistrationDto.getPassword())) {
            throw new NotMatchedPassword();
        }

        User user = createUserService.create(email, password, name, nickname);

        return user.toCreationDto();
    }

    @ExceptionHandler(UserNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFound() {
        return "User not found!";
    }

    @ExceptionHandler(AlreadyExistingEmail.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String emailAlreadyExists() {
        return "Email already exists!";
    }

    @ExceptionHandler(RegisterFailed.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String registerFailed() {
        return "Register failed!";
    }
}
