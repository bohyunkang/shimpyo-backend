package kr.bohyunkang.shimpyo.controllers;

import kr.bohyunkang.shimpyo.dtos.ProgramDto;
import kr.bohyunkang.shimpyo.dtos.ProgramsDto;
import kr.bohyunkang.shimpyo.models.Program;
import kr.bohyunkang.shimpyo.services.GetProgramsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/programs")
public class ProgramController {
    private GetProgramsService getProgramsService;

    public ProgramController(GetProgramsService getProgramsService) {
        this.getProgramsService = getProgramsService;
    }

    @GetMapping
    public ProgramsDto list() {
        List<Program> programs = getProgramsService.list();

        List<ProgramDto> programDtos = programs.stream()
                .map(program -> program.toDto())
                .collect(Collectors.toList());

        return new ProgramsDto(programDtos);
    }
}
