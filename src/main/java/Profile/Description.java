package main.java.Profile;

import java.util.Objects;

public class Description {
    private String description;

    private Description(String description) {
        this.description = description;
    }

    public static final Description of(String description) {
        return new Description(Objects.requireNonNull(description));
    }

    public String getDescription() {
        return this.description;
    }
}
