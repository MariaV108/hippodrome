import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.apache.log4j.Logger;

import static java.util.Objects.isNull;

public class Hippodrome {
    private static final Logger LOGGERHIPPODROME = Logger.getLogger(Hippodrome.class.getName());

    private final List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        if (isNull(horses)) {
            LOGGERHIPPODROME.error("Horses list is null");
            throw new IllegalArgumentException("Horses cannot be null.");
        } else if (horses.isEmpty()) {
            LOGGERHIPPODROME.error("Horses list is empty");
            throw new IllegalArgumentException("Horses cannot be empty.");
        }

        this.horses = horses;
        LOGGERHIPPODROME.debug("Создание Hippodrome, лошадей " + "[" + horses.size() + "]");

    }

    public List<Horse> getHorses() {
        return Collections.unmodifiableList(horses);
    }

    public void move() {
        horses.forEach(Horse::move);
    }

    public Horse getWinner() {
        return horses.stream()
                .max(Comparator.comparing(Horse::getDistance))
                .get();
    }
}
