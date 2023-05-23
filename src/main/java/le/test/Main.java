package le.test;

import java.util.List;
import java.util.Stack;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.text.DecimalFormat;
import java.util.stream.Stream;

import javax.xml.crypto.OctetStreamData;

@SuppressWarnings(value = { "unused" })
public class Main {
    private static Solution solution = new Solution();
    private static long start;

    public static void main(String[] args) {

        List<List<Integer>> rooms = new ArrayList<>();
        // rooms.add(new ArrayList<>());
        // rooms.get(0).add(1);
        // rooms.get(0).add(3);
        // rooms.add(new ArrayList<>());
        // rooms.get(1).add(3);
        // rooms.get(1).add(0);
        // rooms.get(1).add(1);
        // rooms.add(new ArrayList<>());
        // rooms.get(2).add(2);
        // rooms.add(new ArrayList<>());
        // rooms.get(3).add(0);
        long start = System.currentTimeMillis();
        // System.out.println(solution.canVisitAllRooms(rooms));
        System.out.println("\nRuntime: " + (System.currentTimeMillis() - start));
        rooms.clear();
        rooms.add(new ArrayList<>());
        rooms.add(new ArrayList<>());
        rooms.add(new ArrayList<>());
        rooms.add(new ArrayList<>());
        rooms.get(0).addAll(Arrays.asList(1));
        rooms.get(1).addAll(Arrays.asList(2));
        rooms.get(2).addAll(Arrays.asList(3));
        System.out.println(solution.canVisitAllRooms(rooms));
    }

    static int bigSum(int[] arr) {
        System.out.println(arr.length);
        int maxSum = 0;
        for (int i = 0, j = arr.length - 1; i < arr.length / 2 && j >= arr.length / 2; i++, j--) {
            int sum = arr[i] + arr[j];
            maxSum = maxSum > sum ? maxSum : sum;
        }
        return maxSum;
    }

    private static int convertToIntSum(String string) {
        char[] charArray = string.toCharArray();
        int sum = 0;
        for (char c : charArray) {
            sum += (int) c;
        }
        return sum;
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
