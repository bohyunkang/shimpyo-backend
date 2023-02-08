package kr.bohyunkang.shimpyo.services;

import kr.bohyunkang.shimpyo.exceptions.LoginFailed;
import kr.bohyunkang.shimpyo.models.User;
import kr.bohyunkang.shimpyo.models.valueobjects.Email;
import kr.bohyunkang.shimpyo.models.valueobjects.Password;
import kr.bohyunkang.shimpyo.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public LoginService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User login(Email email, Password password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new LoginFailed());

        if (!user.authenticate(password, passwordEncoder)) {
            throw new LoginFailed();
        }

        return user;
    }
}
