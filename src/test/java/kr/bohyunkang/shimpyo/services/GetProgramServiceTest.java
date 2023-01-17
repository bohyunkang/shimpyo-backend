package kr.bohyunkang.shimpyo.services;

import kr.bohyunkang.shimpyo.dtos.ProgramDto;
import kr.bohyunkang.shimpyo.models.Place;
import kr.bohyunkang.shimpyo.models.Program;
import kr.bohyunkang.shimpyo.repositories.PlaceRepository;
import kr.bohyunkang.shimpyo.repositories.ProgramRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class GetProgramServiceTest {
    private ProgramRepository programRepository;
    private PlaceRepository placeRepository;
    private GetProgramService getProgramService;

    @BeforeEach
    void setup() {
        programRepository = mock(ProgramRepository.class);
        placeRepository = mock(PlaceRepository.class);
        getProgramService = new GetProgramService(programRepository, placeRepository);
    }

    @Test
    void program() {
        Long id = 1L;

        given(placeRepository.findById(id))
                .willReturn(Optional.of(Place.fake()));
        given(programRepository.findById(id))
                .willReturn(Optional.of(Program.fake()));

        ProgramDto programDto = getProgramService.getProgram(id);

        assertThat(programDto).isNotNull();
    }
}
