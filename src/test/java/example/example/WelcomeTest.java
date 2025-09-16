package example.example;

import example.example.FakeDateTimeProvider;
import example.example.Welcome;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class WelcomeTest {

    @Test
    void testBonjour() {
        FakeDateTimeProvider fake = new FakeDateTimeProvider(LocalDateTime.of(2025, 9, 16, 10, 0));
        Welcome welcome = new Welcome(fake);
        assertEquals("Bonjour", welcome.getMessage());
    }

    @Test
    void testBonApresMidi() {
        FakeDateTimeProvider fake = new FakeDateTimeProvider(LocalDateTime.of(2025, 9, 16, 15, 0));
        Welcome welcome = new Welcome(fake);
        assertEquals("Bon après-midi", welcome.getMessage());
    }

    @Test
    void testBonsoir() {
        FakeDateTimeProvider fake = new FakeDateTimeProvider(LocalDateTime.of(2025, 9, 16, 20, 0));
        Welcome welcome = new Welcome(fake);
        assertEquals("Bonsoir", welcome.getMessage());
    }

    @Test
    void testBonWeekEndVendrediSoir() {
        FakeDateTimeProvider fake = new FakeDateTimeProvider(LocalDateTime.of(2025, 9, 19, 19, 0));
        Welcome welcome = new Welcome(fake);
        assertEquals("Bon week-end", welcome.getMessage());
    }
}
