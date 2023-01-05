package kr.bohyunkang.shimpyo.repositories;

import kr.bohyunkang.shimpyo.models.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgramRepository extends JpaRepository<Program, Long> {
    List<Program> findAll();
}
