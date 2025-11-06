package com.crunchhub.catalogservice.demo;

import com.crunchhub.catalogservice.domain.Game;
import com.crunchhub.catalogservice.domain.GameRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("testdata")
public class GameDataLoader {
    private final GameRepository gameRepository;
    public GameDataLoader(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadData() {
        gameRepository.deleteAll();
        var game1 = Game.of(
                "Test",
                "Test",
                "2nd of September, 2025",
                "MOBA");
        var game2 = Game.of(
                "Test2",
                "Test2",
                "3rd of September, 2025",
                "MMO RPG");

        gameRepository.saveAll(List.of(game1, game2));
    }
}
