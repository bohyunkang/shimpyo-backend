package kr.bohyunkang.shimpyo.services;

import kr.bohyunkang.shimpyo.dtos.PlaceDto;
import kr.bohyunkang.shimpyo.dtos.ProgramDto;
import kr.bohyunkang.shimpyo.dtos.ProgramsDto;
import kr.bohyunkang.shimpyo.exceptions.PlaceNotFound;
import kr.bohyunkang.shimpyo.models.Place;
import kr.bohyunkang.shimpyo.models.Program;
import kr.bohyunkang.shimpyo.repositories.PlaceRepository;
import kr.bohyunkang.shimpyo.repositories.ProgramRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GetProgramsService {
    private ProgramRepository programRepository;
    private PlaceRepository placeRepository;

    public GetProgramsService(ProgramRepository programRepository,
                              PlaceRepository placeRepository) {
        this.programRepository = programRepository;
        this.placeRepository = placeRepository;
    }

    public ProgramsDto getPrograms() {
        List<Program> programs = programRepository.findAll();


        List<ProgramDto> programDtos = programs.stream()
                .map(program -> {
                    Place place = placeRepository.findById(program.getPlaceId())
                            .orElseThrow(() -> new PlaceNotFound(program.getPlaceId()));

                    return new ProgramDto(
                            program.getId(),
                            program.getTitle().value(),
                            program.getPrice().value(),
                            program.getImageUrl().value(),
                            program.getCategory().value(),
                            new PlaceDto(
                                    place.getId(),
                                    place.getName().value(),
                                    place.getAddress().value(),
                                    place.getPhoneNumber().value(),
                                    place.getPickUp().value(),
                                    place.getDescription().value(),
                                    place.getCheckInStart().value(),
                                    place.getCheckInEnd().value(),
                                    place.getCheckOut().value()
                            ),
                            program.getOffers().stream().map(String::new).collect(Collectors.toSet()),
                            program.getRules().stream().map(String::new).collect(Collectors.toList()),
                            program.getCreatedAt(),
                            program.getUpdatedAt()
                    );
                }).collect(Collectors.toList());

        return new ProgramsDto(programDtos);
    }
}
