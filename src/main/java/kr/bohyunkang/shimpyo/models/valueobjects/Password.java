package kr.bohyunkang.shimpyo.models.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import kr.bohyunkang.shimpyo.exceptions.InvalidPassword;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class Password {
    @Column(name = "encodedPassword")
    private String value;

    public Password() {
    }

    public Password(String value) {
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        Matcher matcher = pattern.matcher(value);

        if (!matcher.find()) {
            throw new InvalidPassword();
        }

        this.value = value;
    }

    public Password(Password password, PasswordEncoder passwordEncoder) {
        this.value = passwordEncoder.encode(password.value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        Password otherPassword = (Password) other;

        return Objects.equals(this.value, otherPassword.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
