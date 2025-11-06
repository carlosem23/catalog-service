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
        var game = Game.of("Cats eating cookies", "Test", "2rd of November", "Action");


        Set<ConstraintViolation<Game>> violations = validator.validate(game);
        assertThat(violations).isEmpty();
    }

    @Test
    void whenNameIsEmptyThenValidationFails() {
        var game = Game.of("Cats eating cookies", "Test", "2rd of November", "Action");

        Set<ConstraintViolation<Game>> violations = validator.validate(game);
        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getMessage()).isEqualTo("The name of the game must be defined.");
    }

}
