package le.test;

import java.util.Arrays;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {

    public static int romanToInt(String s) {
        int number = 0;
        char previous = 'a';
        for (char iterable : s.toCharArray()) {
            switch (iterable) {
                case 'I': {
                    number += 1;
                    break;
                }
                case 'V': {
                    number += 5;
                    if (previous == 'I') {
                        number -= 2;
                    }
                    break;
                }
                case 'X': {
                    number += 10;
                    if (previous == 'I') {
                        number -= 2;
                    }
                    break;
                }
                case 'L': {
                    number += 50;
                    if (previous == 'X') {
                        number -= 20;
                    }
                    break;
                }
                case 'C': {
                    number += 100;
                    if (previous == 'X') {
                        number -= 20;
                    }
                    break;
                }
                case 'D': {
                    number += 500;
                    if (previous == 'C') {
                        number -= 200;
                    }
                    break;
                }
                case 'M': {
                    number += 1000;
                    if (previous == 'C') {
                        number -= 200;
                    }
                    break;
                }

            }
            previous = iterable;
        }
        return number;
    }

    public static String longestCommonPrefix(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }

        StringBuilder answer = new StringBuilder();
        try {
            for (int i = 0; i < 200; i++) {
                char current = strings[0].charAt(i);
                for (int j = 0; j < strings.length; j++) {
                    if (current != strings[j].charAt(i)) {
                        return answer.toString();
                    }
                }
                answer.append(current);
            }
        } catch (Exception e) {
            return answer.toString();
        }
        return answer.toString();
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode reversed = reverseListNode(middleNode(head).next);
        while (reversed != null) {
            if (head.val != reversed.val) {
                return false;
            }
            head = head.next;
            reversed = reversed.next;
        }
        return true;
    }

    private static ListNode reverseListNode(ListNode node) {
        ListNode current = node;
        ListNode previous = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];// array of alphabet length with all 0
        for (char c : magazine.toCharArray()) {// count resources
            freq[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {// evaluate resources
            if (--freq[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static List<String> fizzBuzz(int n) {
        String[] answer = new String[n];
        for (int i = n; i > 0; i--) {
            if (i % 15 == 0) {
                answer[i - 1] = "FizzBuzz";
                continue;
            } else if (i % 3 == 0) {
                answer[i - 1] = "Fizz";
                continue;
            } else if (i % 5 == 0) {
                answer[i - 1] = "Buzz";
                continue;
            } else {
                answer[i - 1] = String.valueOf(i);
                continue;
            }
        }
        return Arrays.asList(answer);
    }

    public static ListNode middleNode(ListNode node) {
        ListNode fast = node;
        while (fast != null && fast.next != null) {

            node = node.next;
            fast = fast.next.next;
        }
        return node;
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] strength = new int[mat.length];
        for (int i = 0; i < strength.length; i++) {
            if (mat[i][mat[i].length - 1] == 1) {
                strength[i] = mat[i].length;
            } else if (mat[i][0] == 0) {
                strength[i] = 0;
            } else {
                for (int j = 0; j < mat[i].length; j++) {
                    if (mat[i][j] == 1) {
                        strength[i] += 1;
                    }
                }
            }
        }
        int[] result = new int[k];
        int index = 0;

        for (int i = 0; i < k; i++) {
            index = 0;
            for (int j = 1; j < strength.length; j++) {
                if (strength[index] > strength[j]) {
                    index = j;
                }
            }
            result[i] = index;
            strength[index] = Integer.MAX_VALUE;
        }
        return result;
    }

    public static int numberOfSteps(int num) {
        int steps = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                steps++;
                num = num % 2;
                continue;
            }
            steps++;
            num = num - 1;
        }
        return steps;
    }
}
