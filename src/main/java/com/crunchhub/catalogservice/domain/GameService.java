package com.crunchhub.catalogservice.domain;

import org.springframework.stereotype.Service;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Iterable<Game> findAll() {
        return gameRepository.findAll();
    }

    public Game viewGameDetails(int id) {
        return gameRepository.findById(id).orElseThrow(
                () -> new GameNotFoundException(id)
        );
    }

    public Game addGameToCatalog(Game game) {
        if (gameRepository.existsById(game.id())) {
            throw new GameAlreadyExistsException(game.id());
        }
        return gameRepository.save(game);
    }

    public void removeGameFromCatalog(int id) {
        gameRepository.deleteById(id);
    }

    public Game editGameDetails(int id, Game game) {
        return gameRepository.findById(id).map(
                existingGame -> {
                    var gameToUpdate = new Game(
                            existingGame.id(),
                            game.name(),
                            game.creator(),
                            game.dateOfCreation(),
                            game.genre());
                    return gameRepository.save(gameToUpdate);

                }).orElseGet(() -> addGameToCatalog(game));
    }
}
