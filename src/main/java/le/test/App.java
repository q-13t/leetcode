package le.test;

public class App {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = Solution.twoSum(nums, target);
        System.out.println(result[0] + "  " + result[1]);
    }
}
