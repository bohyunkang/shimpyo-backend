package kr.bohyunkang.shimpyo.services;

import kr.bohyunkang.shimpyo.models.Program;
import kr.bohyunkang.shimpyo.repositories.ProgramRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GetProgramsService {
    private ProgramRepository programRepository;

    public GetProgramsService(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    public List<Program> list() {
        return programRepository.findAll();
    }
}
