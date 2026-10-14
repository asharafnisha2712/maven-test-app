package com.example.app;

public final class GreetingService {
    public String greet(String name) {
        if (name == null || name.isBlank()) {
            name = "world";
        }
        return "Hello, " + name + "!";
    }
}
