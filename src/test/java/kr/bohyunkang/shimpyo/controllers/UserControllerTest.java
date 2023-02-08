package kr.bohyunkang.shimpyo.controllers;

import kr.bohyunkang.shimpyo.config.EnableMockMvc;
import kr.bohyunkang.shimpyo.exceptions.AlreadyExistingEmail;
import kr.bohyunkang.shimpyo.exceptions.UserNotFound;
import kr.bohyunkang.shimpyo.models.User;
import kr.bohyunkang.shimpyo.models.valueobjects.Email;
import kr.bohyunkang.shimpyo.services.CountUserService;
import kr.bohyunkang.shimpyo.services.CreateUserService;
import kr.bohyunkang.shimpyo.services.GetUserService;
import kr.bohyunkang.shimpyo.utils.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@ActiveProfiles("test")
@EnableMockMvc
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetUserService getUserService;

    @MockBean
    private CreateUserService createUserService;

    @MockBean
    private CountUserService countUserService;

    @SpyBean
    private JwtUtil jwtUtil;

    private String token;

    @BeforeEach
    void setup() {
        token = jwtUtil.encode("healing@shimpyo.com");
    }

    @Test
    void user() throws Exception {
        given(getUserService.getUser(any()))
                .willReturn(User.fake(new Email("healing@shimpyo.com")));

        mockMvc.perform(MockMvcRequestBuilders.get("/users/me")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("{" +
                                "\"email\":\"healing@shimpyo.com\"," +
                                "\"name\":\"강힐링\"," +
                                "\"nickname\":\"힐링이필요해\"" +
                                "}")
                ));
    }

    @Test
    void userNotFound() throws Exception {
        given(getUserService.getUser(any()))
                .willThrow(new UserNotFound(new Email("healing@shimpyo.com")));

        mockMvc.perform(MockMvcRequestBuilders.get("/users/me")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isNotFound());
    }

    @Test
    void userWithoutAccessToken() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/me"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void userCountWithExistingEmail() throws Exception {
        given(countUserService.countUser(any()))
                .willReturn(1);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/count?email=healing@shimpyo.com"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"count\":1")
                ));
    }

    @Test
    void userCountWithNotExistingEmail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/count?email=healing@shimpyo.com"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"count\":0")
                ));
    }

    @Test
    void register() throws Exception {
        given(createUserService.create(any(), any(), any(), any()))
                .willReturn(User.fake(new Email("healing@shimpyo.com")));

        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{" +
                                "\"email\":\"healing@shimpyo.com\"," +
                                "\"password\":\"Healing1234!\"," +
                                "\"confirmPassword\":\"Healing1234!\"," +
                                "\"name\":\"강힐링\"," +
                                "\"nickname\":\"힐링이필요해\"" +
                                "}"))
                .andExpect(status().isCreated())
                .andExpect(content().string(
                        containsString("\"nickname\":\"힐링이필요해\"")
                ));
    }

    @Test
    void registerWithAlreadyExistingEmail() throws Exception {
        given(getUserService.getUser(any()))
                .willReturn(User.fake(new Email("healing@shimpyo.com")));

        given(createUserService.create(any(), any(), any(), any()))
                .willThrow(new AlreadyExistingEmail(new Email("healing@shimpyo.com")));

        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{" +
                                "\"email\":\"healing@shimpyo.com\"," +
                                "\"password\":\"Healing1234!\"," +
                                "\"confirmPassword\":\"Healing1234!\"," +
                                "\"name\":\"강힐링\"," +
                                "\"nickname\":\"힐링이필요해\"" +
                                "}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void registerWithoutEmail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{" +
                                "\"email\":\"\"," +
                                "\"password\":\"Healing1234!\"," +
                                "\"confirmPassword\":\"Healing1234!\"," +
                                "\"name\":\"강힐링\"," +
                                "\"nickname\":\"힐링이필요해\"" +
                                "}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void registerWithoutPassword() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{" +
                                "\"email\":\"healing@shimpyo.com\"," +
                                "\"password\":\"\"," +
                                "\"confirmPassword\":\"Healing1234!\"," +
                                "\"name\":\"강힐링\"," +
                                "\"nickname\":\"힐링이필요해\"" +
                                "}"))
                .andExpect(status().isBadRequest());
    }
}
