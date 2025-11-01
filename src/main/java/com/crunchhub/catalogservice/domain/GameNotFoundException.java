package com.crunchhub.catalogservice.domain;

public class GameNotFoundException extends RuntimeException {
    public GameNotFoundException(int id) {
        super("Game with id " + id + " not found");
    }
}
