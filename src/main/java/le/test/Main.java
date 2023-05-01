package le.test;

import java.util.Random;

@SuppressWarnings(value = { "unused" })
public class Main {
    private static Solution solution = new Solution();

    public static void main(String[] args) {
        for (Integer integer : solution.twoSumII(new int[] { 2, 7, 11, 15 }, 9)) {
            System.out.print(integer + ", ");
        }
        System.out.println();
        for (Integer integer : solution.twoSumII(new int[] { 2, 3, 4 }, 6)) {
            System.out.print(integer + ", ");
        }
        System.out.println();
        for (Integer integer : solution.twoSumII(new int[] { -1, 0 }, -1)) {
            System.out.print(integer + ", ");
        }
        System.out.println();
        for (Integer integer : solution.twoSumII(new int[] { -3, 3, 4, 90 }, 0)) {
            System.out.print(integer + ", ");
        }

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
