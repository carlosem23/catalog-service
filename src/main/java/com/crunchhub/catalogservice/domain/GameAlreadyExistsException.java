package com.crunchhub.catalogservice.domain;

public class GameAlreadyExistsException extends RuntimeException {
    public GameAlreadyExistsException(Long id) {
        super("Game with id " + id + " already exists");
    }
}
