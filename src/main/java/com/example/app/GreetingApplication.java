package com.example.app;

public final class GreetingApplication {
    private GreetingApplication() {
    }

    public static void main(String[] args) {
        String name = args.length > 0 ? args[0] : null;
        System.out.println(new GreetingService().greet(name));
    }
}
