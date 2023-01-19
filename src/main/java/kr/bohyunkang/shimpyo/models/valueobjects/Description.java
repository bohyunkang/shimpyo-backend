package kr.bohyunkang.shimpyo.models.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Description {
    @Column(name = "description")
    public String value;

    public Description() {
    }

    public Description(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return "Description(" + value + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        Description otherDescription = (Description) other;

        return Objects.equals(value, otherDescription.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
