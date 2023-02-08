package kr.bohyunkang.shimpyo.exceptions;

import kr.bohyunkang.shimpyo.models.valueobjects.Email;

public class UserNotFound extends RuntimeException {
    public UserNotFound(Email email) {
        super("User not found! Email: " + email.value());
    }
}
