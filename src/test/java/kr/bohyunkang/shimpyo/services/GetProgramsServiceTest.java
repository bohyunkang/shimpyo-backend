package kr.bohyunkang.shimpyo.services;

import kr.bohyunkang.shimpyo.dtos.ProgramsDto;
import kr.bohyunkang.shimpyo.models.Place;
import kr.bohyunkang.shimpyo.models.Program;
import kr.bohyunkang.shimpyo.repositories.PlaceRepository;
import kr.bohyunkang.shimpyo.repositories.ProgramRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class GetProgramsServiceTest {
    private ProgramRepository programRepository;
    private PlaceRepository placeRepository;
    private GetProgramsService getProgramsService;

    @BeforeEach
    void setup() {
        programRepository = mock(ProgramRepository.class);
        placeRepository = mock(PlaceRepository.class);
        getProgramsService = new GetProgramsService(programRepository, placeRepository);
    }

    @Test
    void list() {
        given(placeRepository.findById(any()))
                .willReturn(Optional.of(Place.fake()));
        given(programRepository.findAll())
                .willReturn(List.of(Program.fake()));

        ProgramsDto programsDto = getProgramsService.getPrograms();

        assertThat(programsDto.getPrograms()).hasSize(1);
    }
}
