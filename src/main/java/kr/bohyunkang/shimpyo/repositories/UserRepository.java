package kr.bohyunkang.shimpyo.repositories;

import kr.bohyunkang.shimpyo.models.User;
import kr.bohyunkang.shimpyo.models.valueobjects.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(Email email);

    Boolean existsByEmail(Email email);

    List<User> findAllByEmail(Email email);
}
