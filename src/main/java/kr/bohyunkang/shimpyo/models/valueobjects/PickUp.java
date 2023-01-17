package kr.bohyunkang.shimpyo.models.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class PickUp {
    @Column(name = "pick_up")
    public boolean value;

    public PickUp() {
    }

    public PickUp(boolean value) {
        this.value = value;
    }

    public boolean value() {
        return value;
    }

    @Override
    public String toString() {
        return "PickUp(" + value + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        PickUp otherPickUp = (PickUp) other;

        return Objects.equals(value, otherPickUp.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
