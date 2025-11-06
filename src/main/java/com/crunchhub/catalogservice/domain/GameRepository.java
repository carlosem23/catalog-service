package com.crunchhub.catalogservice.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GameRepository extends CrudRepository<Game, Long> {
    Iterable<Game> findAllByCreator(String creator);
    Iterable<Game> findAllByGenre(String genre);
    Optional<Game> findByName(String name);
}
