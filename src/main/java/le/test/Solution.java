package le.test;

import java.util.Arrays;
import java.util.stream.Stream;

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

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        StringBuilder answer = new StringBuilder();
        try {
            for (int i = 0; i < 200; i++) {
                char current = strs[0].charAt(i);
                for (int j = 0; j < strs.length; j++) {
                    if (current != strs[j].charAt(i)) {
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
        ListNode reversed = reverseListNode(findMiddleListNode(head).next);
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

    public static ListNode findMiddleListNode(ListNode node) {
        ListNode slow = node;
        ListNode fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26]; // a frequency array to store the count of characters

        // collect the frequencies of all characters in magazine
        for (char c : magazine.toCharArray()) {
            freq[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (--freq[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
