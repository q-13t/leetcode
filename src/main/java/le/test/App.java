package le.test;

public class App {
    public static void main(String[] args) {
        int[][] matrix = {
                { 2, 8, 7 },
                { 7, 1, 3 },
                { 1, 9, 5 },
        };
        System.out.println(Solution.maximumWealth(matrix));
    }
}
