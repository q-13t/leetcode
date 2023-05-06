package le.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SuppressWarnings(value = { "unused" })
public class Main {
    private static Solution solution = new Solution();
    private static long start;

    public static void main(String[] args) {
        start = System.currentTimeMillis();
        System.out.println(solution.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
        System.out.println("Runtime: " + (System.currentTimeMillis() - start) + " ms");
        System.out.println(solution.groupAnagrams(new String[] { "" }));
        System.out.println(solution.groupAnagrams(new String[] { "a" }));
        System.out.println(solution.groupAnagrams(new String[] { "", "" }));
        System.out.println(solution.groupAnagrams(new String[] { "", "b" }));

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
