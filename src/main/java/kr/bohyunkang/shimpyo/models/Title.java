package kr.bohyunkang.shimpyo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Title {
    @Column(name = "title")
    public String value;

    public Title() {
    }

    public Title(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return "Title(" + value + ")";
    }

    @Override
    public boolean equals(Object other) {
        return other != null
                && other.getClass() == Title.class
                && value.equals(((Title) other).value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
