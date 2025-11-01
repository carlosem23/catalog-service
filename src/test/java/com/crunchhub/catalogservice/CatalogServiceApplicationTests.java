package com.crunchhub.catalogservice;

import com.crunchhub.catalogservice.domain.Game;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class CatalogServiceApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void whenPostRequestThenGameCreated() {
        var expectedGame =  new Game(
                12,
                "Test",
                "Test",
                "September 2nd, 2025",
                "Fantasy"
        );

        webTestClient.post()
                .uri("/games")
                .bodyValue(expectedGame)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Game.class)
                .value(actualGame -> {
                   assertThat(actualGame.name()).isNotNull();
                   assertThat(actualGame.creator()).isEqualTo(expectedGame.creator());
                });
    }

}
