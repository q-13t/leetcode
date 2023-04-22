package le.test;

public class App {
    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int[] numbs = { 1 };
        int target = 1;
        System.out.println(solution.searchInsert(numbs, target));
    }
}
