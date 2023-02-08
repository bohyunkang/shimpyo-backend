package kr.bohyunkang.shimpyo.services;

import kr.bohyunkang.shimpyo.exceptions.AlreadyExistingEmail;
import kr.bohyunkang.shimpyo.models.User;
import kr.bohyunkang.shimpyo.models.valueobjects.Email;
import kr.bohyunkang.shimpyo.models.valueobjects.Name;
import kr.bohyunkang.shimpyo.models.valueobjects.Nickname;
import kr.bohyunkang.shimpyo.models.valueobjects.Password;
import kr.bohyunkang.shimpyo.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreateUserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public CreateUserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User create(Email email, Password password,
                       Name name, Nickname nickname) {
        if (userRepository.existsByEmail(email)) {
            throw new AlreadyExistingEmail(email);
        }

        User user = new User(email, name, nickname);
        user.changePassword(password, passwordEncoder);

        userRepository.save(user);

        return user;
    }
}
