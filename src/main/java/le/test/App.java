package le.test;

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String text = "babbab";
        // StringBuilder sb = new StringBuilder(text);
        // System.out.println(text.contains(sb.replace(0, sb.length(), sb.substring(0,
        // sb.length())).reverse()));
        System.out.println(solution.longestPalindrome(text));
    }
}
