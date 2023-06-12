import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class HippodromeTest {
    private Hippodrome hippodromeHorses;

    @Test
    void constructorNullTest() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            hippodromeHorses = new Hippodrome(null);
        });
        Assertions.assertEquals("Horses cannot be null.", exception.getMessage());
    }

    void constructorEmptyTest() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            hippodromeHorses = new Hippodrome(new ArrayList<>());
        });
        Assertions.assertEquals("Horses cannot be empty.", exception.getMessage());
    }

    @Test
    void getHorses() {
        List<Horse> horses = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            horses.add(new Horse("horse" + i + 1, i, i));
        }
        hippodromeHorses = new Hippodrome(horses);
        Assertions.assertEquals(horses, hippodromeHorses.getHorses());
    }

    @Test
    void move() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            horses.add(mock(Horse.class));
        }
        hippodromeHorses = new Hippodrome(horses);
        hippodromeHorses.move();
//        verify(hippodromeHorses).move();

        for (Horse horse : horses) {
            verify(horse).move();
        }
    }

    @Test
    void getWinner() {
        Horse horse1 = new Horse("1", 4, 7);
        Horse horse2 = new Horse("2", 5, 3);
        Horse horse3 = new Horse("3", 1, 9);
        List<Horse> horses = new ArrayList<>();
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);

        hippodromeHorses = new Hippodrome(horses);

        Assertions.assertEquals(horse3, hippodromeHorses.getWinner());
    }
}