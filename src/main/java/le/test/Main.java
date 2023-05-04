package le.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SuppressWarnings(value = { "unused" })
public class Main {
    private static Solution solution = new Solution();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
        System.out.println("Time: " + (System.currentTimeMillis() - start));
        System.out.println(solution.wordPattern("abba", "dog cat cat fish"));
        System.out.println(solution.wordPattern("aaaa", "dog cat cat dog"));
    }

    private static int[] generateArrayOfSize(int size, int min, int max) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(min, max + 1);
        }
        return array;
    }
}
