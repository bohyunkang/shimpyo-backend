package kr.bohyunkang.shimpyo.repositories;

import kr.bohyunkang.shimpyo.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
