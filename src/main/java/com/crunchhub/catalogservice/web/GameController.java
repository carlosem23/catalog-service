package com.crunchhub.catalogservice.web;

import com.crunchhub.catalogservice.domain.Game;
import com.crunchhub.catalogservice.domain.GameService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("games")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public Iterable<Game> getGames() {
        return gameService.findAll();
    }

    @GetMapping("{id}")
    public Game getGame(@PathVariable int id) {
        return gameService.viewGameDetails(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGame(@Valid @RequestBody Game game) {
        return gameService.addGameToCatalog(game);
    }

    @PutMapping("{id}")
    public Game updateGame(@PathVariable int id, @Valid @RequestBody Game game) {
        return gameService.editGameDetails(id, game);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable int id) {
        gameService.removeGameFromCatalog(id);
    }
}
