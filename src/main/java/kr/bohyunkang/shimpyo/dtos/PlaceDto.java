package kr.bohyunkang.shimpyo.dtos;

public class PlaceDto {
    private Long id;

    private String name;

    private String address;

    private String phoneNumber;

    private boolean pickUp;

    private String description;

    private String checkInStart;

    private String checkInEnd;

    private String checkOut;

    public PlaceDto() {
    }

    public PlaceDto(Long id, String name, String address, String phoneNumber, boolean pickUp, String description, String checkInStart, String checkInEnd, String checkOut) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isPickUp() {
        return pickUp;
    }

    public String getDescription() {
        return description;
    }

    public String getCheckInStart() {
        return checkInStart;
    }

    public String getCheckInEnd() {
        return checkInEnd;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public static PlaceDto fake() {
        return new PlaceDto(
                1L,
                "백련사",
                "전라남도 강진군 도암면 백련사길 145",
                "01012345678",
                false,
                "전남 강진에 있는 백련사는 차와 동백이 아름다운 사찰로 유명합니다. 고려 말 민간신앙 결사체인 백련결사를 맺었던 이곳은 조선 말 다산 정약용 선생이 유배 왔을 때 아암 혜...",
                "13:00",
                "24:00",
                "12:00"
        );
    }
}
