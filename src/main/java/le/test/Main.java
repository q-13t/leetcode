package le.test;

import java.util.Random;

@SuppressWarnings(value = { "unused" })
public class Main {
    private static Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(solution.canCompleteCircuit(new int[] { 3, 1, 1 }, new int[] { 1, 2, 2 }));
        System.out.println(solution.canCompleteCircuit(new int[] { 1, 2, 3, 4, 5 }, new int[] { 3, 4, 5, 1, 2 }));
        System.out.println(solution.canCompleteCircuit(new int[] { 2, 3, 4 }, new int[] { 3, 4, 3 }));
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
