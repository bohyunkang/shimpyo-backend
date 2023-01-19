package kr.bohyunkang.shimpyo.controllers;

import kr.bohyunkang.shimpyo.dtos.ProgramDto;
import kr.bohyunkang.shimpyo.dtos.ProgramsDto;
import kr.bohyunkang.shimpyo.services.GetProgramService;
import kr.bohyunkang.shimpyo.services.GetProgramsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/programs")
public class ProgramController {
    private GetProgramsService getProgramsService;
    private GetProgramService getProgramService;

    public ProgramController(GetProgramsService getProgramsService,
                             GetProgramService getProgramService) {
        this.getProgramsService = getProgramsService;
        this.getProgramService = getProgramService;
    }

    @GetMapping
    public ProgramsDto list() {
        return getProgramsService.getPrograms();
    }

    @GetMapping("/{id}")
    public ProgramDto program(
            @PathVariable("id") Long id
    ) {
        return getProgramService.getProgram(id);
    }
}
