package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {

    @Test
    void testThrowExceptionWithNull() {
        ExceptionThrower thrower = new ExceptionThrower();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException(null);
        });

        assertEquals("Input cannot be null", exception.getMessage());
    }

    @Test
    void testThrowExceptionWithValidInput() {
        ExceptionThrower thrower = new ExceptionThrower();

        assertDoesNotThrow(() -> {
            thrower.throwException("Hello");
        });
    }
}
