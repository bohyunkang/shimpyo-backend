package kr.bohyunkang.shimpyo.dtos;

public class ProgramDto {
    private Long id;

    private String location;

    private String title;

    private Long price;

    private String address;

    private String category;

    public ProgramDto() {
    }

    public ProgramDto(Long id, String location, String title,
                      Long price, String address, String category) {
        this.id = id;
        this.location = location;
        this.title = title;
        this.price = price;
        this.address = address;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getTitle() {
        return title;
    }

    public Long getPrice() {
        return price;
    }

    public String getAddress() {
        return address;
    }

    public String getCategory() {
        return category;
    }
}
