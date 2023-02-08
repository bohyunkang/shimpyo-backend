package kr.bohyunkang.shimpyo.services;

import kr.bohyunkang.shimpyo.models.valueobjects.Email;
import kr.bohyunkang.shimpyo.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CountUserService {
    private UserRepository userRepository;

    public CountUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Integer countUser(Email email) {
        return userRepository.findAllByEmail(email).size();
    }
}
