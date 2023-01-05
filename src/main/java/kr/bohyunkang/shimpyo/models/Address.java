package kr.bohyunkang.shimpyo.models;

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
        return other != null
                && other.getClass() == Address.class
                && value.equals(((Address) other).value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
