package kr.bohyunkang.shimpyo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Location {
    @Column(name = "location")
    public String value;

    public Location() {
    }

    public Location(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return "Location(" + value + ")";
    }

    @Override
    public boolean equals(Object other) {
        return other != null
                && other.getClass() == Location.class
                && value.equals(((Location) other).value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
