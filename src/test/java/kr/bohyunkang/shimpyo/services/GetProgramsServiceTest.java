package kr.bohyunkang.shimpyo.services;

import kr.bohyunkang.shimpyo.models.Program;
import kr.bohyunkang.shimpyo.repositories.ProgramRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class GetProgramsServiceTest {

    @Test
    void list() {
        ProgramRepository programRepository = mock(ProgramRepository.class);
        GetProgramsService getProgramsService = new GetProgramsService(programRepository);
        Program program = mock(Program.class);

        given(programRepository.findAll()).willReturn(List.of(program));

        assertThat(getProgramsService.list()).hasSize(1);
    }
}
