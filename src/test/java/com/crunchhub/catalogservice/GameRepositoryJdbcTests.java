package com.crunchhub.catalogservice;

import com.crunchhub.catalogservice.config.DataConfig;
import com.crunchhub.catalogservice.domain.Game;
import com.crunchhub.catalogservice.domain.GameRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
@Import(DataConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("integration")
public class GameRepositoryJdbcTests {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private JdbcAggregateTemplate jdbcAggregateTemplate;

    @Test
    void findGameByNameWhenExisting() {
        var gameName = "Cats eating cookies";
        var game = Game.of(gameName, "Test", "3rd of November", "Action");
        jdbcAggregateTemplate.insert(game);
        Optional<Game> actualGame =  gameRepository.findByName(gameName);

        assertThat(actualGame).isPresent();
        assertThat(actualGame.get().name()).isEqualTo(game.name());
    }
}
