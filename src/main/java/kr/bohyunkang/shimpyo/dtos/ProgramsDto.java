package kr.bohyunkang.shimpyo.dtos;

import java.util.List;

public class ProgramsDto {
    private List<ProgramDto> programs;

    public ProgramsDto(List<ProgramDto> programs) {
        this.programs = programs;
    }

    public List<ProgramDto> getPrograms() {
        return programs;
    }
}
