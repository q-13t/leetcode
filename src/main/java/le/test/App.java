package le.test;

import java.util.List;

public class App {
    private static Solution solution = new Solution();

    public static void main(String[] args) {

        for (List<Integer> iterable : solution.generate(1)) {
            for (Integer integer : iterable) {
                System.out.print(integer + ", ");
            }
            System.out.println();
        }

    }
}
