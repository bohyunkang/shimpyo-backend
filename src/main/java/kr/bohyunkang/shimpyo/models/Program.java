package kr.bohyunkang.shimpyo.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import kr.bohyunkang.shimpyo.dtos.ProgramDto;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class Program {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Location location;

    @Embedded
    private Title title;

    @Embedded
    private Price price;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Category category;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Program() {
    }

    public Program(Location location, Title title, Price price, Address address, Category category) {
        this.location = location;
        this.title = title;
        this.price = price;
        this.address = address;
        this.category = category;
    }

    public Location location() {
        return location;
    }

    public Title title() {
        return title;
    }

    public Price price() {
        return price;
    }

    public Address address() {
        return address;
    }

    public Category category() {
        return category;
    }

    public ProgramDto toDto() {
        return new ProgramDto(id, location.value(), title.value(), price.value(), address.value(), category.value());
    }
}
