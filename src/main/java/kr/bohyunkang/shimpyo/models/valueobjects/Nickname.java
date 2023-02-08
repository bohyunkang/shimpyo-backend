package kr.bohyunkang.shimpyo.models.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import kr.bohyunkang.shimpyo.exceptions.InvalidNickname;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class Nickname {
    @Column(name = "nickname")
    public String value;

    public Nickname() {
    }

    public Nickname(String value) {
        Pattern pattern = Pattern.compile("^.{3,8}$");
        Matcher matcher = pattern.matcher(value);

        if (!matcher.find()) {
            throw new InvalidNickname();
        }

        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return "Nickname(" + value + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        Nickname otherNickname = (Nickname) other;

        return Objects.equals(value, otherNickname.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
