package com.crunchhub.catalogservice;

import com.crunchhub.catalogservice.domain.GameNotFoundException;
import com.crunchhub.catalogservice.domain.GameService;
import com.crunchhub.catalogservice.web.GameController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GameController.class)
public class GameControllerMvcTests {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private GameService gameService;

    @Test
    void whenGetGameNotExistingThenReturn404() throws Exception {
        int id = 12345;
        given(gameService.viewGameDetails(id)).willThrow(GameNotFoundException.class);

        mockMvc.perform(get("/games/" + id))
                .andExpect(status().isNotFound());
    }
}
