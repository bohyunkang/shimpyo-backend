package kr.bohyunkang.shimpyo.models.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class PhoneNumber {
    @Column(name = "phone_number")
    public String value;

    public PhoneNumber() {
    }

    public PhoneNumber(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return "PhoneNumber(" + value + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        PhoneNumber otherPhoneNumber = (PhoneNumber) other;

        return Objects.equals(value, otherPhoneNumber.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
