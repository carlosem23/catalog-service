package com.crunchhub.catalogservice.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Game(
        @NotNull(message = "The id must be defined.")
        @Min(0)
        @Max(600)
        int id,

        @NotBlank(message = "The name of the game must be defined.")
        String name,
        @NotBlank(message = "The creator must be defined.")
        String creator,
        @NotBlank(message = "The date of creation must be defined")
        String dateOfCreation,
        @NotBlank(message = "The genre must be defined.")
        String genre
){}