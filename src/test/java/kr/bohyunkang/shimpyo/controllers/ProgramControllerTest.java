package kr.bohyunkang.shimpyo.controllers;

import kr.bohyunkang.shimpyo.config.EnableMockMvc;
import kr.bohyunkang.shimpyo.dtos.ProgramDto;
import kr.bohyunkang.shimpyo.dtos.ProgramsDto;
import kr.bohyunkang.shimpyo.services.GetProgramService;
import kr.bohyunkang.shimpyo.services.GetProgramsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProgramController.class)
@ActiveProfiles("test")
@EnableMockMvc
class ProgramControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetProgramsService getProgramsService;

    @MockBean
    private GetProgramService getProgramService;

    @Test
    void list() throws Exception {
        given(getProgramsService.getPrograms())
                .willReturn(new ProgramsDto(List.of(ProgramDto.fake())));

        mockMvc.perform(MockMvcRequestBuilders.get("/programs"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"programs\":[")
                ));

        verify(getProgramsService).getPrograms();
    }

    @Test
    void program() throws Exception {
        given(getProgramService.getProgram(any()))
                .willReturn(ProgramDto.fake());

        mockMvc.perform(MockMvcRequestBuilders.get("/programs/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("따뜻한 위로의 차담, 만덕길 옛길 산책")
                ));
    }
}
