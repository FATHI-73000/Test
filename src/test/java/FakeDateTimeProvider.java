package org.example;

import example.example.IDateTimeProvider;

import java.time.LocalDateTime;

public class FakeDateTimeProvider implements IDateTimeProvider {
    private final LocalDateTime fixedDateTime;

    public FakeDateTimeProvider(LocalDateTime fixedDateTime) {
        this.fixedDateTime = fixedDateTime;
    }

    @Override
    public LocalDateTime now() {
        return fixedDateTime;
    }
}
