package kr.bohyunkang.shimpyo.exceptions;

import kr.bohyunkang.shimpyo.models.valueobjects.Email;

public class AlreadyExistingEmail extends RegisterFailed {
    public AlreadyExistingEmail(Email email) {
        super("Email already exists! Email: " + email.value());
    }
}
