package example.example;

import java.time.LocalDateTime;

public class SystemDateTimeProvider implements IDateTimeProvider {
    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
