package com.example.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GreetingServiceTest {
    private final GreetingService greetingService = new GreetingService();

    @Test
    void greetsProvidedName() {
        assertEquals("Hello, Ada!", greetingService.greet("Ada"));
    }

    @Test
    void usesDefaultNameForBlankInput() {
        assertEquals("Hello, world!", greetingService.greet(" "));
    }

    @Test
    void usesDefaultNameForNullInput() {
        assertEquals("Hello, world!", greetingService.greet(null));
    }
}
