package kr.bohyunkang.shimpyo.models;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Category {
    TEMPLE("TEMPLE"),
    FARM("FARM"),
    RELAX("RELAX"),
    EXPERIENCE("EXPERIENCE"),
    ONE_DAY("ONE_DAY");

    private static final Map<String, String> CATEGORY_MAP =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(Category::value, Category::name)));

    private String category;

    Category() {
    }

    Category(String category) {
        this.category = category;
    }

    public String value() {
        return category;
    }

    public static Category of(String type) {
        return Category.valueOf(CATEGORY_MAP.get(type));
    }
}
