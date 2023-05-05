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
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println("Runtime: " + (System.currentTimeMillis() - start) + " ms");
        System.out.println(solution.isAnagram("rat", "car"));
        System.out.println(solution.isAnagram("ab", "a"));

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
