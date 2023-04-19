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

    public static int maximumWealth(int[][] accounts) {
        System.gc();
        int maxWealth = Integer.MIN_VALUE, current;
        for (int i = 0; i < accounts.length; i++) {
            current = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                current += accounts[i][j];
            }
            if (maxWealth < current) {
                maxWealth = current;
            }
        }
        System.gc();
        return maxWealth;
    }

    public static int[] twoSum(int[] numbers, int target) {
        System.gc();
        if (numbers == null || numbers.length < 2) {
            return null;
        } else if (numbers[numbers.length - 1] + numbers[numbers.length - 2] == target) {
            return new int[] { numbers.length - 2, numbers.length - 1 };
        } else if (numbers[0] + numbers[1] == target) {
            return new int[] { 0, 1 };
        }
        System.gc();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target && j != i) {
                    System.gc();
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int addition = 0;
        ListNode tmp = new ListNode();
        ListNode head = tmp;
        while (!(l1 == null && l2 == null) || (addition != 0)) {
            int sum = ((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + addition);
            tmp.val = sum % 10;
            addition = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (!(l1 == null && l2 == null) || (addition != 0)) {
                tmp.next = new ListNode();
                tmp = tmp.next;
            }
        }

        return head;
    }

    // Sliding window approach
    public int lengthOfLongestSubstring(String s) {
        int chars[] = new int[128];// [window] each character on it's position(ASCII index) represented as position
                                   // in String
        int right = 0, left = 0, intCharVal = 0; // variables for sliding window
        for (int index = 0; index < s.length(); index++) {
            intCharVal = s.charAt(index);// value of each character as integer
            left = Math.max(left, chars[intCharVal]);// start of substring without repeating characters
            right = Math.max(right, index - left + 1);// end of substring without repeating characters
            chars[intCharVal] = index + 1; // setting last occurrence of each character in string
        }
        return right;
    }

    public double findMedianSortedArrays(int[] numbs1, int[] numbs2) {
        int[] merged = new int[numbs1.length + numbs2.length];
        int i = 0;
        for (; i < numbs1.length; i++) {
            merged[i] = numbs1[i];
        }
        for (int k = 0; i < merged.length; i++, k++) {
            merged[i] = numbs2[k];
        }

        Arrays.sort(merged);

        int middle = merged.length / 2;
        if (merged.length % 2 == 0) {
            return ((double) merged[middle - 1] + (double) merged[middle]) / 2;
        } else {
            return (double) merged[middle];
        }
    }
}