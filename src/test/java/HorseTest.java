import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class HorseTest {
    private Horse horse;

    @Test
    void constructorNullTest() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            horse = new Horse(null, 2, 4);
        });
        Assertions.assertEquals("Name cannot be null.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t\t", "\n\n"})
    void constructorBlankAndEmpty(String name) {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            horse = new Horse(name, 8, 9);
        });
        Assertions.assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @Test
    void negativeSpeed() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            horse = new Horse("Name", -1, 4);
        });
        Assertions.assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @Test
    void negativeDistance() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            horse = new Horse("Name", 1, -4);
        });
        Assertions.assertEquals("Distance cannot be negative.", exception.getMessage());
    }

    @Test
    void getName() {
        horse = new Horse("Ronan", 2, 5);
        Assertions.assertEquals("Ronan", horse.getName());
    }

    @Test
    void getSpeed() {
        horse = new Horse("Ronan", 2, 5);
        Assertions.assertEquals(2, horse.getSpeed());
    }

    @Test
    void getDistance() {
        horse = new Horse("Ronan", 2, 5);
        Assertions.assertEquals(5, horse.getDistance());
    }

    @Test
    void moveTest() {
        horse = new Horse("Ronan", 2, 5);
//        double result = horse.getDistance() + horse.getSpeed() * Horse.getRandomDouble(0.2, 0.9);

        try (MockedStatic<Horse> horses = Mockito.mockStatic(Horse.class)) {
            horse.move();
//            horses.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(result);
            horses.verify(() -> Horse.getRandomDouble(0.2, 0.9));

        }

    }
}