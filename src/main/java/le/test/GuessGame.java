package le.test;

import java.util.Random;

public class GuessGame {
    private int number = 0;

    GuessGame() {
        this.number = new Random().nextInt(new Random().nextInt(1000));
    }

    public int guess(int guess) {
        if (guess == number)
            return 0;
        if (guess > number)
            return -1;

        return 1;

    }
}
