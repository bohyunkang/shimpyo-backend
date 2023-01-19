package kr.bohyunkang.shimpyo.dtos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class ProgramDto {
    private Long id;
    private String title;
    private Long price;
    private String imageUrl;
    private String category;
    private PlaceDto place;
    private Set<String> offers;
    private List<String> rules;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProgramDto() {
    }

    public ProgramDto(Long id, String title, Long price, String imageUrl, String category, PlaceDto place, Set<String> offers, List<String> rules, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.imageUrl = imageUrl;
        this.category = category;
        this.place = place;
        this.offers = offers;
        this.rules = rules;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Long getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public PlaceDto getPlace() {
        return place;
    }

    public Set<String> getOffers() {
        return offers;
    }

    public List<String> getRules() {
        return rules;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public static ProgramDto fake() {
        return new ProgramDto(
                1L,
                "따뜻한 위로의 차담, 만덕길 옛길 산책",
                70000L,
                "http://shimpyo.bohyunkang.kr/7.png",
                "TEMPLE",
                PlaceDto.fake(),
                Set.of("주차가능", "수련복", "사찰음식", "일출", "다도", "연등", "카페테리아", "명상"),
                List.of(
                        "여름에 소매 없는 옷과 무릎 위 짧은 바지는 삼가주세요.",
                        "수건, 칫솔 등 개인 세면도구는 각자 준비하셔야 합니다.",
                        "운동화 또는 등산화를 꼭 준비하세요.",
                        "미성년자는 보호자나 인솔 교사의 동반 시에만 참가가 가능합니다."
                ),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
