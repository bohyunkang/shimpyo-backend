package kr.bohyunkang.shimpyo.models.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import kr.bohyunkang.shimpyo.exceptions.InvalidEmail;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class Email {
    @Column(name = "email")
    public String value;

    public Email() {
    }

    public Email(String value) {
        Pattern pattern = Pattern.compile("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");
        Matcher matcher = pattern.matcher(value);

        if (!matcher.find()) {
            throw new InvalidEmail();
        }

        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return "Email(" + value + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        Email otherEmail = (Email) other;

        return Objects.equals(value, otherEmail.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
