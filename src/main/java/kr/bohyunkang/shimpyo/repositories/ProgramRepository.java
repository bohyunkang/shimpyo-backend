package kr.bohyunkang.shimpyo.repositories;

import kr.bohyunkang.shimpyo.models.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<Program, Long> {
}
