package kr.bohyunkang.shimpyo.models.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class ImageUrl {
    @Column(name = "imageUrl")
    public String value;

    public ImageUrl() {
    }

    public ImageUrl(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return "ImageUrl(" + value + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        ImageUrl otherImageUrl = (ImageUrl) other;

        return Objects.equals(value, otherImageUrl.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
