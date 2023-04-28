package le.test;

import java.util.Random;

public class App {
    private static Solution solution = new Solution();

    public static void main(String[] args) {

        System.out.println(solution.numSimilarGroups(new String[] { "tars", "rats", "arts", "star" }) == 2);
        System.out.println(solution.numSimilarGroups(new String[] { "omv", "ovm" }) == 1);
        System.out.println(solution.numSimilarGroups(new String[] { "abc", "abc" }) == 1);
        System.out.println(solution.numSimilarGroups(new String[] { "kccomwcgcs", "socgcmcwkc", "sgckwcmcoc", "coswcmcgkc", "cowkccmsgc", "cosgmccwkc",
                "sgmkwcccoc", "coswmccgkc", "kowcccmsgc", "kgcomwcccs" }) == 5);
        System.out.println(solution.numSimilarGroups(new String[] { "ajdidocuyh", "djdyaohuic", "ddjyhuicoa", "djdhaoyuic", "ddjoiuycha", "ddhoiuycja",
                "ajdydocuih", "ddjiouycha", "ajdydohuic", "ddjyouicha" }) == 2);
    }

    @SuppressWarnings(value = { "unused" })
    private static int[] generateArrayOfSize(int size, int min, int max) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(min, max + 1);
        }
        return array;
    }
}
