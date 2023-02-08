package kr.bohyunkang.shimpyo.services;

import kr.bohyunkang.shimpyo.exceptions.UserNotFound;
import kr.bohyunkang.shimpyo.models.User;
import kr.bohyunkang.shimpyo.models.valueobjects.Email;
import kr.bohyunkang.shimpyo.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GetUserService {
    private UserRepository userRepository;

    public GetUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Email email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFound(email));

        return user;
    }
}
