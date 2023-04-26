package le.test;

public class App {
    private static Solution solution = new Solution();

    public static void main(String[] args) {
        for (Integer integer : solution.getRow(33)) {
            System.out.print(integer + ", ");
        }

    }
}
