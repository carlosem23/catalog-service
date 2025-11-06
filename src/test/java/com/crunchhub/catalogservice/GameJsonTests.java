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
        var game = Game.of("Cats eating cookies", "Test", "2rd of November", "Fantasy");
        var jsonContent = json.write(game);
        assertThat(jsonContent).extractingJsonPathNumberValue("@.id").isNull();
        assertThat(jsonContent).extractingJsonPathStringValue("@.name").isEqualTo("Cats eating cookies");
        assertThat(jsonContent).extractingJsonPathStringValue("@.creator").isEqualTo("Test");
        assertThat(jsonContent).extractingJsonPathStringValue("@.dateOfCreation").isEqualTo("2rd of November");
        assertThat(jsonContent).extractingJsonPathStringValue("@.genre").isEqualTo("Fantasy");
    }

    @Test
    void testDeserialize() throws Exception {
        var game = Game.of("Cats eating cookies", "Test", "2rd of November", "Fantasy");

        var jsonContent =
             """
             {
             "id": null,
             "name": "Cats eating cookies",
             "creator": "Test",
             "dateOfCreation": "2rd of November",
             "genre": "Fantasy",
             "createdDate": null,
             "lastModifiedDate": null
             }
             """;
        assertThat(json.parse(jsonContent)).usingRecursiveComparison().isEqualTo(game);
    }
}
