package com.crunchhub.catalogservice.domain;

public class GameAlreadyExistsException extends RuntimeException {
    public GameAlreadyExistsException(int id) {
        super("Game with id " + id + " already exists");
    }
}
