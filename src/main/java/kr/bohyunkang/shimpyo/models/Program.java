package kr.bohyunkang.shimpyo.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import kr.bohyunkang.shimpyo.models.enums.Category;
import kr.bohyunkang.shimpyo.models.valueobjects.ImageUrl;
import kr.bohyunkang.shimpyo.models.valueobjects.Price;
import kr.bohyunkang.shimpyo.models.valueobjects.Title;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Program {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Title title;

    @Embedded
    private Price price;

    @Embedded
    private ImageUrl imageUrl;

    @Enumerated(EnumType.STRING)
    private Category category;

    private Long placeId;

    @ElementCollection
    private Set<String> offers = new HashSet<>();

    @ElementCollection
    private List<String> rules = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Program() {
    }

    public Program(Title title, Price price, ImageUrl imageUrl, Category category, Long placeId, Set<String> offers, List<String> rules) {
        this.title = title;
        this.price = price;
        this.imageUrl = imageUrl;
        this.category = category;
        this.placeId = placeId;
        this.offers = offers;
        this.rules = rules;
    }

    public Long getId() {
        return id;
    }

    public Title getTitle() {
        return title;
    }

    public Price getPrice() {
        return price;
    }

    public ImageUrl getImageUrl() {
        return imageUrl;
    }

    public Category getCategory() {
        return category;
    }

    public Long getPlaceId() {
        return placeId;
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

    public static Program fake() {
        Title title = new Title("따뜻한 위로의 차담, 만덕산 옛길 산책");
        Price price = new Price(70000L);
        ImageUrl imageUrl = new ImageUrl("http://shimpyo.bohyunkang.kr/7.png)");
        Category category = Category.TEMPLE;
        Long placeId = 1L;
        Set<String> offers = Set.of("주차가능", "수련복", "사찰음식", "일출", "다도", "연등", "카페테리아", "명상");
        List<String> rules = List.of(
                "여름에 소매 없는 옷과 무릎 위 짧은 바지는 삼가주세요.",
                "수건, 칫솔 등 개인 세면도구는 각자 준비하셔야 합니다.",
                "운동화 또는 등산화를 꼭 준비하세요.",
                "미성년자는 보호자나 인솔 교사의 동반 시에만 참가가 가능합니다."
        );

        return new Program(title, price, imageUrl, category, placeId, offers, rules);
    }
}
