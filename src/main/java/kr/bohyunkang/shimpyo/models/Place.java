package kr.bohyunkang.shimpyo.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import kr.bohyunkang.shimpyo.models.valueobjects.Address;
import kr.bohyunkang.shimpyo.models.valueobjects.Description;
import kr.bohyunkang.shimpyo.models.valueobjects.Name;
import kr.bohyunkang.shimpyo.models.valueobjects.PhoneNumber;
import kr.bohyunkang.shimpyo.models.valueobjects.PickUp;
import kr.bohyunkang.shimpyo.models.valueobjects.Time;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class Place {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Name name;

    @Embedded
    private Address address;

    @Embedded
    private PhoneNumber phoneNumber;

    @Embedded
    private PickUp pickUp;

    @Embedded
    private Description description;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "check_in_start"))
    private Time checkInStart;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "check_in_end"))
    private Time checkInEnd;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "check_out"))
    private Time checkOut;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Place() {
    }

    public Place(Name name, Address address, PhoneNumber phoneNumber, PickUp pickUp,
                 Description description, Time checkInStart, Time checkInEnd, Time checkOut) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.pickUp = pickUp;
        this.description = description;
        this.checkInStart = checkInStart;
        this.checkInEnd = checkInEnd;
        this.checkOut = checkOut;
    }

    public Long getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public PickUp getPickUp() {
        return pickUp;
    }

    public Description getDescription() {
        return description;
    }

    public Time getCheckInStart() {
        return checkInStart;
    }

    public Time getCheckInEnd() {
        return checkInEnd;
    }

    public Time getCheckOut() {
        return checkOut;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public static Place fake() {
        Name name = new Name("?????????");
        Address address = new Address("???????????? ????????? ????????? ???????????? 145");
        PhoneNumber phoneNumber = new PhoneNumber("01012345678");
        PickUp pickUp = new PickUp(false);
        Description description = new Description("?????? ????????? ?????? ???????????? ?????? ????????? ???????????? ????????? ???????????????. ?????? ??? ???????????? ???????????? ??????????????? ????????? ????????? ?????? ??? ?????? ????????? ????????? ?????? ?????? ??? ?????? ???...");
        Time checkInStart = new Time("13");
        Time checkInEnd = new Time("24");
        Time checkOut = new Time("12");

        return new Place(name, address, phoneNumber, pickUp, description, checkInStart, checkInEnd, checkOut);
    }
}
