package le.test;

import java.util.Random;

@SuppressWarnings(value = { "unused" })
public class App {
    private static Solution solution = new Solution();

    public static void main(String[] args) {
        RandomizedSet rSet = new RandomizedSet();
        System.out.println(rSet.insert(1));
        System.out.println(rSet.remove(2));
        System.out.println(rSet.insert(2));
        System.out.println(rSet.getRandom());
        System.out.println(rSet.remove(1));
        System.out.println(rSet.insert(2));
        System.out.println(rSet.getRandom());
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
