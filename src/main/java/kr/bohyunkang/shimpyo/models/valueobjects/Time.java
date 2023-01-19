package kr.bohyunkang.shimpyo.models.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Time {
    public String value;

    public Time() {
    }

    public Time(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return "Time(" + value + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        Time otherTime = (Time) other;

        return Objects.equals(value, otherTime.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
