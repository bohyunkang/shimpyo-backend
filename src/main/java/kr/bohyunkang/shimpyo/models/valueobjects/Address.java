package kr.bohyunkang.shimpyo.models.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Address {
    @Column(name = "address")
    public String value;

    public Address() {
    }

    public Address(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return "Address(" + value + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        Address otherAddress = (Address) other;

        return Objects.equals(value, otherAddress.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
