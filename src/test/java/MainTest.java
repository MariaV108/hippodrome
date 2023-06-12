import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @Disabled
    void main() {
        assertTimeout(Duration.ofMillis(22000), () -> Main.main(null));
    }
}