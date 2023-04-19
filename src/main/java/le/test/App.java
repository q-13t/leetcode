package le.test;

public class App {
    public static void main(String[] args) {
        Solution sol = new Solution();
        // int[] numbs1 = { 2, 4, 6, 8, 9 }, numbs2 = { 1, 3, 5, 7, 10 };
        int[] numbs1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
                22 }, numbs2 = { 0, 6 };
        System.out.println(sol.findMedianSortedArrays(numbs1, numbs2));
    }
}
