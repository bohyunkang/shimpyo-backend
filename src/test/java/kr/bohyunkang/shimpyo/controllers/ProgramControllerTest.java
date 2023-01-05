package kr.bohyunkang.shimpyo.controllers;

import kr.bohyunkang.shimpyo.models.Program;
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
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProgramController.class)
@ActiveProfiles("test")
class ProgramControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetProgramsService getProgramsService;

    @Test
    void list() throws Exception {
        Program program = mock(Program.class);

        given(getProgramsService.list()).willReturn(List.of(program));

        mockMvc.perform(MockMvcRequestBuilders.get("/programs"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"programs\":[")
                ));

        verify(getProgramsService).list();
    }
}
