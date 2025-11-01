package com.crunchhub.catalogservice;

import com.crunchhub.catalogservice.domain.Game;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class GameValidationTest {
    private static Validator validator;
    @BeforeAll
    static void beforeAll() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void whenAllFieldsCorrectThenValidationSuccessful() {
        var game =  new Game(
                12,
                "Test",
                "Test",
                "September 2nd, 2025",
                "Fantasy"
        );

        Set<ConstraintViolation<Game>> violations = validator.validate(game);
        assertThat(violations).isEmpty();
    }

    @Test
    void whenNameIsEmptyThenValidationFails() {
        var game =  new Game(
                12,
                "",
                "Test",
                "September 2nd, 2025",
                "Fantasy"
        );
        Set<ConstraintViolation<Game>> violations = validator.validate(game);
        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getMessage()).isEqualTo("The name of the game must be defined.");
    }

}
