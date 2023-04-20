package le.test;

import java.util.List;
import java.util.Stack;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

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

    /**
     * Iterates over provided {@code string} in order to find longest palindrome.
     * </p>
     * {@code Time O(n^2)}
     * </p>
     * {@code Space O(n)}
     * 
     * @param string original string
     * @return longest palindromic substring
     */
    public String longestPalindrome(String string) {
        String result = "";
        int length = string.length(), l, m;
        char[] array = string.toCharArray();

        // Iterate over provided String once
        for (int i = 0; i < length; i++) {

            // search for palindrome expanded from string at i (for single letter palindrome case)
            l = i;
            m = i;
            while (l >= 0 && m < length && array[l] == array[m]) {
                if (m + 1 - l > result.length()) {
                    result = string.substring(l, m + 1);
                }
                l--;
                m++;
            }

            // search for palindrome expanded from string at i (for double letter palindrome case)
            l = i;
            m = i + 1;
            while (l >= 0 && m < length && array[l] == array[m]) {
                if (m + 1 - l > result.length()) {
                    result = string.substring(l, m + 1);
                }
                l--;
                m++;
            }
        }

        return result;
    }

    /**
     * Iterates over half of provided {@code number} checking numbers on corresponding indexes *
     * </p>
     * {@code Time O(n)}
     * </p>
     * {@code Space O(n)}
     * 
     * @param number
     * @return {@code true} if number is palindrome
     */
    public boolean isPalindrome(int number) {
        boolean isPalindrome = true;
        char[] numbers = String.valueOf(number).toCharArray();
        int half_size = numbers.length / 2;
        for (int i = 0, j = numbers.length - 1; i < half_size && j >= half_size; i++, j--) {
            if (numbers[i] != numbers[j]) {
                return false;
            }
        }
        return isPalindrome;
    }

    /**
     * Iterates over {@code string} in order to determine if given braces are written in correct form.
     * </p>
     * Only "(", ")", "[", "]", "{", "}" are valid.
     * </p>
     * {@code Time O(n)}
     * </p>
     * {@code Space O(n)}
     * 
     * @param string
     * @return {@code true} if given string is valid
     */
    public boolean isValid(String string) {
        if (string.length() % 2 != 0 || string.isEmpty()) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < string.length(); i++) {
            switch (string.charAt(i)) {
            case '(': {
                stack.add('(');
                break;
            }
            case ')': {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
                break;
            }
            case '{': {
                stack.add('{');
                break;
            }
            case '}': {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
                break;
            }
            case '[': {
                stack.add('[');
                break;
            }
            case ']': {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
                break;
            }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Iterates over two {@link ListNode}s and merges them into single sorted {@code ListNode}.
     * </p>
     * {@code list1 and list2 are sorted.}
     * </p>
     * {@code Time O(n log(n))}
     * </p>
     * {@code Space O(n)}
     * 
     * @param list1
     * @param list2
     * @return merger and sorted list
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Edge case: if both input lists are empty, return null
        if (list1 == null && list2 == null) {
            return null;
        }
        // Create a new ListNode object to use as a temporary pointer and set it as the head of the merged list
        ListNode temp = new ListNode();
        ListNode head = temp;
        // Create a new ArrayList to store all the values from the input lists
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        // Iterate through list1 and add all its elements to the ArrayList
        while (list1 != null) {
            numbers.add(list1.val);
            list1 = list1.next;
        }
        // Iterate through list2 and add all its elements to the ArrayList
        while (list2 != null) {
            numbers.add(list2.val);
            list2 = list2.next;
        }
        // Sort the ArrayList in ascending order
        Collections.sort(numbers);
        // Iterate through the sorted ArrayList and add each element to the merged list
        for (int i = 0; i < numbers.size(); i++) {
            // Set the value of the current node to the ith element in the ArrayList
            temp.val = numbers.get(i);
            // If there are more elements in the ArrayList, create a new node and set it as the next node in the merged list
            if (i + 1 < numbers.size()) {
                temp.next = new ListNode();
                temp = temp.next;
            }
        }
        // Call garbage collector explicitly to free up memory
        System.gc();
        // Return the head node of the merged and sorted list
        return head;
    }

}