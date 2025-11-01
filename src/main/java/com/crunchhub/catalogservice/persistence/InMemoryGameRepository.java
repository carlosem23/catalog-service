package com.crunchhub.catalogservice.persistence;

import com.crunchhub.catalogservice.domain.Game;
import com.crunchhub.catalogservice.domain.GameRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryGameRepository implements GameRepository {
    private final static Map<Integer, Game> games = new ConcurrentHashMap<>();

    @Override
    public Iterable<Game> findAll() {
        return games.values();
    }

    @Override
    public Optional<Game> findById(int id) {
        return Optional.ofNullable(games.get(id));
    }

    @Override
    public Game save(Game game) {
        games.put(game.id(), game);
        return game;
    }

    @Override
    public boolean existsById(int id) {
        return games.containsKey(id);
    }

    @Override
    public void deleteById(int id) {
        games.remove(id);
    }

}
