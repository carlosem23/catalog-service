package com.crunchhub.catalogservice;

import com.crunchhub.catalogservice.domain.Game;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class GameJsonTests {
    @Autowired
    private JacksonTester<Game> json;

    @Test
    void testSerialize() throws Exception {
        var game =  new Game(
                12,
                "Test",
                "Test",
                "September 2nd, 2025",
                "Fantasy"
        );
        var jsonContent = json.write(game);
        assertThat(jsonContent).extractingJsonPathNumberValue("@.id").isEqualTo(12);
        assertThat(jsonContent).extractingJsonPathStringValue("@.name").isEqualTo("Test");
        assertThat(jsonContent).extractingJsonPathStringValue("@.creator").isEqualTo("Test");
        assertThat(jsonContent).extractingJsonPathStringValue("@.dateOfCreation").isEqualTo("September 2nd, 2025");
        assertThat(jsonContent).extractingJsonPathStringValue("@.genre").isEqualTo("Fantasy");
    }

    @Test
    void testDeserialize() throws Exception {
        var game =  new Game(
                12,
                "Test",
                "Test",
                "September 2nd, 2025",
                "Fantasy"
        );
        var jsonContent =
             """
             {
             "id": "12",
             "name": "Test",
             "creator": "Test",
             "dateOfCreation": "September 2nd, 2025",
             "genre": "Fantasy"
             }
             """;
        assertThat(json.parse(jsonContent)).usingRecursiveComparison().isEqualTo(game);
    }
}
