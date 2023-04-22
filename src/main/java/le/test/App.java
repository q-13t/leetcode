package le.test;

public class App {
    private static Solution solution = new Solution();

    public static void main(String[] args) {
        String text = "luffy is still joyboy";
        System.out.println(solution.lengthOfLastWord(text));
    }
}
