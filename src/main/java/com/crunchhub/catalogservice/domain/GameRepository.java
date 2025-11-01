package com.crunchhub.catalogservice.domain;

import java.util.Optional;

public interface GameRepository {
    Iterable<Game> findAll();
    Optional<Game> findById(int id);
    Game save(Game game);
    boolean existsById(int id);
    void deleteById(int id);
}
