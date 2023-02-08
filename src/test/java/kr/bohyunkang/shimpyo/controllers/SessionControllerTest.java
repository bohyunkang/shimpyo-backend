package kr.bohyunkang.shimpyo.controllers;

import kr.bohyunkang.shimpyo.exceptions.LoginFailed;
import kr.bohyunkang.shimpyo.models.User;
import kr.bohyunkang.shimpyo.models.valueobjects.Email;
import kr.bohyunkang.shimpyo.models.valueobjects.Password;
import kr.bohyunkang.shimpyo.services.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SessionController.class)
@ActiveProfiles("test")
class SessionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoginService loginService;

    @Test
    void loginSuccess() throws Exception {
        Email email = new Email("healing@shimpyo.com");
        Password password = new Password("Healing1234!");

        User user = User.fake(email);

        given(loginService.login(email, password)).willReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/session")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{" +
                                "\"email\":\"healing@shimpyo.com\"," +
                                "\"password\":\"Healing1234!\"" +
                                "}"))
                .andExpect(status().isCreated())
                .andExpect(content().string(
                        containsString("nickname")
                ));
    }

    @Test
    void loginFailed() throws Exception {
        given(loginService.login(any(), any()))
                .willThrow(new LoginFailed());

        mockMvc.perform(MockMvcRequestBuilders.post("/session")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{" +
                                "\"email\":\"healing@shimpyo.com\"," +
                                "\"password\":\"Testing1234!\"" +
                                "}"))
                .andExpect(status().isBadRequest());
    }
}
