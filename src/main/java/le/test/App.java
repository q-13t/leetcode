package le.test;

public class App {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 },
                { 1, 1, 1, 1, 1 } };

        int k = 3;
        for (int iterable : Solution.kWeakestRows(matrix, k)) {
            System.out.println(iterable);
        }
    }
}
