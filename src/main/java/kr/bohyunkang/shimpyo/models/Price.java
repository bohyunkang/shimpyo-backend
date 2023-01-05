package kr.bohyunkang.shimpyo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Price {
    @Column(name = "price")
    public Long value;

    public Price() {
    }

    public Price(Long value) {
        this.value = value;
    }

    public Long value() {
        return value;
    }

    @Override
    public String toString() {
        return "Price(" + value + ")";
    }

    @Override
    public boolean equals(Object other) {
        return other != null
                && other.getClass() == Price.class
                && value.equals(((Price) other).value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
