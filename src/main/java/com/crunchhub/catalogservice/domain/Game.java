package com.crunchhub.catalogservice.domain;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import java.time.Instant;


public record Game(
        @Id
        Long id,

        @NotBlank(message = "The name of the game must be defined.")
        String name,
        @NotBlank(message = "The creator must be defined.")
        String creator,
        @NotBlank(message = "The date of creation must be defined")
        String dateOfCreation,
        @NotBlank(message = "The genre must be defined.")
        String genre,

        Float price,

        @CreatedDate
        Instant createdDate,
        @LastModifiedDate
        Instant lastModifiedDate,

        @Version
        int version
){
    public static Game of(String name, String creator, String dateOfCreation, String genre) {
        return new Game(null, name, creator, dateOfCreation, genre, 4.99f, null, null, 0);
    }
}