package le.test.LeetCode;

import java.util.Set;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.AbstractList;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import javax.swing.event.ListDataEvent;

public class Solution extends GuessGame {

    private static int[][] moves = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    int uniquePaths = 0;
    int min_depth = Integer.MAX_VALUE;
    int max_depth = 0;
    int current_depth = 0;

    public int romanToInt(String s) {
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

    public static ListNode reverseListNode(ListNode node) {
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

            // search for palindrome expanded from string at i (for single letter palindrome
            // case)
            l = i;
            m = i;
            while (l >= 0 && m < length && array[l] == array[m]) {
                if (m + 1 - l > result.length()) {
                    result = string.substring(l, m + 1);
                }
                l--;
                m++;
            }

            // search for palindrome expanded from string at i (for double letter palindrome
            // case)
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
     * Iterates over half of provided {@code number} checking numbers on
     * corresponding indexes *
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
     * Iterates over {@code string} in order to determine if given braces are
     * written in correct form.
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
     * Iterates over two {@link ListNode}s and merges them into single sorted
     * {@code ListNode}.
     * </p>
     * {@code list1 and list2 must be sorted.}
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
        // Create a new ListNode object to use as a temporary pointer and set it as the
        // head of the merged list
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
            // If there are more elements in the ArrayList, create a new node and set it as
            // the next node in the merged list
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

    /**
     * Iterates over whole array, replacing greater values right after first entry
     * of smaller. And returns the index of last unique entry.
     * </p>
     * {@code numbs are sorted in ASCENDING order.}
     * </p>
     * {@code Time O(n^2)}
     * </p>
     * {@code Space O(1)}
     * 
     * @param numbs array of sorted numbers
     * @return amount of unique numbers
     */
    public int removeSingleDuplicates(int[] numbs) {
        // create local variable k indicating first greater number in an array and tmp
        // for swapping numbers in array
        int k = 0, tmp = 0;
        // Iterate over whole numbs array
        for (int i = 1; i < numbs.length; i++) {
            // assign k=i; because all previous entries are unique
            k = i;
            // iterate over whole array again searching for first greater number than
            // current
            while (numbs[i - 1] >= numbs[k]) {
                k++;
                // Edge case: if k reached end of array -> .gc() is called to fee up memory and
                // i as index of last unique entry is returned
                if (k == numbs.length) {
                    System.gc();
                    return i;
                }
            }
            // swap current and greater numbers
            tmp = numbs[i];
            numbs[i] = numbs[k];
            numbs[k] = tmp;
        }
        // returns length of numbers if numbs consists of only unique elements
        return numbs.length;
    }

    /**
     * Iterates over array once replacing each specified {@code value} with next non
     * equal to value number. And returns amount of values without specified number;
     * 
     * </p>
     * {@code Time O(n)}
     * </p>
     * {@code Space O(1)}
     * 
     * @param numbs to remove value from
     * @param value to be removed
     * @return amount of numbers without specified value
     */
    public int removeElement(int[] numbs, int val) {
        // Initiate k to represent current position of value to be removed
        int k = 0;

        // Iterate over array replacing specific value with another non matching
        for (int i = 0; i < numbs.length; i++) {
            // If current number does not match value to be removed current one is replaced
            // with it
            if (numbs[i] != val) {
                numbs[k++] = numbs[i];
            }
        }
        // Return amount of values without specified number
        return k;
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * Iterates over array in order to determine the position of target.
     * 
     * </p>
     * {@code Time O(n)}
     * </p>
     * {@code Space O(1)}
     * 
     * 
     * @param numbs
     * @param target
     * @return position where {@code target} is or should be.
     */
    public int searchInsert(int[] numbs, int target) {
        // EDGE CASE: if first element in array is greater than target return 0 (as
        // target would have been there)
        if (numbs[0] >= target) {
            return 0;
        }
        // initialize i to represent current position of target
        int i = 1;
        // Iterate over array to find the position of target
        for (; i < numbs.length; i++) {
            // if current namer is the target return current position
            if (numbs[i] >= target) {
                System.gc();
                return i;
            }
        }
        // EDGE CASE: if array does not contain target System.gc(); is called to free up
        // memory and length of numbers + 1 is returned (as target would have been
        // there)
        System.gc();
        return i;
    }

    /**
     * Iterates over {@code sentence} to find the length of the last word. *
     * 
     * </p>
     * {@code Time O(n)}
     * </p>
     * {@code Space O(1)}
     * 
     * @param sentence
     * @return length of the last word.
     */
    public int lengthOfLastWord(String sentence) {
        // Initialize size as size of sentence and k as length of the last word
        int size = sentence.length(), k = 0;
        // Reversibly iterate over sentence
        for (int i = size - 1; i >= 0; i--) {
            if (sentence.charAt(i) != ' ') {
                // If current character is not space word has started or is continuing and its
                // length is increased
                k++;
            } else if (sentence.charAt(i) == ' ' && k != 0) {
                // If current char is space and k is not zero => word has ended and its length
                // is returned
                return k;
            }
        }
        // if sentence is single word or has no spaces size of word is returned
        return k;
    }

    /**
     * Adds 1 to the last number of {@code digits}. And formats the result.
     * </p>
     * {@code digits are representation of single but very long number.}
     * </p>
     * {@code Time O(n)}
     * </p>
     * {@code Space O(n)}
     * 
     * @param digits
     * @return The same digits increased by one
     */
    public int[] plusOne(int[] digits) {
        // Initialize last as index of last element in digits
        int last = digits.length - 1;
        if (digits[last] == 9) { // If last element is equal to 9 it is replaced with 0 and function continues
            digits[last] = 0;
        } else {// if last number is les than 9 it is increased and digits returned (best case)
            digits[last] += 1;
            return digits;
        }
        // Iteration over an array from behind
        for (int i = last - 1; i >= 0; i--) {
            if ((digits[i] + 1) / 10 >= 1) {// if current digit increased by 1 is bigger than 10 it is changed to 0
                digits[i] = 0;
            } else {// if current digit increased by 1 is smaller than 10 it IS increased and digits
                    // are returned (average case)
                digits[i] += 1;
                return digits;
            }
        }
        // if all digits were 9 (worst case) INITIALIZE new array one element bigger
        int[] result = new int[digits.length + 1];
        // set first element to 1 (rest will be 9)
        result[0] = 1;
        // return new result
        return result;
    }

    /**
     * Iterates over 2 strings in order to add two strings as binaries
     * </p>
     * {@code Strings are binary.}
     * </p>
     * {@code Time O(n)}
     * </p>
     * {@code Space O(n)}
     * 
     * @param a number represented as binary string
     * @param b number represented as binary string
     * @return sum of two binary strings
     */
    public String addBinary(String a, String b) {
        // potential code
        // return Long.toBinaryString(Long.valueOf(a, 2) + Long.valueOf(b, 2));

        // Initialize variables for the function
        int carry = 0, left = a.length() - 1, right = b.length() - 1, sum = 0;
        // Initialize String buffer that will hold the resulting string
        StringBuffer sb = new StringBuffer();
        // Iterate over the strings until left index is less than 0 or right index is
        // less than 0 or carry is not 0
        while (left >= 0 || right >= 0 || carry != 0) {
            // assign sum as carry
            sum = carry;
            // if left index is less than 0 add number from string a at position left; add 0
            // otherwise
            sum += left >= 0 ? a.charAt(left--) - '0' : 0;
            // if right index is less than 0 add number from string a at position right; add
            // 0 otherwise
            sum += right >= 0 ? b.charAt(right--) - '0' : 0;

            // insert the resulting binary addition at a start of the string
            sb.insert(0, sum % 2);
            // assign carry for the next iteration
            carry = sum / 2;
        }
        // return StringBuilder
        return sb.toString();
    }

    public int mySqrt(int x) {
        // return (int) Math.sqrt(x);
        long low = 0, high = x, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (mid * mid == x) {
                return (int) mid;
            }
            if (mid * mid > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) high;
    }

    public int climbStairs(int n) {
        if (n == 1)
            return 1;

        if (n == 2)
            return 2;

        int n1 = 1;
        int n2 = 2;
        int next = 0;

        for (int i = 3; i <= n; i++) {
            next = n1;
            n1 = n2;
            n2 = next + n2;
        }

        return n2;
    }

    /**
     * Deletes duplicating numbers from {@code ListNode}.
     * </p>
     * {@code head must be sorted in ascending order.}
     * </p>
     * {@code Time O(n)}
     * </p>
     * {@code Space O(m)}
     * 
     * @param head Sorted {@code ListNode}.
     * @return Sorted {@code ListNode} without duplicates.
     */
    public ListNode deleteDuplicates(ListNode head) {
        // If the list is empty or has just one node, return it as there's no duplicates
        // to be removed
        if (head == null || head.next == null) {
            return head;
        }

        // Create a new ListNode called result with the first value of the original list
        ListNode result = new ListNode(head.val);

        // Create an instance of the new list and set temp as the first node
        ListNode temp = result;

        // Iterate through each node of the original list
        while (head != null) {

            // If the value of the current node being iterated does not match the last added
            // value in the new list,
            // then add this value to the end of the new list, pointing temp to the recently
            // added node
            if (head.val != temp.val) {
                temp.next = new ListNode(head.val);
                temp = temp.next;
            }

            // Move on to the next node of the original list
            head = head.next;
        }

        // Once finished iterating through the entire original list, return the newly
        // created list without any duplicates
        return result;
    }

    public void merge(int[] numbs1, int m, int[] numbs2, int n) {
        if (m < n && m == 0) {
            for (int i = 0; i < numbs2.length; i++) {
                numbs1[i] = numbs2[i];
            }
        } else {
            m--;
            for (int i = 0; i < numbs2.length; i++) {
                if (numbs1[m] <= numbs2[i]) {
                    numbs1[++m] = numbs2[i];
                } else {
                    int k = numbs1.length - 1;
                    while (k > 0 && (numbs1[k] == 0 || numbs1[k - 1] > numbs2[i])) {
                        numbs1[k] = numbs1[--k];
                    }
                    m++;
                    numbs1[k] = numbs2[i];
                }
            }
        }
        for (int i = 0; i < numbs1.length; i++) {
            System.out.print(numbs1[i] + ", ");
        }
    }

    public List<Integer> inOrderTraversal(TreeNode root) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        TreeNode cur = root;
        TreeNode prev = new TreeNode();
        while (cur != null) {
            if (cur.left == null) {// if there is no left element
                inOrder.add(cur.val);
                cur = cur.right;
            } else {
                prev = cur.left;
                while (prev.right != null && prev.right != cur) {// if there exist a right and the right is not pointing
                                                                 // himself
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;// create the thread
                    cur = cur.left;
                } else {
                    prev.right = null; // cut the thread
                    inOrder.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return inOrder;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirrored(root, root);
    }

    private boolean isMirrored(TreeNode head, TreeNode tail) {
        if (head == null && tail == null) {
            return true;
        }
        if (head != null && tail != null && head.val == tail.val) {
            return isMirrored(head.right, tail.left) && isMirrored(head.left, tail.right);
        }
        return false;
    }

    /**
     * Evaluates depth of binary tree. *
     * </p>
     * {@code Time O(n)} n as number of nodes.
     * </p>
     * {@code Space O(h)} h as height of tree.
     * 
     * @param root {@link TreeNode} as {@code root} of binary tree.
     * @return Maximum depth of {@code root} tree.
     */
    public int maxDepth(TreeNode root) {
        // if there is no root node, return 0.
        if (root == null) {
            return max_depth;
        } else {
            // increment the current depth by 1 as we move down the tree.
            current_depth++;
            // If the current depth surpasses the previous maximum depth, update the maximum
            // depth accordingly.
            if (current_depth > max_depth) {
                max_depth = current_depth;
            }
            // recursively call maxDepth method for the left and right children of the
            // current node until leaf nodes are reached.
            maxDepth(root.left);
            maxDepth(root.right);
            // decrement the current depth as we move up the tree.
            current_depth--;
            // return the maximum depth achieved.
            return max_depth;
        }
    }

    public TreeNode sortedArrayToBST(int[] numbs) {
        return CreateBST(numbs, 0, numbs.length - 1);
    }

    private TreeNode CreateBST(int numbs[], int l, int r) {
        if (l > r) {
            return null;
        }

        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(numbs[mid]);
        root.left = CreateBST(numbs, l, mid - 1);
        root.right = CreateBST(numbs, mid + 1, r);
        return root;
    }

    public boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }

    private int checkBalance(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = checkBalance(node.left);
        int rightHeight = checkBalance(node.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int minDepth(TreeNode node) {
        if (node == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        int d = 1;
        while (!q.isEmpty()) {
            int level = q.size();
            for (int i = 0; i < level; i++) {
                TreeNode c = q.poll();
                if (c.left == null && c.right == null)
                    return d;
                if (c.left != null)
                    q.offer(c.left);
                if (c.right != null)
                    q.offer(c.right);
            }
            d++;
        }
        return d;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return checkPathSum(root, 0, targetSum);
    }

    private boolean checkPathSum(TreeNode node, int sum, int targetSum) {
        if (node.left == null && node.right == null) {
            return sum + node.val == targetSum;
        }
        boolean left = node.left != null && checkPathSum(node.left, sum + node.val, targetSum);
        boolean right = node.right != null && checkPathSum(node.right, sum + node.val, targetSum);
        return left || right;
    }

    /**
     * Generates Pascal's triangle *
     * </p>
     * {@code Time O(n^2)}
     * </p>
     * {@code Space O(n^2)}
     * 
     * @param numRows height of triangle.
     * @return 2 nested {@link List}s containing triangle.
     */
    public List<List<Integer>> generate(int numRows) {
        // Initialize Lists that contain the triangle
        List<List<Integer>> list = new ArrayList<List<Integer>>(numRows);
        // Start iteration over triangles rows
        for (int i = 0; i < numRows; i++) {
            // Add new List to the row
            list.add(new ArrayList<>(i));
            // Start iterating over rows columns
            for (int j = 0; j <= i; j++) {
                // First and Last elements in Pascal's triangle are always 1 so set them
                if (j == 0 || j == i) {
                    list.get(i).add(1);
                } else {
                    // set the current value as sum of two values above it as Pascal's triangle
                    // needs
                    list.get(i).add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
        }
        // Return the triangle
        return list;
    }

    /**
     * Returns {@link List} contains n'th row of Pascal's triangle.
     * </p>
     * {@code Time O(n)}
     * </p>
     * {@code Space O(n)}
     * 
     * 
     */
    public List<Integer> getRow(int rowIndex) {
        // Initialize list that will contain n'th row of Pascal's triangle
        List<Integer> list = new ArrayList<Integer>(rowIndex);
        // Since all rows start with 1 add it
        list.add(1);
        // Initialize helping variables for formula
        long current = 0, prev = 1;
        // Iterate rowIndex times since all row at index n has n elements
        for (int i = 1; i <= rowIndex; i++) {
            // calculate current value by formula for m'th element of n'th row
            current = (prev * ((rowIndex - i + 1)) / i);
            // add value to list
            list.add((int) current);
            // save value for next iteration
            prev = current;
        }
        // return full list
        return list;
    }

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, bestDeal = 0, bestToday = 0;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            }
            bestToday = prices[i] - min;
            if (bestToday > bestDeal) {
                bestDeal = bestToday;
            }
        }
        return bestDeal;
    }

    /**
     * Iterates over sentence to determine if it is palindrome.
     * </p>
     * {@code All non word characters are ignored}.
     * </p>
     * {@code Time O(n)}.
     * </p>
     * {@code Space O(n)}.
     * 
     * @param string
     * @return {@code true} if {@code string} is palindrome.
     */
    public boolean isPalindrome(String string) {
        // Convert string to lover case and remove all non word characters
        string = string.toLowerCase().replaceAll("\\W|_", "");
        if (string.length() == 1) {// if length of string is 1 it is palindrome -> return true
            return true;
        }
        // Convert string to char array for comparison
        char[] chars = string.toCharArray();
        // Iterate from front and back of char array
        for (int i = 0, j = chars.length - 1; i < chars.length && j >= i; j--, i++) {
            // EDGE CASE: If chars are not the same, string is not palindrome, return false
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        // If iteration ended return true
        return true;
    }

    public int singleNumber(int[] numbs) {
        HashMap<Integer, Integer> map = new HashMap<>(numbs.length);
        for (int i = 0; i < numbs.length; i++) {
            if (!map.containsKey(numbs[i])) {
                map.put(numbs[i], 1);
            } else {
                map.remove(numbs[i]);
            }
        }
        return map.keySet().iterator().next();
    }

    public int bulbSwitch(int n) {
        int[] bulbs = new int[n];
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                for (int j = 0; j < bulbs.length; j++) {
                    bulbs[j] = 1;
                }
            } else if (i == 2) {
                for (int j = 1; j <= bulbs.length; j++) {
                    if (j % 2 == 0) {
                        bulbs[j - 1] = 0;
                    }
                }
            } else if (i == 3) {
                for (int j = 1; j <= bulbs.length; j++) {
                    if (j % 3 == 0) {
                        if (bulbs[j - 1] == 0) {
                            bulbs[j - 1] = 1;
                        } else {
                            bulbs[j - 1] = 0;
                        }
                    }
                }
            } else if (i == n) {
                if (bulbs[n - 1] == 0) {
                    bulbs[n - 1] = 1;
                } else {
                    bulbs[n - 1] = 0;
                }
            } else {
                for (int j = 1; j <= bulbs.length; j++) {
                    if (j % i == 0) {
                        if (bulbs[j - 1] == 0) {
                            bulbs[j - 1] = 1;
                        } else {
                            bulbs[j - 1] = 0;
                        }
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < bulbs.length; i++) {
            if (bulbs[i] == 1) {
                count++;
            }
        }
        return count;
    }

    public int removeMultipleDuplicates(int[] numbs) {
        int number = numbs[0], amount = 1;
        boolean wereReplacements = false;
        for (int i = 1; i < numbs.length; i++) {
            if (numbs[i] == Integer.MAX_VALUE) {
                number = i;
                break;
            } else if (number == numbs[i]) {
                amount++;
                if (amount > 2) {
                    wereReplacements = true;
                    numbs[i] = Integer.MAX_VALUE;
                    int k = i + 1;
                    while (k < numbs.length) {
                        int tmp = numbs[k - 1];
                        numbs[k - 1] = numbs[k];
                        numbs[k] = tmp;
                        k++;
                    }
                    i--;
                }
            } else if (number != numbs[i]) {
                number = numbs[i];
                amount = 1;
            }
        }
        if (wereReplacements) {
            return number;
        } else {
            return numbs.length;
        }
    }

    /**
     * Finds and returns element that occurs the most times. *
     * </p>
     * {@code Time O(n)}.
     * </p>
     * {@code Space O(n)}.
     * 
     * @param numbs
     * @return element that occurs the most times
     */
    public int majorityElement(int[] numbs) {
        // EDGE CASE: If numbers is null or has no elements return -1 as no elements
        // have been found
        if (numbs == null || numbs.length == 0) {
            return -1;
        }
        // Initialize map that will contain the unique entries and their amount
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(numbs.length);
        // Iterate over array adding the amount of occurrences of elements to the map
        for (int n : numbs) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        // Initialize number and its occurrences to get most frequent from the HashMap
        int numb = 0, max = 0;
        // Iterate over HashMap to find most frequent number
        for (int i : map.keySet()) {
            if (max < map.get(i)) {
                max = map.get(i);
                numb = i;
            }
        }
        // Return the most frequent number
        return numb;
    }

    public void rotate(int[] numbs, int k) {
        // int tmp = 0;
        // for (int i = 0; i < k; i++) {
        // tmp = numbs[numbs.length - 1];
        // for (int j = numbs.length - 1; j > 0; j--) {
        // numbs[j] = numbs[j - 1];
        // }
        // numbs[0] = tmp;
        // }
        int[] result = new int[numbs.length];
        for (int i = 0; i < numbs.length; i++) {
            result[(i + k) % numbs.length] = numbs[i];
        }
        System.arraycopy(result, 0, numbs, 0, numbs.length);
    }

    public int maxProfit2(int[] prices) {
        int min = Integer.MAX_VALUE, bestDeal = 0, bestToday = 0;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            }
            bestToday = prices[i] - min;
            if (bestToday > 0) {
                bestDeal += bestToday;
                min = prices[i];
            }
        }
        return bestDeal;
    }

    /**
     * Checks if we can jump from index 0 to last index.
     * </p>
     * {@code Time O(n)}.
     * </p>
     * {@code Space O(1)}.
     * 
     * @param numbs representing number of indexes we can jump from each position
     * @return {@code true} if we can reach end, {@code false} otherwise.
     */
    public boolean canJump(int[] numbs) {
        if (numbs.length == 0) { // Check if the input array is empty, i.e., length equals zero
            return true; // If so, immediately return true because it's considered "jumpable"
        }

        int desired = numbs.length - 1; // Initialize the desired index as the last element in the array
        for (int i = numbs.length - 2; i >= 0; i--) {
            // Traverse the array backwards while checking if we can reach the current
            // desired index
            if (i + numbs[i] >= desired) { // If we can reach the current desired index,
                desired = i; // then update the desired index to be the current index
            }
        }

        return desired == 0; // If the desired index has reached the start (index 0), then the array is
                             // considered "jumpable"
    }

    /**
     * This method takes an array of strings and returns the number of similarity
     * groups.
     * 
     * @param strings - An array of strings
     */
    public int numSimilarGroups(String[] strings) {
        ArrayList<String> group = new ArrayList<>();
        int amountOfGroups = 0, replacedWords = 0;
        while (replacedWords != strings.length) { // while there are still words left to be processed
            int changes = 0;
            do {
                changes = 0;
                for (int i = 0; i < strings.length; i++) { // loop through all strings and check if they are similar
                    if (strings[i] != "0") { // if string is not already included in a group
                        if (group.isEmpty()) { // if there are no groups yet, create a new group with this string
                            group.add(strings[i]);
                            strings[i] = "0";
                            changes++;
                            replacedWords++;
                        } else { // if there are already groups, check if this string is similar to any of the
                                 // strings in the existing groups
                            for (String string : group) {
                                if (areSimilar(string, strings[i])) { // if strings are similar, add this string to the
                                                                      // group and mark it as processed
                                    group.add(strings[i]);
                                    replacedWords++;
                                    changes++;
                                    strings[i] = "0";
                                    break;
                                }
                            }
                        }
                    }
                }
            } while (changes != 0); // continue processing as long as we find new similar strings
            group.clear(); // clear the group for the next set of strings
            amountOfGroups++; // increment the number of similarity groups
        }
        return amountOfGroups;
    }

    /**
     * This method checks whether two strings are similar or not based on a
     * condition. Two strings are considered similar if they have exactly two
     * different characters, and swapping those two characters would make them
     * equal.
     * 
     * @param first  - First String
     * @param second - Second String
     * @return boolean - true if strings are similar, false otherwise.
     */
    boolean areSimilar(String first, String second) {
        int count = 0;
        for (int i = 0; i < first.length(); i++) { // loop through all characters in both strings and count the number
                                                   // of differences
            if (first.charAt(i) != second.charAt(i))
                count++;
            if (count > 2)
                return false; // if there are more than two differences, the strings are not similar
        }
        return count == 2 || count == 0 && !first.equals(second); // if there are exactly two differences or no
                                                                  // differences and the strings are not equal to begin
                                                                  // with, the strings are similar
    }

    /**
     * Returns minimum amount of jumps required to get from index 0 to last index of
     * {@code numbs}.
     * </p>
     * {@code Time O(n^2)}.
     * </p>
     * {@code Space O(1)}.
     * 
     * @param numbs representing number of indexes we can jump from each position
     * @return minimum amount of jumps.
     */
    public int jump(int[] numbs) {
        // Initialize variables for number of jumps,
        // the last index that can be reached from the end of the array,
        // and the minimum index that can be reached from the end of array.
        int jumpTimes = 0, canReach = numbs.length - 1, minNumb = numbs.length - 1;

        // Loop until we reach the beginning of the array (i.e. index 0).
        while (minNumb != 0) {

            // Set the "can reach" index to the current "minimum" index.
            canReach = minNumb;

            // Find the farthest index from the current index that can be reached
            // in a single jump and set it as the new "minimum" index.
            for (int i = minNumb - 1; i >= 0; i--) {
                if (i + numbs[i] >= canReach) {
                    minNumb = i;
                }
            }

            // Increment the number of jumps required to reach the end of the array.
            jumpTimes++;
        }

        // Return the minimum number of jumps required to reach the end of the array.
        return jumpTimes;

    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        reverse(citations);
        int papers = citations.length;
        while (papers > 0 && papers > citations[papers - 1]) {
            papers--;
        }
        return papers;
    }

    void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; ++i) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    public int[] productExceptSelf(int[] numbs) {
        int n = numbs.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        int current = 1;
        for (int i = 0; i < n; i++) {
            ans[i] *= current;
            current *= numbs[i];
        }
        current = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= current;
            current *= numbs[i];
        }
        return ans;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int k = gas.length;
        int totalGas = 0;
        int currentGas = 0;
        for (int i = 0; i < k; i++) {
            totalGas = totalGas + gas[i] - cost[i];
            currentGas = currentGas + gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                start = i + 1;
            }
        }
        if (totalGas >= 0) {
            return start;
        }
        System.gc();
        return -1;
    }

    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];

        Arrays.fill(res, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                res[i] = Math.max(res[i], res[i + 1] + 1);
            }
        }

        return Arrays.stream(res).sum();
    }

    /**
     * Finds the amount of rain water stored in between {@code height}s.
     * 
     * 
     * </p>
     * {@code Time O(n)}.
     * </p>
     * {@code Space O(n)}.
     * 
     * @param height -> map representing collectors for rainwater.
     */
    public int trap(int[] height) {
        // Get the length of the input array
        int length = height.length;

        // Initialize variables for keeping track of the current height and the amount
        // of water stored
        int currentHeight = 0;
        int water = 0;

        // Create two arrays to store the maximum heights on the left and right sides of
        // each element in the input array
        int[] left = new int[length];
        int[] right = new int[length];

        // Calculate the maximum height from the left side of each element in the input
        // array and store it in the `left` array
        for (int i = 0; i < length; i++) {
            if (currentHeight < height[i]) {
                currentHeight = height[i];
            }
            left[i] = currentHeight;
        }

        // Reset the variable for keeping track of the current height, then calculate
        // the maximum height from the right side of each element in the input array and
        // store it in the `right` array
        currentHeight = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (currentHeight < height[i]) {
                currentHeight = height[i];
            }
            right[i] = currentHeight;
        }

        // Calculate the amount of water stored at each element in the input array by
        // subtracting its height from the minimum of the maximum heights on its left
        // and right sides, then add all these amounts of water together to
        // get the total amount of water stored
        for (int i = 0; i < length; i++) {
            water += Math.min(left[i], right[i]) - height[i];
        }

        // Return the total amount of water stored
        return water;
    }

    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        while (num > 0) {
            if (num >= 1000) {
                stringBuilder.append("M");
                num -= 1000;
            } else if (num >= 900) {
                stringBuilder.append("CM");
                num -= 900;
            } else if (num >= 500) {
                stringBuilder.append("D");
                num -= 500;
            } else if (num >= 400) {
                stringBuilder.append("CD");
                num -= 400;
            } else if (num >= 100) {
                stringBuilder.append("C");
                num -= 100;
            } else if (num >= 90) {
                stringBuilder.append("XC");
                num -= 90;
            } else if (num >= 50) {
                stringBuilder.append("L");
                num -= 50;
            } else if (num >= 40) {
                stringBuilder.append("XL");
                num -= 40;
            } else if (num >= 10) {
                stringBuilder.append("X");
                num -= 10;
            } else if (num >= 9) {
                stringBuilder.append("IX");
                num -= 9;
            } else if (num >= 5) {
                stringBuilder.append("V");
                num -= 5;
            } else if (num >= 4) {
                stringBuilder.append("IV");
                num -= 4;
            } else if (num >= 1) {
                stringBuilder.append("I");
                num -= 1;
            }
        }
        return stringBuilder.toString();
    }

    public String reverseWords(String s) {
        StringBuilder answer = new StringBuilder();
        String[] words = s.split(" ");
        int length = words.length;
        for (int i = length - 1; i >= 0; i--) {
            if (words[i].isEmpty())
                continue;
            if (i != length - 1) {
                answer.append(" ");
            }
            answer.append(words[i]);
        }
        return answer.toString();
    }

    public boolean isSubsequence(String toSearch, String in) {
        if (toSearch.length() > in.length()) {
            return false;
        } else if (toSearch.isEmpty()) {
            return true;
        }
        for (int i = 0, j = 0; i < in.length(); i++) {
            if (toSearch.charAt(j) == in.charAt(i)) {
                j++;
            }
            if (j == toSearch.length()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Given an array of integers `numbers` and an integer `target`, finds two
     * numbers in the array that add up to the target, and returns their indices as
     * an integer array.
     *
     * @param numbers An array of integers
     * @param target  The target sum
     * @return An integer array with the indices of the two numbers that add up to
     *         the target
     */
    public int[] twoSumII(int[] numbers, int target) {
        // If the input array is null or has less than 2 elements, return null
        if (numbers == null || numbers.length < 2) {
            return null;
        }

        // Initialize left pointer to first index and right pointer to last index
        int left = 0, right = numbers.length - 1;

        // Keep iterating until we find a pair of numbers that add up to target
        while (numbers[left] + numbers[right] != target) {
            // If the sum of the current pair is greater than target, move the right pointer
            // to the left
            if (numbers[left] + numbers[right] > target) {
                --right;
            } else { // Otherwise, move the left pointer to the right
                ++left;
            }
        }

        // If we have found a pair of numbers that add up to target, return their
        // indices as an array
        return new int[] { ++left, ++right };
    }

    /**
     * Using {@code height}s determines te maximum available water that can be
     * stored between them.
     * </p>
     * Is calculated as area of rectangle
     * 
     * </p>
     * {@code Time O(n)}.
     * </p>
     * {@code Space O(1)}.
     * 
     * @param height
     * @return maximum water that can be stored
     */
    public int maxArea(int[] height) {
        // Initialize variables
        int water = 0, left = 0, right = height.length - 1, currentWater = 0;
        // Loop until pointer meet
        while (left < right) {
            // get the amount of water using current pointers
            currentWater = (height[left] < height[right] ? height[left] : height[right]) * (right - left);
            // update if needed maximum amount of available stored water
            water = water > currentWater ? water : currentWater;
            // move pointers to higher position
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        // return maximum stored water
        return water;
    }

    public List<List<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers);
        Set<List<Integer>> result = new HashSet<>();
        int mid = 0, right = 0, sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            mid = i + 1;
            right = numbers.length - 1;
            while (mid < right) {
                sum = numbers[i] + numbers[mid] + numbers[right];
                if (sum == 0) {
                    result.add(Arrays.asList(numbers[i], numbers[mid], numbers[right]));
                    mid++;
                } else if (sum > 0) {
                    right--;
                } else {
                    mid++;
                }
            }
        }
        return new ArrayList<>(result);
    }

    public int minSubArrayLen(int target, int[] numbers) {
        int sum = 0, right = -1, left = 0, length = Integer.MAX_VALUE, n = numbers.length;
        while (++right < n) {
            sum += numbers[right];
            if (sum >= target)
                while (sum >= target) {
                    length = length < right - left + 1 ? length : right - left + 1;
                    sum -= numbers[left++];
                }
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }

    /**
     * Checks if string {@code s} is isomorphic to string {@code t}. *
     * </p>
     * {@code Time O(n)}.
     * </p>
     * {@code Space O(min(n,m))}.
     * 
     * @param s string to replace.
     * @param t string to be equal.
     * @return {@code true} if {@code s} is isomorphic, {@code false} otherwise.
     */
    public boolean isIsomorphic(String s, String t) {
        // create a HashMap to store character mappings from s to t
        HashMap<Character, Character> references = new HashMap<Character, Character>();

        // iterate through string s and map each character to its corresponding
        // character in string t
        for (int i = 0; i < s.length(); i++) {
            if (!references.containsKey(s.charAt(i))) { // if character in s is not mapped yet
                if (references.values().contains(t.charAt(i))) { // if character in t is already mapped
                    System.gc(); // calling garbage collector
                    return false;
                } else {
                    references.put(s.charAt(i), t.charAt(i)); // map the characters
                }
            } else { // if the character in s has already been seen before
                if (references.get(s.charAt(i)) != t.charAt(i)) { // but the corresponding character in t does not match
                                                                  // the current one
                    System.gc();// calling garbage collector
                    return false;
                }
            }
        }

        // create a new StringBuilder object to hold mapped string
        StringBuilder reference = new StringBuilder();
        for (int i = 0; i < t.length(); i++) {
            reference.append(references.get(s.charAt(i))); // append each mapped character from s to the new string
                                                           // builder
        }
        // compare the built string to string t to make sure they are identical
        if (!reference.toString().equals(t)) {
            System.gc();// calling garbage collector
            return false;
        }

        System.gc();// calling garbage collector
        return true;

    }

    /**
     * Given a {@code pattern} and a string {@code s}, find if {@code s} follows the
     * same pattern.
     * </p>
     * {@code Time O(n)}.
     * </p>
     * {@code Space O(n)}.
     * 
     * @param pattern
     * @param s
     * @return if {@code s} follows the pattern, {@code false} otherwise.
     */
    public boolean wordPattern(String pattern, String s) {
        // Convert the pattern string into an array of characters
        char[] chars = pattern.toCharArray();

        // Split the input "s" string into an array of words based on 'space' delimiter
        String[] words = s.split(" ");

        // If the number of words in the string 's' is different from the length of the
        // 'chars' array then return false.
        if (chars.length != words.length) {
            return false;
        }

        // Create a hash map to store character to word mappings
        HashMap<Character, String> references = new HashMap<>();

        // Loop through each word in the 'words' array and check if it matches with the
        // corresponding character in the 'chars' array
        for (int i = 0; i < words.length; i++) {

            // If the 'references' hash map doesn't contain the character or the word
            if (!references.containsKey(chars[i]) && !references.containsValue(words[i])) {

                // Add a new character to word mapping to the 'references' hash map
                references.put(chars[i], words[i]);

            } else if (references.containsKey(chars[i]) && !references.get(chars[i]).equals(words[i])) {

                // If the 'references' hash map already contains the character but with a
                // different word, return false.
                return false;

            } else if ((references.containsValue(words[i]) && !references.containsKey(chars[i])) || (!references.containsValue(words[i]) && references.containsKey(chars[i]))) {

                // If the 'references' hash map already contains the word but with a different
                // character, or the opposite, return false.
                return false;
            }
        }

        // Return true if all the mappings are valid
        return true;

    }

    /**
     * Checks if two words are anagrams
     * </p>
     * {@code Time O(n)}.
     * </p>
     * {@code Space O(1)}.
     * 
     * @param original
     * @param desired
     * @return {@code true} if words are anagrams, {@code false} otherwise.
     */
    public boolean isAnagram(String original, String desired) {
        // If two words are of different length they can't be anagrams -> return false;
        if (original.length() != desired.length()) {
            return false;
        }
        // Create map of english lowercase characters
        int[] map = new int[26];
        // Iterate over 2 words all the way
        for (int i = 0; i < original.length(); i++) {
            // add one at a position of current character in original word
            map[original.charAt(i) - 'a']++;
            // subtract one at a position of current character in desired word
            map[desired.charAt(i) - 'a']--;
        }
        // iterate over map
        for (int i = 0; i < map.length; i++) {
            // if any character is missing or insufficient words cannot be anagrams ->
            // return false;
            if (map[i] != 0) {
                return false;
            }
        }
        // If all characters met exact amount of times words are anagrams -> return
        // true;
        return true;
    }

    /**
     * checks if {@code number} is {@code happy}.
     * </p>
     * {@code number} is {@code happy} if:
     * <ul>
     * <li>Starting with any positive integer, replace the number by the sum of the
     * squares of its digits.</li>
     * <li>Repeat the process until the number equals 1 (where it will stay), or it
     * loops endlessly in a cycle which does not include 1.</li>
     * <li>Those numbers for which this process ends in 1 are happy.</li>
     * </ul>
     * 
     * </p>
     * {@code Time O(k log(n))}.
     * </p>
     * {@code Space O(k)}.
     * 
     * @param number to be checked.
     * @return {@code true} if {@code number} is {@code happy},
     *         {@code false otherwise}.
     */
    public boolean isHappy(int number) {
        // Create set to check if we are not in an endless loop
        Set<Integer> set = new HashSet<>();
        // convert number into array
        int[] intTab = getInts(number);
        // initialize sum of powers
        int sum = 0;
        // Iterate until sum not equals 1
        while (sum != 1) {
            sum = 0;
            // iterate over each number and add its power 2 to the sum
            for (int i : intTab) {
                sum += Math.pow(i, 2);
            }
            // if sum was already met we are in an endless loop -> EDGE CASE: return false;
            if (!set.add(sum)) {
                return false;
            }
            // convert number into array
            intTab = getInts(sum);
        }
        // if while loop has ended return true because number is 'happy'
        return true;
    }

    int[] getInts(int number) {
        int[] ints = new int[String.valueOf(number).length()];
        int i = 0;
        while (number > 0) {
            ints[i++] = number % 10;
            number = number / 10;
        }
        return ints;
    }

    /**
     * Checks if there are 2 identical numbers in {@code numbers} within {@code k}
     * distance.
     * </p>
     * {@code Time O(n)}.
     * </p>
     * {@code Space O(n)}.
     * 
     * @param numbers
     * @param k       should be > 0
     * @return {@code true} if there are 2 identical numbers within {@code k}
     *         distance, {@code false} otherwise.
     */
    public boolean containsNearbyDuplicate(int[] numbers, int k) {
        // Initialize HashMap representing [number,index] of numbers array
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(numbers.length);
        // Iterate over whole array
        for (int i = 0; i < numbers.length; i++) {
            // If map contains key and its index with current index is less or equal k ->
            // free up memory and return true
            if (map.containsKey(numbers[i]) && Math.abs(map.get(numbers[i]) - i) <= k) {
                System.gc();
                return true;
            } else {// add this number and its index to the HashMap
                map.put(numbers[i], i);
            }
        }
        // Free up memory and return false if there was no fulfilling conditions in
        // numbers array
        System.gc();
        return false;
    }

    public List<String> summaryRanges(int[] numbers) {
        ArrayList<String> ranges = new ArrayList<String>();
        for (int i = 0; i < numbers.length; i++) {
            int start = numbers[i];
            while (i + 1 < numbers.length && numbers[i] + 1 == numbers[i + 1])
                i++;
            if (start != numbers[i]) {
                ranges.add("" + start + "->" + numbers[i]);
            } else {
                ranges.add("" + start);
            }
        }
        return ranges;
    }

    public List<List<String>> groupAnagrams(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        return new AbstractList<List<String>>() {
            List<List<String>> result;

            @Override
            public int size() {
                if (result == null)
                    initialize();
                return result.size();
            }

            public void initialize() {
                for (String iterableString : strings) {
                    char[] keys = new char[26];
                    for (int i = 0; i < iterableString.length(); i++) {
                        keys[iterableString.charAt(i) - 'a']++;
                    }
                    String key = new String(keys);
                    List<String> list = map.get(key);
                    if (list == null)
                        map.put(key, new ArrayList<>());
                    map.get(key).add(iterableString);
                }
                result = new ArrayList<>(map.values());
            }

            @Override
            public List<String> get(int index) {
                if (result == null)
                    initialize();
                return result.get(index);
            }

        };
    }

    /**
     * Counts maximum consecutive length of {@code numbers}.
     * </p>
     * {@code Time O(n log(n))}.
     * </p>
     * {@code Space O(1)}.
     */
    public int longestConsecutive(int[] numbers) {
        // EDGE CASE: if array is empty it cannot be consecutive
        if (numbers.length == 0)
            return 0;
        // Sort array in ascending order
        Arrays.sort(numbers);
        // define variables of current length and maximum consecutive length
        int maxContinuous = 1, current = 1;
        // iterate over an array
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i - 1])// if there are 2 same numbers in an row don't count them as consecutive ->
                                             // skip;
                continue;
            else if (numbers[i] - 1 == numbers[i - 1]) {// if numbers are consecutive increase current length and set
                                                        // the max length
                current++;
                maxContinuous = maxContinuous > current ? maxContinuous : current;
            } else// if numbers are not consecutive reset current length to 1
                current = 1;
        }
        // free up memory and return maximum consecutive length
        System.gc();
        return maxContinuous;
    }

    /**
     * Checks if {@code numbers} contains any duplicating numbers .
     * </p>
     * {@code Time O(n)}.
     * </p>
     * {@code Space O(1)}.
     * 
     * @param numbers
     * @return
     */
    public boolean containsDuplicate(int[] numbers) {
        // Initialize HashSet to store numbers
        HashSet<Integer> set = new HashSet<>(numbers.length);
        // Iterate over array
        for (Integer integer : numbers) {
            // if set previously contained value free up memory and return true
            if (!set.add(integer)) { // if not numbers is simply added to set
                System.gc();
                return true;
            }
        }
        // if whole array was iterated -> free up memory and return false, as no
        // duplicates were detected
        System.gc();
        return false;
    }

    public List<List<String>> groupAnagram2(String[] strings) {
        HashMap<String, ArrayList<String>> result = new HashMap<>();
        for (String iterable : strings) {
            result.putIfAbsent(sortStringAscending(iterable), new ArrayList<>());
        }
        for (String string : strings) {
            result.get(sortStringAscending(string)).add(string);
        }
        return new ArrayList<List<String>>(result.values());
    }

    private static String sortStringAscending(String string) {
        char[] charArray = string.toCharArray();
        Arrays.sort(charArray);
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            sb.append(c);
        }
        return sb.toString();
    }

    public int[] topKFrequent(int[] numbers, int k) {
        HashMap<Integer, Integer> occurrences = new HashMap<>(numbers.length);
        for (int i : numbers) {
            if (occurrences.putIfAbsent(i, 1) != null) {
                occurrences.put(i, occurrences.get(i) + 1);
            }
        }
        int[] result = new int[k];
        int max = 0, changed = 0;

        for (int i = 0; i < k; i++) {
            max = 0;
            changed = 0;
            for (int iterable : occurrences.keySet()) {
                if (max < occurrences.get(iterable)) {
                    max = occurrences.get(iterable);
                    result[i] = iterable;
                    changed = iterable;
                }
            }
            occurrences.put(changed, Integer.MIN_VALUE);
        }

        return result;
    }

    /**
     * Performs check and decides if sudoku {@code board} is valid.
     * </p>
     * Validation rules are:
     * </p>
     * - Each row must contain the digits 1-9 without repetition.
     * </p>
     * - Each column must contain the digits 1-9 without repetition.
     * </p>
     * - Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9
     * without repetition. *
     * </p>
     * {@code Time O(n^2)}.
     * </p>
     * {@code Space O(n)}.
     * 
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {

        // Horizontal check
        HashSet<Character> numbers = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            numbers.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                if (!numbers.add(board[i][j]))
                    return false;
            }
        }
        // Vertical check
        for (int i = 0; i < 9; i++) {
            numbers.clear();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.')
                    continue;
                if (!numbers.add(board[j][i]))
                    return false;
            }
        }
        // Square check
        int columnStart = 0, columnEnd = 3;
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) {
                numbers.clear();
            }
            for (int j = columnStart; j < columnEnd; j++) {
                if (board[i][j] == '.')
                    continue;
                else if (!numbers.add(board[i][j]))
                    return false;
            }
            if (i == 8 && columnEnd != 9) {
                columnEnd += 3;
                columnStart += 3;
                i = -1;
                numbers.clear();
            }
        }
        return true;
    }

    /**
     * Encodes provided array of {@link String}s into single specific String.
     * </p>
     * Encoding schema is {@code <length>Word} and so on.
     * </p>
     * Example: {@code Java,Is,Awesome,!} -> {@code <4>Java<2>Is<7>Awesome<1>!}
     * </p>
     * {@code Time O(n)}.
     * </p>
     * {@code Space O(n)}.
     * 
     * @param strings
     * @return Encoded string
     * @see #decodeString(String)
     */
    public String encodeString(String[] strings) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            result.append("<" + strings[i].length() + ">" + strings[i]);
        }
        return result.toString();
    }

    /**
     * Decodes provided single {@link String} into array of separate Strings
     * </p>
     * Decoding schema is {@code <length>Word} and so on.
     * </p>
     * Example: {@code <4>Java<2>Is<7>Awesome<1>!} -> {@code Java,Is,Awesome,!}
     * </p>
     * {@code Time O(n)}.
     * </p>
     * {@code Space O(n)}.
     * 
     * @param strings
     * @return Decoded array of strings
     * @see #encodeString(String[])
     */
    public String[] decodeString(String encodedString) {
        LinkedList<String> strings = new LinkedList<>();
        StringBuilder word = new StringBuilder();
        int wordLength = 0;
        for (int i = 0; i < encodedString.length(); i++) {
            while (encodedString.charAt(++i) != '>') {
                word.append(encodedString.charAt(i));
            }
            wordLength = Integer.valueOf(word.toString());
            word = new StringBuilder();
            while (wordLength > 0) {
                word.append(encodedString.charAt(++i));
                wordLength--;
            }
            strings.add(word.toString());
            wordLength = 0;
            word = new StringBuilder();
        }
        return strings.toArray(new String[strings.size()]);
    }

    /**
     * Evaluates {@code reverse Polish notation}.
     * </p>
     * {@code Time O(n)}. As length of {@code tokens}.
     * </p>
     * {@code Space O(k)}. As amount of {@code numbers}.
     * </p>
     * {@code tokens MUST BE VALID}
     * 
     * @param tokens are numbers and arithmetic operators {@code 0-9, +, -, *, /}.
     * @return expressions end value.
     */
    public int evalRPN(String[] tokens) {
        // Initialize stack to store numbers
        Stack<Integer> stack = new Stack<Integer>();
        // initialize variables for calculation
        int a = 0, b = 0;
        // Iterate over all tokens of RPN
        for (String token : tokens) {
            switch (token) {
            case "+": {// Perform mathematical calculation
                a = stack.pop();
                b = stack.pop();
                stack.add(b + a);
                break;
            }
            case "-": {// Perform mathematical calculation
                a = stack.pop();
                b = stack.pop();
                stack.add(b - a);
                break;
            }
            case "*": {// Perform mathematical calculation
                a = stack.pop();
                b = stack.pop();
                stack.add(b * a);
                break;
            }
            case "/": {// Perform mathematical calculation
                a = stack.pop();
                b = stack.pop();
                stack.add(b / a);
                break;
            }

            default: {// expected to be a number -> add to stack
                stack.add(Integer.valueOf(token));
                break;
            }
            }
        }
        // Free up memory and return last value from stack -> arithmetic result
        System.gc();
        return stack.pop();
    }

    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        parenthesisRecursion(parenthesis, 0, 0, "", n);
        return parenthesis;
    }

    private void parenthesisRecursion(List<String> parenthesis, int open, int close, String string, int n) {
        if (string.length() == n * 2) {
            parenthesis.add(string);
            return;
        }
        if (open < n) {
            parenthesisRecursion(parenthesis, open + 1, close, string + "(", n);
        }
        if (close < open) {
            parenthesisRecursion(parenthesis, open, close + 1, string + ")", n);
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> temperaturesStack = new Stack<>();
        Stack<Integer> indexes = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!temperaturesStack.isEmpty() && temperaturesStack.peek() < temperatures[i]) {
                temperatures[indexes.peek()] = i - indexes.pop();
                temperaturesStack.pop();
            }
            temperaturesStack.add(temperatures[i]);
            indexes.add(i);
        }
        if (!temperaturesStack.isEmpty()) {
            for (int i = temperaturesStack.size(); i > 0; i--) {
                temperatures[indexes.pop()] = 0;
            }
        }
        return temperatures;
    }

    public int minimumDeletions(String string) {
        Stack<Integer> B_sBefore = new Stack<>();
        Stack<Integer> A_sAfter = new Stack<>();
        int amount = 0;
        for (int i = 0; i < string.length(); i++) {// count b-s before
            B_sBefore.add(amount);
            if (string.charAt(i) == 'b') {
                amount++;
            }
        }
        amount = 0;
        for (int i = string.length() - 1; i >= 0; i--) {// count a-s after
            A_sAfter.add(amount);
            if (string.charAt(i) == 'a') {
                amount++;
            }
        }
        Collections.reverse(A_sAfter);
        int minReplaces = Integer.MAX_VALUE;
        int sum = 0;
        while (!B_sBefore.isEmpty()) {
            sum = B_sBefore.pop() + A_sAfter.pop();
            minReplaces = minReplaces > sum ? sum : minReplaces;
        }
        return minReplaces;
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder word = new StringBuilder();
        int n = s.length();
        int cycleLength = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLength) {
                word.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLength - i < n) {
                    word.append(s.charAt(j + cycleLength - i));
                }
            }
        }
        return word.toString();
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Stack<ListNode> nodes = new Stack<>();
        while (head.next != null) {
            if (nodes.contains(head)) {
                return true;
            }
            nodes.add(head);
            head = head.next;
        }
        return false;
    }

    public Node copyRandomList(Node head) {
        Node copy = head;
        HashMap<Node, Node> map = new HashMap<>();

        while (copy != null) {
            map.put(copy, new Node(copy.val));
            copy = copy.next;
        }
        copy = head;

        while (copy != null) {
            Node clone = map.get(copy);
            clone.next = map.get(copy.next);
            clone.random = map.get(copy.random);
            copy = copy.next;
        }

        return map.get(head);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode copy = head;
        while (copy != null) {
            list.add(copy);
            copy = copy.next;
        }
        Collections.reverse(list.subList(left - 1, right));
        copy = list.get(0);
        ListNode temp = copy;
        for (int i = 1; i < list.size(); i++) {
            temp.next = list.get(i);
            temp = temp.next;
        }
        temp.next = null;
        return copy;
    }

    public String simplifyPath(String path) {
        path.replaceAll("/+", "/");
        String[] split = path.split("/");
        StringBuilder validPath = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < split.length; i++) {
            if (!split[i].equals(""))
                stack.add(split[i]);
        }
        int count = 0;
        Stack<String> finalStack = new Stack<>();

        while (!stack.isEmpty()) {
            String current = stack.pop();
            if (current.equals(".")) {
                continue;
            } else if (current.equals("..")) {
                count++;
                continue;
            } else {
                if (count != 0) {
                    count--;
                    continue;
                } else {
                    finalStack.add(current);
                }
            }
        }
        if (finalStack.isEmpty()) {
            System.gc();
            return "/";
        } else {
            while (!finalStack.isEmpty()) {
                validPath.append("/" + finalStack.pop());
            }
        }
        System.gc();
        return validPath.toString();
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int first = 0, second = 0;
        while (result.length() != word1.length() + word2.length()) {
            if (first < word1.length()) {
                result.append(word1.charAt(first++));
            }
            if (second < word2.length()) {
                result.append(word2.charAt(second++));
            }
        }
        return result.toString();
    }

    public String gcdOfStrings(String str1, String str2) {
        if (str2.length() > str1.length()) {
            return gcdOfStrings(str2, str1);
        }
        StringBuilder gcd = new StringBuilder();
        Stack<String> results = new Stack<>();
        for (int i = 0; i < str2.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                gcd.append(str2.charAt(i));
                if (str1.replaceAll(gcd.toString(), "").length() == 0 && str2.replaceAll(gcd.toString(), "").length() == 0) {
                    results.add(gcd.toString());
                }
            }
        }
        if (results.isEmpty()) {
            return "";
        }
        return results.pop();
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int length = candies.length;
        int maxCandies = 0;
        List<Boolean> result = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            maxCandies = maxCandies < candies[i] ? candies[i] : maxCandies;
        }
        for (int i = 0; i < length; i++) {
            if (candies[i] + extraCandies >= maxCandies)
                result.add(true);
            else
                result.add(false);
        }
        return result;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 1 && flowerbed.length == 1 && flowerbed[0] == 0) {
            return true;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (n == 0) {
                return true;
            } else if (i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
            } else if (i == flowerbed.length - 1 && flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                flowerbed[i] = 1;
                n--;
            } else if (i > 0 && i < flowerbed.length - 1) {
                if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        if (n == 0)
            return true;
        else
            return false;
    }

    public String reverseVowels(String string) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                stack.add(ch);
            }
        }
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                result.append(stack.pop());
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }

        StringBuilder compressed = new StringBuilder();
        char previous = chars[0];
        int amount = 1;
        for (int i = 1; i < chars.length; i++) {
            if (i == chars.length - 1) {
                if (chars[i] == previous) {
                    compressed.append(previous);
                    if (amount != 1) {
                        compressed.append(++amount);
                    }
                } else {
                    compressed.append(previous);
                    if (amount != 1) {
                        compressed.append(amount);
                    }
                    compressed.append(chars[i]);
                }
            } else if (chars[i] == previous) {
                amount++;
            } else if (chars[i] != previous) {
                compressed.append(previous);
                if (amount != 1) {
                    compressed.append(amount);
                }
                previous = chars[i];
                amount = 1;
            }
        }
        for (int i = 0; i < compressed.length(); i++) {
            chars[i] = compressed.charAt(i);
        }
        return compressed.length();
    }

    public void moveZeroes(int[] numbers) {
        int m = -1;
        int tmp = 0;
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            if (numbers[i] == 0) {
                if (m == -1 || numbers[m] != 0) {
                    m = i;
                }
            } else {
                if (m != -1) {
                    tmp = numbers[i];
                    numbers[i] = numbers[m];
                    numbers[m++] = tmp;
                }
            }
        }
        System.gc();
    }

    public int maxOperations(int[] numbers, int k) {
        int amountOfOperations = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int number : numbers) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        for (Integer number : map.keySet()) {
            if (Double.valueOf(number) == Double.valueOf(k) / 2d) {
                amountOfOperations += Math.floor(map.get(number) / 2);
                map.put(number, map.get(number) / 2);
            } else if (map.get(k - number) != null && (map.get(k - number) != 0 || map.get(number) != 0)) {
                int amount = Math.min(map.get(number), map.get(k - number));
                amountOfOperations += amount;
                map.put(number, map.get(number) - amount);
                map.put(k - number, map.get(k - number) - amount);
            }
        }
        System.gc();
        return amountOfOperations;
    }

    public double findMaxAverage(int[] numbers, int k) {
        int maxAVG = Integer.MIN_VALUE;
        int j = 0;
        int currentValue = 0;
        for (int i = 0; i < numbers.length - k + 1; i++) {
            j = i + k - 1;
            currentValue = 0;
            while (j >= i) {
                currentValue += numbers[j--];
            }
            maxAVG = maxAVG < currentValue ? currentValue : maxAVG;
        }
        return (double) maxAVG / k;
    }

    public int maxVowels(String s, int k) {
        int currentVowels = 0;
        int maxVowels = 0;
        int i = 0;
        int j = 0;
        char atJ = '0';
        char atI = '0';
        while (j < s.length()) {
            atJ = s.charAt(j);
            if (atJ == 'a' || atJ == 'e' || atJ == 'i' || atJ == 'o' || atJ == 'u') {
                currentVowels++;
            }
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                maxVowels = currentVowels > maxVowels ? currentVowels : maxVowels;
                atI = s.charAt(i);
                if (atI == 'a' || atI == 'e' || atI == 'i' || atI == 'o' || atI == 'u') {
                    currentVowels--;
                }
                j++;
                i++;
            }
        }
        System.gc();
        return maxVowels;
    }

    public int largestAltitude(int[] gain) {
        int[] heights = new int[gain.length + 1];
        for (int i = 0; i < gain.length; i++) {
            heights[i + 1] = gain[i];
        }
        for (int i = 1; i < heights.length; i++) {
            heights[i] += heights[i - 1];
        }
        int maxHeight = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            maxHeight = heights[i] > maxHeight ? heights[i] : maxHeight;
        }
        return maxHeight;
    }

    public int pivotIndex(int[] numbers) {
        int length = numbers.length;
        int[] arrLeft = new int[length];
        int[] arrRight = new int[length];
        for (int i = 0; i < length; i++) {// copy the arrays
            arrLeft[i] = numbers[i];
            arrRight[i] = numbers[i];
        }
        for (int i = 1; i < length; i++) {// sum up the left to right array
            arrLeft[i] += arrLeft[i - 1];
        }
        for (int i = length - 2; i >= 0; i--) {// sum up the right to left array
            arrRight[i] += arrRight[i + 1];
        }
        for (int i = 0; i < length; i++) {
            if (arrLeft[i] == arrRight[i]) {
                return i;
            }
        }
        return -1;
    }

    public List<List<Integer>> findDifference(int[] numbers1, int[] numbers2) {
        List<List<Integer>> result = new ArrayList<>() {
            {
                add(new ArrayList<>());
                add(new ArrayList<>());
            }
        };
        Set<Integer> first = new HashSet<>();
        Set<Integer> second = new HashSet<>();
        for (int i = 0; i < numbers1.length; i++) {
            first.add(numbers1[i]);
        }
        for (int i = 0; i < numbers2.length; i++) {
            second.add(numbers2[i]);
        }
        for (Integer integer : first) {
            if (!second.contains(integer)) {
                result.get(0).add(integer);
            }
        }
        for (Integer integer : second) {
            if (!first.contains(integer)) {
                result.get(0).add(integer);
            }
        }
        return result;
    }

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
        }
        Set<Integer> reference = new HashSet<>();
        for (Integer integer : count.values()) {
            if (!reference.add(integer)) {
                return false;
            }
        }
        return true;
    }

    public boolean closeStrings(String word1, String word2) {
        int[] str1 = new int[26];
        int[] str2 = new int[26];
        for (char ch : word1.toCharArray())
            str1[ch - 'a']++;

        for (char ch : word2.toCharArray()) {
            str2[ch - 'a']++;
            if (str1[ch - 'a'] == 0)
                return false;
        }
        Arrays.sort(str1);
        Arrays.sort(str2);
        for (int i = 0; i < 26; i++)
            if (str1[i] != str2[i])
                return false;

        return true;
    }

    public int equalPairs(int[][] grid) {
        int equalPairs = 0;
        int nXn = grid.length;
        ArrayList<ArrayList<Integer>> rows = new ArrayList<>(nXn);
        ArrayList<ArrayList<Integer>> columns = new ArrayList<>(nXn);
        for (int i = 0; i < nXn; i++) {
            rows.add(new ArrayList<>(nXn));
            for (int j = 0; j < nXn; j++) {
                rows.get(i).add(grid[i][j]);
            }
        }
        for (int i = 0; i < nXn; i++) {
            columns.add(new ArrayList<>(nXn));
            for (int j = 0; j < nXn; j++) {
                columns.get(i).add(grid[j][i]);
            }
        }
        for (int i = 0; i < nXn; i++) {
            for (int j = 0; j < nXn; j++) {
                if (rows.get(i).equals(columns.get(j))) {
                    equalPairs++;
                }
            }
        }
        return equalPairs;
    }

    public String removeStars(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char ch = '0';
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '*') {
                stack.pop();
            } else {
                stack.add(ch);
            }
        }
        for (Character character : stack) {
            result.append(character);
        }
        return result.toString();
    }

    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            if (radiant.poll() < dire.poll()) {
                radiant.offer(n++);
            } else {
                dire.offer(n++);
            }
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }

    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        fast = fast.next;
        if (fast == null) {
            return slow.next;
        }
        while (fast != null) {
            fast = fast.next;
            if (fast == null || fast.next == null) {
                slow.next = slow.next.next;
                break;
            }
            if (fast.next != null) {
                fast = fast.next;
            }
            slow = slow.next;
        }

        return head;
    }

    public ListNode oddEvenList(ListNode head) {
        Stack<ListNode> odd = new Stack<>();
        Stack<ListNode> even = new Stack<>();
        int i = 1;
        ListNode copy = head;
        while (copy != null) {
            if (i % 2 == 0) {
                even.add(new ListNode(copy.val));
            } else {
                odd.add(new ListNode(copy.val));
            }
            copy = copy.next;
            i++;
        }
        if (even.isEmpty() && odd.isEmpty()) {
            return head;
        }
        Collections.reverse(even);
        Collections.reverse(odd);
        ListNode result = odd.pop();
        copy = result;
        while (!odd.isEmpty()) {
            copy.next = odd.pop();
            copy = copy.next;
        }
        while (!even.isEmpty()) {
            copy.next = even.pop();
            if (!even.isEmpty())
                copy = copy.next;
        }
        return result;
    }

    public int pairSum(ListNode head) {
        int maxSum = 0;
        ListNode headCopy = head;
        ListNode copy = new ListNode();
        ListNode temp = copy;
        while (headCopy != null) {
            temp.val = headCopy.val;
            temp.next = new ListNode();
            temp = temp.next;
            headCopy = headCopy.next;
        }
        ListNode reversed = reverseListNode(head);
        while (copy != null && reversed != null) {
            int sum = copy.val + reversed.val;
            maxSum = maxSum > sum ? maxSum : sum;
            copy = copy.next;
            reversed = reversed.next;
        }
        return maxSum;
    }

    public boolean leafSimilar(TreeNode first, TreeNode second) {
        Stack<Integer> FirstTree = new Stack<>();
        getLeafNodes(first, FirstTree);

        Stack<Integer> SecondTree = new Stack<>();
        getLeafNodes(second, SecondTree);

        return FirstTree.equals(SecondTree);
    }

    private void getLeafNodes(TreeNode node, Stack<Integer> stack) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            stack.add(node.val);
        } else {
            getLeafNodes(node.left, stack);
            getLeafNodes(node.right, stack);
        }
    }

    Stack<Integer> MaxValues = new Stack<>();
    int goodNodes = 0;

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return goodNodes;
        } else {
            if (!MaxValues.isEmpty() && MaxValues.peek() <= root.val) {
                goodNodes++;
                MaxValues.add(root.val);
            } else if (MaxValues.isEmpty()) {
                goodNodes++;
                MaxValues.add(root.val);
            }
            goodNodes(root.left);
            goodNodes(root.right);
            if (!MaxValues.isEmpty() && MaxValues.peek() == root.val) {
                MaxValues.pop();
            }
        }
        return goodNodes;
    }

    ArrayList<Integer> numbs = new ArrayList<>();
    int sumAmount = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return sumAmount;
        } else {
            numbs.add(root.val);
        }
        long currentSum = 0;
        for (int i = numbs.size() - 1; i >= 0; i--) {
            currentSum += numbs.get(i);
            if (currentSum == targetSum) {
                sumAmount++;
            }
        }

        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        if (!numbs.isEmpty()) {
            numbs.remove(numbs.size() - 1);
        }
        return sumAmount;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        System.gc();
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    public int guessNumber(int n) {
        int boundMax = n;
        int boundMin = 0;
        int mid = 0;
        while (boundMin <= boundMax) {
            mid = boundMin + (boundMax - boundMin) / 2;
            switch (guess(mid)) {
            case 1: {
                boundMin = mid + 1;
                break;
            }
            case -1: {
                boundMax = mid - 1;
                break;
            }
            default:
                return mid;
            }
        }
        return -1;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int length = spells.length;
        int[] combinations = new int[length];
        Arrays.sort(potions);
        for (int i = 0; i < length; i++) {
            int start = 0;
            int end = potions.length - 1;
            while (start <= end) {
                int middle = start + (end - start) / 2;
                long result = (long) potions[middle] * spells[i];
                if (result >= success) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
            combinations[i] = potions.length - start;
        }
        return combinations;
    }

    public int findPeakElement(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] >= numbers[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int k = 0;
        for (int i = 0; i < piles.length; i++) {
            if (k < piles[i])
                k = piles[i];
        }

        int left = 1;
        int right = k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            double sum = 0d;
            for (int i = 0; i < piles.length; i++) {
                sum += Math.ceil((double) piles[i] / mid);
            }
            if (sum > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int[] countBits(int n) {
        int[] answer = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            int sum = 0;
            for (char charArray : convertIntToBinaryString(i).toCharArray()) {
                if (charArray == '1')
                    sum++;
            }
            answer[i] = sum;
        }
        return answer;
    }

    public static String convertIntToBinaryString(int number) {
        StringBuilder result = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            int mask = 1 << i;
            result.append((number & mask) != 0 ? "1" : "0");
        }
        return result.toString();
    }

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            Stack<Integer> stack = new Stack<>();
            stack.add(0);
            stack.add(1);
            stack.add(1);
            for (int i = 3; i <= n; i++) {
                int third = stack.pop();
                int second = stack.pop();
                int first = stack.pop();
                first = first + second + third;
                stack.add(second);
                stack.add(third);
                stack.add(first);
            }

            return stack.pop();
        }

    }

    /**
     * Returns values visible from "right" side of {@code root}.
     * 
     * </p>
     * {@code Time O(n)}. As amount of nodes in {@code root}.
     * </p>
     * {@code Space O(k)}. As amount of values visible from "right" side of
     * {@code root}.
     * </p>
     * 
     * @param root
     * @return List of values
     */
    public List<Integer> rightSideView(TreeNode root) {
        return new ArrayList<Integer>(getRightSideView(root, new TreeMap<>(), 0).values());// call getRightSideView and
                                                                                           // convert values to
                                                                                           // ArrayList
    }

    /**
     * Helper function for {@link #rightSideView(TreeNode)}.
     * 
     * @param root
     * @param map           TreeMap to store <Depth,Value> of nodes
     * @param current_depth Expected to be 0
     * @return TreeMap of numbers visible from "right" side of {@code root}
     */
    private TreeMap<Integer, Integer> getRightSideView(TreeNode root, TreeMap<Integer, Integer> map, int current_depth) {
        if (root == null) {
            return map;
        } else {
            current_depth++;
            map.put(current_depth, root.val);// put or change value at current depth
            getRightSideView(root.left, map, current_depth);
            getRightSideView(root.right, map, current_depth);
            current_depth--;
            return map;
        }
    }

    /**
     * Searches for level in {@code root} with the biggest sum. *
     * </p>
     * {@code Time O(n)}. As amount of nodes in {@code root}.
     * </p>
     * {@code Space O(h+n)}. h as height of {@code root}.
     * </p>
     * 
     * @param root
     * @return
     */
    public int maxLevelSum(TreeNode root) {
        ArrayList<ArrayList<Integer>> levelValues = getLevelValues(root, new ArrayList<ArrayList<Integer>>(), 0);
        int maxSum = Integer.MIN_VALUE;
        int level = 1;
        int resultLevel = 0;
        for (ArrayList<Integer> list : levelValues) {
            int sum = 0;
            for (Integer iterable : list) {
                sum += iterable;
            }
            if (maxSum < sum) {
                maxSum = sum;
                resultLevel = level;
            }
            level++;
        }
        return resultLevel;
    }

    /**
     * Helper function for {@link #maxLevelSum(TreeNode)}.
     * 
     * @param root
     * @param list
     * @param currentDepth expected to be passed 0.
     * @return ArrayList with ArrayList as each level and values in it.
     */
    private ArrayList<ArrayList<Integer>> getLevelValues(TreeNode root, ArrayList<ArrayList<Integer>> list, int currentDepth) {
        if (root == null) {
            return list;
        }
        currentDepth++;
        if (list.size() < currentDepth) {// if this depth was not visited add new "level" to the list
            list.add(new ArrayList<>());
        }
        list.get(currentDepth - 1).add(root.val);// add value of root to the list
        getLevelValues(root.left, list, currentDepth);
        getLevelValues(root.right, list, currentDepth);
        currentDepth--;
        return list;
    }

    /**
     * Checks if it is possible to visit all rooms.
     * </p>
     * {@code Time O(N+E)}. N as amount of rooms, E as amount of keys to rooms.
     * </p>
     * {@code Space O(n+e)}. N as amount of rooms, E as amount of keys to rooms.
     * </p>
     * 
     * @param rooms
     * @return {@code true} if it is possible to visit all rooms, {@code false}
     *         otherwise.
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // Initialize visited set to keep track of visited rooms
        Set<Integer> visited = new HashSet<>();
        // Initialize roomStack to determine next room to visit
        Stack<Integer> roomStack = new Stack<>();
        roomStack.push(0);
        while (!roomStack.isEmpty()) {
            Integer current = roomStack.pop();
            if (visited.add(current)) {// if room was not visited
                // Get all keys and add them to roomStack to visit those rooms
                List<Integer> keys = rooms.get(current);
                roomStack.addAll(keys);
            }
        }
        System.gc();// Free up memory
        if (rooms.size() != visited.size())// If some rooms were not visited return false
            return false;
        return true;
    }

    /**
     * Given {@code isConnected} as and 2 dimensional array checks how many
     * {@code Province}s is in there.
     * </p>
     * A {@code Province} is a group of directly or indirectly connected cities and
     * no other cities outside of the group.
     * 
     * </p>
     * {@code Time O(N^3)}. N as amount of cities.
     * </p>
     * {@code Space O(N)}.N as amount of cities.
     * </p>
     * 
     * @param isConnected
     * @return number of {@code Provinces}
     */
    public int findCircleNum(int[][] isConnected) {
        Set<Integer> visited = new HashSet<>();
        int cities = isConnected.length;
        int provinces = 0;

        // perform graph traversal for all cities
        while (visited.size() != cities) {
            for (int i = 0; i < cities; i++) {
                if (!visited.contains(i)) {
                    provinces++;
                    traverseProvince(isConnected, visited, i);// call traverseProvince for not visited city
                }
            }
        }
        System.gc();
        return provinces;
    }

    /**
     * A helper function for traversing {@code Province} starting at {@code city}.
     * 
     * @param isConnected
     * @param visited
     * @param city
     */
    private void traverseProvince(int[][] isConnected, Set<Integer> visited, int city) {
        Stack<Integer> cityStack = new Stack<>();
        cityStack.push(city);
        while (!cityStack.isEmpty()) {
            int current = cityStack.pop();
            if (visited.add(current)) {// mark city as visited and if it was not previously get all neighboring with it
                                       // cities
                for (int i = 0; i < isConnected.length; i++) {
                    if (isConnected[current][i] == 1)
                        cityStack.push(i);
                }
            }
        }
    }

    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> routs = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            routs.add(new ArrayList<>());

        for (var iterable : connections) {
            routs.get(iterable[0]).add(iterable[1]);
            routs.get(iterable[1]).add(-iterable[0]);
        }
        return reorderRouts(routs, new boolean[n], 0);
    }

    private int reorderRouts(List<List<Integer>> routs, boolean[] visited, int city) {
        int changed = 0;
        visited[city] = true;
        for (var to : routs.get(city)) {
            if (!visited[Math.abs(to)]) {
                changed += reorderRouts(routs, visited, Math.abs(to)) + (to > 0 ? 1 : 0);
            }
        }
        return changed;
    }

    /**
     * Given 2 String finds {@code Uncommon} words.
     * </p>
     * Word is {@code Uncommon} if it appears exactly once in one of the sentences,
     * and does not appear in the other sentence.
     * 
     * @param string1
     * @param string2
     * @return array of Uncommon Strings
     */
    public String[] uncommonFromSentences(String string1, String string2) {
        ArrayList<String> first = new ArrayList<>();
        ArrayList<String> second = new ArrayList<>();
        for (String iterable : string1.split(" "))
            first.add(iterable);

        for (String iterable : string2.split(" "))
            second.add(iterable);

        HashMap<String, Integer> reference = new HashMap<>();
        for (String string : first)
            reference.put(string, reference.getOrDefault(string, 0) + 1);

        for (String string : second)
            reference.put(string, reference.getOrDefault(string, 0) + 1);

        ArrayList<String> result = new ArrayList<>();
        for (var iterable : reference.entrySet())
            if (iterable.getValue() == 1)
                if ((first.contains(iterable.getKey()) && !second.contains(iterable.getKey())) || (!first.contains(iterable.getKey()) && second.contains(iterable.getKey())))
                    result.add(iterable.getKey());

        return result.toArray(new String[0]);
    }

    /**
     * Returns minimum cost to get to top of the stairs.
     * 
     * </p>
     * It is possible to climb 1 or 2 steps at a time.
     * </p>
     * {@code Time O(N)}. N as amount of costs.
     * </p>
     * {@code Space O(1)}.Inplace function.
     * </p>
     * 
     * 
     * @param cost per each stair.
     * @return minimum cost to get to top of stairs.
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        for (int i = 2; i < n; i++)
            cost[i] += cost[i - 1] < cost[i - 2] ? cost[i - 1] : cost[i - 2];

        return cost[n - 1] < cost[n - 2] ? cost[n - 1] : cost[n - 2];
    }

    /**
     * * Returns maximum amount of money that can be stolen from non adjustment
     * houses.
     * 
     * </p>
     * {@code Time O(N)}. N as amount of houses.
     * </p>
     * {@code Space O(1)}.
     * </p>
     * 
     * @param numbers as amount of money in each house.
     * @return maximum amount of money that can be stolen from non adjustment
     *         houses.
     */
    public int rob(int[] numbers) {
        int rob1 = 0;
        int rob2 = 0;
        for (int i : numbers) {
            int tmp = Math.max(rob1 + i, rob2);
            rob1 = rob2;
            rob2 = tmp;
        }
        return rob2;
    }

    public int numTilings(int n) {
        if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        int mod = 1000000007;

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] % mod + dp[i - 3] % mod) % mod;
        }
        return dp[n];
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        String[] reference = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        if (digits.length() == 0)
            return combinations;
        buildLetterCombinations(0, digits, combinations, reference, digits.length(), new StringBuilder());
        return combinations;
    }

    private void buildLetterCombinations(int i, String digits, List<String> combinations, String[] reference, int length, StringBuilder stringBuilder) {
        if (i == length) {
            combinations.add(stringBuilder.toString());
            return;
        }
        int value = digits.charAt(i) - '0';
        String ch = reference[value];
        for (int j = 0; j < ch.length(); j++) {
            stringBuilder.append(ch.charAt(j));
            buildLetterCombinations(i + 1, digits, combinations, reference, length, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> suggestions = new ArrayList<List<String>>();
        String pattern = "";
        for (char ch : searchWord.toCharArray()) {
            pattern += ch;
            List<String> matches = new ArrayList<>();
            int idx = Arrays.binarySearch(products, pattern);
            if (idx < 0) {
                idx = -(idx + 1);
            }
            for (int i = idx; i < Math.min(idx + 3, products.length); i++) {
                if (!products[i].startsWith(pattern)) {
                    break;
                }
                matches.add(products[i]);
            }
            suggestions.add(matches);
        }
        return suggestions;
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        int deletes = 0, size = intervals.length, prev = Integer.MIN_VALUE;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        for (int i = 0; i < size; i++)
            if (intervals[i][0] < prev)
                deletes++;
            else
                prev = intervals[i][1];
        return deletes;
    }

    public int findMinArrowShots(int[][] points) {
        int arrows = 1;
        Arrays.sort(points, (x, y) -> Integer.compare(x[1], y[1]));
        int prev = points[0][1];

        for (int i = 0; i < points.length; i++) {
            if (points[i][0] > prev) {
                arrows++;
                prev = points[i][1];
            }
        }
        return arrows;
    }

    public int minFlips(int a, int b, int c) {
        int flips = 0;
        while (a > 0 || b > 0 || c > 0) {
            int bitA = a & 1;
            int bitB = b & 1;
            int bitC = c & 1;

            if ((bitA | bitB) != bitC) {
                if (bitA == 1 && bitB == 1)
                    flips += 2;
                else
                    flips++;
            }

            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return flips;
    }

    int pathLength = 0;

    private void dfs(TreeNode node, boolean goLeft, int steps) {
        if (node == null) {
            return;
        }
        pathLength = Math.max(pathLength, steps);
        if (goLeft) {
            dfs(node.left, false, steps + 1);
            dfs(node.right, true, 1);
        } else {
            dfs(node.left, false, 1);
            dfs(node.right, true, steps + 1);
        }
    }

    public int longestZigZag(TreeNode root) {
        dfs(root, false, 0);
        dfs(root, true, 0);
        return pathLength;
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        outerFor: for (int i = 0; i < asteroids.length; i++) {
            if (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0) {
                int asteroidABS = Math.abs(asteroids[i]);
                int lastPop = Integer.MIN_VALUE;
                while (!stack.isEmpty() && stack.peek() > 0) {
                    if (asteroidABS == stack.peek()) {
                        lastPop = stack.pop();
                        continue outerFor;
                    } else if (asteroidABS > stack.peek())
                        lastPop = stack.pop();
                    else if (stack.peek() > asteroidABS)
                        continue outerFor;
                    else
                        break;
                }
                if (lastPop != Integer.MIN_VALUE && lastPop < asteroidABS)
                    stack.add(asteroids[i]);
            } else
                stack.add(asteroids[i]);
        }
        Collections.reverse(stack);
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = stack.pop();

        return result;
    }

    public boolean increasingTriplet(int[] numbers) {
        if (numbers.length < 3) {
            return false;
        } else {
            for (int left = 0; left < numbers.length; left++)
                for (int mid = left + 1; mid < numbers.length; mid++)
                    if (numbers[mid] > numbers[left])
                        for (int right = numbers.length - 1; right > mid; right--)
                            if (numbers[right] > numbers[mid])
                                return true;

            return false;
        }
    }

    public String decodeString2(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strBuild = new Stack<>();
        StringBuilder str = new StringBuilder();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9')
                num = num * 10 + c - '0';
            else if (c == '[') {
                strBuild.push(str);
                str = new StringBuilder();
                numStack.push(num);
                num = 0;
            } else if (c == ']') {
                StringBuilder temp = str;
                str = strBuild.pop();
                int count = numStack.pop();
                while (count-- > 0)
                    str.append(temp);

            } else
                str.append(c);
        }
        return str.toString();
    }

    public int findKthLargest(int[] n, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : n) {
            if (i > max)
                max = i;
            if (i < min)
                min = i;
        }
        int[] hash = new int[max - min + 1];
        for (int i : n) {
            hash[max - i]++;
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0)
                k -= hash[i];
            if (k <= 0)
                return max - i;
        }
        return 0;
    }

    public long maxScore(int[] numbers1, int[] numbers2, int k) {
        int n = numbers1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++)
            pairs[i] = new int[] { numbers1[i], numbers2[i] };

        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long topSum = 0;
        for (int i = 0; i < k; i++) {
            pq.add(pairs[i][0]);
            topSum += pairs[i][0];
        }
        long answer = topSum * pairs[k - 1][1];
        for (int i = k; i < n; i++) {
            topSum += pairs[i][0] - pq.poll();
            pq.add(pairs[i][0]);
            answer = Math.max(answer, topSum * pairs[i][1]);
        }
        return answer;
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> q = new LinkedList<>();

        int mazeMaxRows = maze.length, mazeMaxColumns = maze[0].length;
        int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        q.offer(new int[] { entrance[0], entrance[1], 0 });
        maze[entrance[0]][entrance[1]] = '+';

        while (!q.isEmpty()) {// Traversal of every available positions
            int[] current = q.poll();
            int row = current[0], column = current[1], distance = current[2];

            for (int[] dir : dirs) {// check for each neighboring position
                int nextRow = row + dir[0], nextColumn = column + dir[1];
                if (0 <= nextRow && nextRow < mazeMaxRows && 0 <= nextColumn && nextColumn < mazeMaxColumns && maze[nextRow][nextColumn] == '.') {// if it's not of limits and isn't border
                    if (nextRow == 0 || nextRow == mazeMaxRows - 1 || nextColumn == 0 || nextColumn == mazeMaxColumns - 1) { // if it's an exit return distance + 1]
                        return distance + 1;
                    }
                    maze[nextRow][nextColumn] = '+';
                    q.offer(new int[] { nextRow, nextColumn, distance + 1 });
                }
            }
        }
        return -1;
    }

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int gridMaxRows = grid.length, gridMaxColumns = grid[0].length;
        int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int freshCount = 0;
        for (int i = 0; i < gridMaxRows; i++) {
            for (int j = 0; j < gridMaxColumns; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j, 0 });
                }
                if (grid[i][j] == 1) {
                    freshCount += 1;
                }
            }
        }
        int maxTime = 0;
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int row = current[0], column = current[1], time = current[2];
            maxTime = time;
            for (int[] dir : directions) {
                int nextRow = row + dir[0], nextColumn = column + dir[1];
                if (0 <= nextRow && nextRow < gridMaxRows && 0 <= nextColumn && nextColumn < gridMaxColumns && grid[nextRow][nextColumn] == 1) {
                    freshCount--;
                    grid[nextRow][nextColumn] = 2;
                    q.offer(new int[] { nextRow, nextColumn, time + 1 });
                }
            }
        }
        if (freshCount == 0)
            return maxTime;

        return -1;
    }

    TreeNode LCA;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findCommonAncestor(root, p, q);
        return LCA;
    }

    private boolean findCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        int left = this.findCommonAncestor(root.left, p, q) ? 1 : 0;

        int right = this.findCommonAncestor(root.right, p, q) ? 1 : 0;

        int mid = (root == p || root == q) ? 1 : 0;

        if (mid + left + right >= 2) {
            LCA = root;
        }
        return (left + right + mid > 0);
    }

    public int longestOnes(int[] numbers, int k) {
        int maxOnes = 0;
        int zeros = 0;
        int left = 0;
        for (int right = 0; right < numbers.length; right++) {
            if (numbers[right] == 0)
                zeros++;

            while (zeros > k) {
                if (numbers[left] == 0)
                    zeros--;

                left++;
            }
            maxOnes = Math.max(maxOnes, right - left + 1);
        }
        return maxOnes;
    }

    public List<List<Integer>> combinationSum3(int amount, int sum) {
        List<List<Integer>> combinations = new ArrayList<>();
        buildCombinationSum(1, amount, sum, combinations, new ArrayList<Integer>(), 0);
        return combinations;
    }

    private void buildCombinationSum(int j, int amount, int sum, List<List<Integer>> combinations, ArrayList<Integer> currentList, int currentSum) {
        if (currentList.size() == amount && currentSum == sum) {
            combinations.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = j; i < 10; i++) {
            currentList.add(i);
            buildCombinationSum(i + 1, amount, sum, combinations, currentList, currentSum + i);
            currentList.remove(currentList.size() - 1);
        }
        return;
    }

    public void dfs(String node, String dest, HashMap<String, HashMap<String, Double>> gr, HashSet<String> vis, double[] ans, double temp) {
        if (vis.contains(node))
            return;

        vis.add(node);
        if (node.equals(dest)) {
            ans[0] = temp;
            return;
        }

        for (Map.Entry<String, Double> entry : gr.get(node).entrySet()) {
            String ne = entry.getKey();
            double val = entry.getValue();
            dfs(ne, dest, gr, vis, ans, temp * val);
        }
    }

    public HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        HashMap<String, HashMap<String, Double>> gr = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double value = values[i];

            gr.putIfAbsent(dividend, new HashMap<>());
            gr.putIfAbsent(divisor, new HashMap<>());

            gr.get(dividend).put(divisor, value);
            gr.get(divisor).put(dividend, 1.0 / value);
        }

        return gr;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> gr = buildGraph(equations, values);
        double[] finalAns = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);

            if (!gr.containsKey(dividend) || !gr.containsKey(divisor)) {
                finalAns[i] = -1.0;
            } else {
                HashSet<String> vis = new HashSet<>();
                double[] ans = { -1.0 };
                double temp = 1.0;
                dfs(dividend, divisor, gr, vis, ans, temp);
                finalAns[i] = ans[0];
            }
        }

        return finalAns;
    }

    public int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];
        map[0][0] = 1;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (i > 0 && j > 0)
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
                else if (i > 0)
                    map[i][j] = map[i - 1][j];
                else if (j > 0)
                    map[i][j] = map[i][j - 1];

        return map[m - 1][n - 1];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    if (i > 0 && j > 0)
                        map[i][j] = map[i - 1][j - 1] + 1;
                    else
                        map[i][j] = 1;
                } else {
                    if (i > 0 && j > 0) {
                        map[i][j] = Math.max(map[i - 1][j], map[i][j - 1]);
                    } else if (i > 0) {
                        map[i][j] = map[i - 1][j];
                    } else if (j > 0) {
                        map[i][j] = map[i][j - 1];
                    }
                }
            }
        }
        return map[n - 1][m - 1];
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int free = 0;
        int hold = -prices[0];
        for (int i = 1; i < n; i++) {
            hold = Math.max(hold, free - prices[i]);
            free = Math.max(free, hold + prices[i] - fee);
        }

        return free;
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if (n == 0)
            return m;
        if (m == 0)
            return n;

        int[][] map = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++)
            map[i][0] = i;

        for (int i = 1; i <= m; i++)
            map[0][i] = i;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int dif = 1;
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dif = 0;
                map[i][j] = Math.min(map[i - 1][j] + 1, Math.min(map[i][j - 1] + 1, map[i - 1][j - 1] + dif));
            }
        }
        return map[n][m];
    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        int length = arr.length;
        if (length < 2)
            return false;

        Arrays.sort(arr);
        int difference = arr[1] - arr[0];
        for (int i = 2; i < length; i++) {
            if (arr[i] - arr[i - 1] != difference)
                return false;
        }
        return true;
    }

    public boolean checkStraightLine(int[][] coordinates) {
        int length = coordinates.length;
        if (length == 2) {
            return true;
        }

        int dX = coordinates[1][0] - coordinates[0][0];
        int dY = coordinates[1][1] - coordinates[0][1];

        for (int i = 2; i < length; i++) {
            if ((dY * (coordinates[i][0] - coordinates[0][0])) != (dX * (coordinates[i][1] - coordinates[0][1])))
                return false;
        }
        return true;
    }

    public int countNegatives(int[][] grid) {
        int negatives = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] < 0)
                    negatives++;
        return negatives;
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length - 1;
        int m = 0;

        while (l < r) {
            m = (l + r) / 2;
            if (letters[m] <= target)
                l = m + 1;
            else
                r = m;
        }

        System.gc();
        if (letters[r] > target)
            return letters[r];
        return letters[0];
    }

    public int maxValue(int n, int index, int maxSum) {
        int left = 1, right = maxSum;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (getSum(index, mid, n) <= maxSum)
                left = mid;
            else
                right = mid - 1;
        }
        return left;
    }

    private long getSum(int index, int value, int n) {
        long count = 0;

        if (value > index)
            count += (long) (value + value - index) * (index + 1) / 2;
        else
            count += (long) (value + 1) * value / 2 + index - value + 1;

        if (value >= n - index)
            count += (long) (value + value - n + 1 + index) * (n - index) / 2;
        else
            count += (long) (value + 1) * value / 2 + n - index - value;

        return count - value;
    }

    public int equalPairs2(int[][] grid) {
        NumericalTrie trie = new NumericalTrie();
        int count = 0;
        int n = grid.length;
        for (int[] row : grid) {
            trie.insert(row);
        }

        for (int colum = 0; colum < n; colum++) {
            int[] arr = new int[n];
            for (int row = 0; row < n; row++) {
                arr[row] = grid[row][colum];
            }
            count += trie.search(arr);
        }
        System.gc();
        return count;
    }

    int minDif = Integer.MAX_VALUE;
    TreeNode prev;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        getMinimumDifference(root.left);
        if (prev != null) {
            minDif = Math.min(minDif, root.val - prev.val);
        }
        prev = root;

        getMinimumDifference(root.right);
        return minDif;
    }

    public int maxLevelSum2(TreeNode root) {
        HashMap<Integer, Integer> levelSum = new HashMap<>();
        getTreeNodeLevelSum(root, levelSum, 0);
        int[] pair = new int[2];
        pair[1] = Integer.MIN_VALUE;
        for (int key : levelSum.keySet()) {
            if (pair[1] < levelSum.get(key)) {
                pair[0] = key;
                pair[1] = levelSum.get(key);
            }
        }
        System.gc();
        return pair[0];
    }

    private void getTreeNodeLevelSum(TreeNode node, HashMap<Integer, Integer> levelSum, int level) {
        if (node == null) {
            return;
        }
        level++;
        getTreeNodeLevelSum(node.left, levelSum, level);

        if (!levelSum.containsKey(level)) {
            levelSum.put(level, node.val);
        } else {
            levelSum.replace(level, levelSum.get(level), levelSum.get(level) + node.val);
        }
        getTreeNodeLevelSum(node.right, levelSum, level);
        level--;

    }

    private long mod = (long) 1e9 + 7;
    private long[][] table;

    public int numOfWays(int[] numbs) {
        int m = numbs.length;

        table = new long[m][m];
        for (int i = 0; i < m; ++i) {
            table[i][0] = table[i][i] = 1;
        }
        for (int i = 2; i < m; i++) {
            for (int j = 1; j < i; j++) {
                table[i][j] = (table[i - 1][j - 1] + table[i - 1][j]) % mod;
            }
        }

        List<Integer> arrList = Arrays.stream(numbs).boxed().collect(Collectors.toList());
        return (int) ((dfs(arrList) - 1) % mod);
    }

    private long dfs(List<Integer> numbs) {
        int m = numbs.size();
        if (m < 3) {
            return 1;
        }

        List<Integer> leftNodes = new ArrayList<>();
        List<Integer> rightNodes = new ArrayList<>();
        for (int i = 1; i < m; ++i) {
            if (numbs.get(i) < numbs.get(0)) {
                leftNodes.add(numbs.get(i));
            } else {
                rightNodes.add(numbs.get(i));
            }
        }
        long leftWays = dfs(leftNodes) % mod;
        long rightWays = dfs(rightNodes) % mod;

        return (((leftWays * rightWays) % mod) * table[m - 1][leftNodes.size()]) % mod;
    }

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Map<Integer, Integer> dp = new HashMap<>();
        Arrays.sort(arr2);
        int n = arr2.length;
        dp.put(-1, 0);

        for (int i = 0; i < arr1.length; i++) {
            Map<Integer, Integer> newDp = new HashMap<>();
            for (int prev : dp.keySet()) {
                if (arr1[i] > prev) {
                    newDp.put(arr1[i], Math.min(newDp.getOrDefault(arr1[i], Integer.MAX_VALUE), dp.get(prev)));
                }
                int idx = bisectRight(arr2, prev);
                if (idx < n) {
                    newDp.put(arr2[idx], Math.min(newDp.getOrDefault(arr2[idx], Integer.MAX_VALUE), 1 + dp.get(prev)));
                }
            }
            dp = newDp;
        }

        int answer = Integer.MAX_VALUE;
        for (int value : dp.values()) {
            answer = Math.min(answer, value);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private static int bisectRight(int[] arr, int value) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int countPaths(int[][] grid) {
        int gridMaxRows = grid.length, gridMaxColumns = grid[0].length;
        for (int j = 0; j < gridMaxRows; j++) {
            for (int i = 0; i < gridMaxColumns; i++) {
                uniquePaths++;
                getAllIncreasingPaths(grid, new int[] { j, i }, gridMaxRows, gridMaxColumns);
            }
        }
        return uniquePaths % 1_000_000_007;
    }

    private void getAllIncreasingPaths(int[][] grid, int[] start, int gridMaxRows, int gridMaxColumns) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int val = grid[current[0]][current[1]];
            for (int[] move : moves) {
                int nextRow = current[0] + move[0], nextColumn = current[1] + move[1];
                if (0 <= nextRow && nextRow < gridMaxRows && 0 <= nextColumn && nextColumn < gridMaxColumns && grid[nextRow][nextColumn] > val) {
                    uniquePaths++;
                    q.offer(new int[] { nextRow, nextColumn });
                }
            }
        }
    }

    public int[] getAverages(int[] numbs, int k) {
        int n = numbs.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        if (k + k + 1 > numbs.length)
            return result;

        long sum = 0;
        int right = k + k + 1;
        int divider = k + k + 1;

        for (int i = 0; i < right; i++)
            sum += numbs[i];

        result[k] = (int) (sum / divider);

        for (int left = 0; right < n; right++, left++) {
            sum = sum + numbs[right] - numbs[left];
            result[k + left + 1] = (int) (sum / divider);
        }
        return result;
    }

    public long minCost(int[] numbs, int[] cost) {
        long left = Long.MAX_VALUE;
        long right = Long.MIN_VALUE;
        for (int num : numbs) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }
        long answer = findCostToTransform(numbs, cost, left);
        while (left < right) {
            long middle = (left + right) / 2;
            long costLeft = findCostToTransform(numbs, cost, middle);
            long costRight = findCostToTransform(numbs, cost, middle + 1);
            answer = Math.min(costLeft, costRight);
            if (costLeft < costRight)
                right = middle;
            else
                left = middle + 1;
        }
        return answer;
    }

    private long findCostToTransform(int[] numbs, int[] cost, long value) {
        long currentCost = 0;
        for (int i = 0; i < numbs.length; i++) {
            currentCost += (long) Math.abs(numbs[i] - value) * cost[i];
        }
        return currentCost;
    }

    @SuppressWarnings("unchecked")
    public int longestArithSeqLength(int[] numbs) {
        int maxLength = 0;
        HashMap<Integer, Integer>[] dp = new HashMap[numbs.length];
        for (int right = 0; right < numbs.length; ++right) {
            dp[right] = new HashMap<>();
            for (int left = 0; left < right; ++left) {
                int diff = numbs[left] - numbs[right];
                dp[right].put(diff, dp[left].getOrDefault(diff, 1) + 1);
                maxLength = Math.max(maxLength, dp[right].get(diff));
            }
        }
        return maxLength;
    }

    public int tallestBillboard(int[] rods) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        for (int i : rods) {
            HashMap<Integer, Integer> new_map = new HashMap<>(map);

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int diff = entry.getKey();
                int taller = entry.getValue();
                int shorter = taller - diff;

                new_map.put(diff + i, Math.max(new_map.getOrDefault(diff + i, 0), taller + i));

                int newDiff = Math.abs(shorter + i - taller);
                new_map.put(newDiff, Math.max(Math.max(shorter + i, taller), new_map.getOrDefault(newDiff, 0)));
            }
            map = new_map;
        }

        return map.getOrDefault(0, 0);
    }

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        int[][] dp = new int[n][fuel + 1];
        Arrays.fill(dp[finish], 1);
        for (int p = 0; p <= fuel; p++) {
            for (int s = 0; s < n; s++) {
                for (int e = 0; e < n; e++) {
                    int abs = Math.abs(locations[s] - locations[e]);
                    if (s == e)
                        continue;
                    if (abs <= p)
                        dp[s][p] = (dp[s][p] + dp[e][p - abs]) % 1000000007;
                }
            }
        }
        return dp[start][fuel];
    }

    public List<List<Integer>> kSmallestPairs(int[] numbs1, int[] numbs2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> sums = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int integer : numbs1)
            sums.offer(new int[] { integer + numbs2[0], 0 });

        while (k-- > 0 && !sums.isEmpty()) {
            int[] current = sums.poll();
            result.add(List.of(current[0] - numbs2[current[1]], numbs2[current[1]]));
            if (current[1] + 1 < numbs2.length) {
                sums.offer(new int[] { current[0] - numbs2[current[1]] + numbs2[current[1] + 1], current[1] + 1 });
            }
        }
        return result;
    }

    public int[] decompressRLElist(int[] numbs) {
        int totalSize = 0;
        for (int i = 0; i < numbs.length; i += 2)
            totalSize += numbs[i];
        int[] result = new int[totalSize];
        int pointer = 0;
        for (int i = 0; i < numbs.length; i += 2) {
            int times = numbs[i];
            int value = numbs[i + 1];
            for (int j = 0; j < times; j++) {
                result[pointer++] = value;
            }
        }
        return result;
    }

    public int xorOperation(int n, int start) {
        int xor = 0;
        for (int i = 0; i < n; i++)
            xor = xor ^ (start + 2 * i);

        return xor;
    }

    public String interpret(String command) {
        // StringBuilder result = new StringBuilder();
        // StringBuilder current = new StringBuilder();
        // for (String ch : command.split("")) {
        // if (ch.equals("G")) {
        // result.append("G");
        // } else if (ch.equals("(")) {
        // continue;
        // } else if (ch.equals(")")) {
        // if (!current.isEmpty()) {
        // result.append(current.toString());
        // current = new StringBuilder();
        // } else {
        // result.append("o");
        // }
        // } else {
        // current.append(ch);
        // }
        // }
        // return result.toString();

        // command = command.replaceAll("[(]al[)]", "al");
        // command = command.replaceAll("[(][)]", "o");
        return command.replaceAll("[(][)]", "o").replaceAll("[(]al[)]", "al");
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double dp[] = new double[n];
        dp[start] = 1.0;
        for (int i = 0; i < n - 1; i++) {
            boolean done = false;
            for (int j = 0; j < edges.length; j++) {
                int e1 = edges[j][0];
                int e2 = edges[j][1];
                double p = succProb[j];
                if (dp[e2] * p > dp[e1]) {
                    dp[e1] = dp[e2] * p;
                    done = true;
                }
                if (dp[e1] * p > dp[e2]) {
                    dp[e2] = dp[e1] * p;
                    done = true;
                }
            }
            if (!done)
                break;
        }
        return dp[end];
    }

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        Queue<int[]> queue = new LinkedList<>();
        Map<Integer, Set<Pair<Integer, Integer>>> seen = new HashMap<>();
        Set<Character> keySet = new HashSet<>();
        Set<Character> lockSet = new HashSet<>();
        int allKeys = 0;
        int startR = -1, startC = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char cell = grid[i].charAt(j);
                if (cell >= 'a' && cell <= 'f') {
                    allKeys += (1 << (cell - 'a'));
                    keySet.add(cell);
                }
                if (cell >= 'A' && cell <= 'F') {
                    lockSet.add(cell);
                }
                if (cell == '@') {
                    startR = i;
                    startC = j;
                }
            }
        }
        queue.offer(new int[] { startR, startC, 0, 0 });
        seen.put(0, new HashSet<>());
        seen.get(0).add(new Pair<>(startR, startC));
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curR = cur[0], curC = cur[1], keys = cur[2], dist = cur[3];
            for (int[] move : moves) {
                int newR = curR + move[0], newC = curC + move[1];
                if (newR >= 0 && newR < m && newC >= 0 && newC < n && grid[newR].charAt(newC) != '#') {
                    char cell = grid[newR].charAt(newC);
                    if (keySet.contains(cell)) {
                        if (((1 << (cell - 'a')) & keys) != 0) {
                            continue;
                        }
                        int newKeys = (keys | (1 << (cell - 'a')));
                        if (newKeys == allKeys) {
                            return dist + 1;
                        }
                        seen.putIfAbsent(newKeys, new HashSet<>());
                        seen.get(newKeys).add(new Pair<>(newR, newC));
                        queue.offer(new int[] { newR, newC, newKeys, dist + 1 });
                    }
                    if (lockSet.contains(cell) && ((keys & (1 << (cell - 'A'))) == 0)) {
                        continue;
                    } else if (!seen.get(keys).contains(new Pair<>(newR, newC))) {
                        seen.get(keys).add(new Pair<>(newR, newC));
                        queue.offer(new int[] { newR, newC, keys, dist + 1 });
                    }
                }
            }
        }

        return -1;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0, right = cells.length;
        while (left < right) {
            boolean[][] grid = new boolean[row][col];
            int mid = right - (right - left) / 2;
            for (int i = 0; i < mid; i++) {
                grid[cells[i][0] - 1][cells[i][1] - 1] = true;
            }
            if (canReachBottom(grid))
                left = mid;
            else
                right = mid - 1;
        }
        return left;
    }

    private boolean canReachBottom(boolean[][] grid) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == false)
                q.offer(new Pair<Integer, Integer>(0, i));
        }

        while (!q.isEmpty()) {
            Pair<Integer, Integer> current = q.poll();

            if (!visited[current.getKey()][current.getValue()]) {
                visited[current.getKey()][current.getValue()] = true;

                if (current.getKey() == grid.length - 1)
                    return true;

                for (int[] move : moves) {
                    int nextRow = current.getKey() + move[0], nextColumn = current.getValue() + move[1];
                    if (0 <= nextRow && nextRow < grid.length && nextColumn >= 0 && nextColumn < grid[0].length && grid[nextRow][nextColumn] != true)
                        q.offer(new Pair<Integer, Integer>(nextRow, nextColumn));
                }
            }
        }
        return false;
    }

    public int distributeCookies(int[] cookies, int k) {
        int[] possessions = new int[k];
        return distributeCookies(0, possessions, cookies, k, k);
    }

    private int distributeCookies(int i, int[] possessions, int[] cookies, int k, int zeros) {
        if (cookies.length - i < zeros)
            return Integer.MAX_VALUE;
        else if (i == cookies.length) {
            int unfairness = Integer.MIN_VALUE;

            for (int value : possessions)
                unfairness = Math.max(unfairness, value);

            return unfairness;
        } else {
            int answer = Integer.MAX_VALUE;

            for (int j = 0; j < possessions.length; j++) {
                if (possessions[j] == 0)
                    zeros--;

                possessions[j] += cookies[i];

                answer = Math.min(answer, distributeCookies(i + 1, possessions, cookies, k, zeros));

                possessions[j] -= cookies[i];

                if (possessions[j] == 0)
                    zeros++;
            }
            return answer;
        }
    }

    public int maximumRequests(int n, int[][] requests) {
        int possibleTransfers = 0;
        for (int i = 0; i < (1 << requests.length); i++) {
            int[] degree = new int[n];
            int bitCount = Integer.bitCount(i);
            int pos = requests.length - 1;
            if (bitCount <= possibleTransfers)
                continue;

            for (int j = i; j > 0; j >>= 1, pos--) {
                if ((j & 1) == 1) {
                    degree[requests[pos][0]]--;
                    degree[requests[pos][1]]++;
                }
            }
            boolean valid = true;
            for (int j = 0; j < n; j++) {
                if (degree[j] != 0) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                possibleTransfers = bitCount;
            }
        }
        return possibleTransfers;
    }

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        if (s.equals(goal)) {
            HashMap<Character, Integer> count = new HashMap<>();

            for (int i = 0; i < s.length(); i++)
                count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
            for (int integer : count.values()) {
                if (integer > 1)
                    return true;
            }
            return false;
        } else {
            int left = -1;
            char[] first = s.toCharArray();
            char[] second = goal.toCharArray();
            int n = first.length;
            for (int i = 0; i < n; i++) {
                if (first[i] != second[i])
                    if (left == -1) {
                        left = i;
                    } else {
                        char tmp = first[left];
                        first[left] = first[i];
                        first[i] = tmp;
                        break;
                    }
            }
            for (int i = 0; i < n; i++) {
                if (first[i] != second[i])
                    return false;
            }
        }
        return true;
    }

    public int singleNumberII(int[] numbs) {
        HashMap<Integer, Integer> map = new HashMap<>(numbs.length);
        for (int i = 0; i < numbs.length; i++)
            map.put(numbs[i], map.getOrDefault(numbs[i], 0) + 1);

        for (int i : map.keySet())
            if (map.get(i) < 3)
                return i;

        return -1;
    }

    public int longestSubarray(int[] numbers) {
        int zeros = 0;
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < numbers.length; right++) {
            if (numbers[right] == 0)
                zeros++;
            while (left < right && zeros > 1) {
                if (numbers[left] == 0)
                    zeros--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int res = 0, l = 0, n = answerKey.length(), Ts = 0, Fs = 0;
        for (int r = 0; r < n; r++) {
            if (answerKey.charAt(r) == 'F')
                Fs++;
            else
                Ts++;

            while (l < n && (Ts > k && Fs > k)) {
                if (answerKey.charAt(l) == 'F')
                    Fs--;
                else
                    Ts--;
                l++;
            }
            if (res < r - l + 1)
                res = r - l + 1;
        }

        return res;
    }

    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int[] pairs = new int[n - 1];
        long res = 0L;
        for (int i = 0; i < n - 1; i++)
            pairs[i] = weights[i] + weights[i + 1];

        Arrays.sort(pairs, 0, n - 1);

        for (int i = 0; i < k - 1; ++i)
            res += pairs[n - 2 - i] - pairs[i];

        return res;
    }

    public int largestVariance(String s) {
        char[] inp = s.toCharArray();
        int[] map = new int[26];
        for (int i = 0; i < inp.length; i++)
            map[inp[i] - 'a']++;
        int res = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == j || map[i] == 0 || map[j] == 0) {
                    continue;
                }
                res = Math.max(res, countVariance(inp, (char) (i + 'a'), (char) (j + 'a'), map[j]));
            }
        }
        return res;
    }

    private int countVariance(char[] inp, char major, char minor, int restMinor) {
        int minorC = 0;
        int majorC = 0;
        int res = 0;
        for (char k : inp) {
            if (k == major) {
                majorC++;
            }
            if (k == minor) {
                restMinor--;
                minorC++;
            }
            if (minorC > 0) {
                res = Math.max(res, majorC - minorC);
            }
            if (majorC < minorC && restMinor > 0) {
                majorC = 0;
                minorC = 0;
            }
        }
        return res;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode t, int k) {
        HashMap<Integer, ArrayList<Integer>> g = new HashMap<>();
        ArrayList<Integer> r = new ArrayList<>();
        Set<Integer> v = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] { t.val, 0 });
        v.add(t.val);
        buildGraph(root, null, g);
        while (!q.isEmpty()) {
            int[] c = q.poll();
            int n = c[0], d = c[1];
            if (d == k) {
                r.add(n);
                continue;
            }
            for (int neighboring : g.getOrDefault(n, new ArrayList<>())) {
                if (!v.contains(neighboring)) {
                    v.add(neighboring);
                    q.offer(new int[] { neighboring, d + 1 });
                }
            }
        }
        return r;
    }

    private void buildGraph(TreeNode current, TreeNode parent, HashMap<Integer, ArrayList<Integer>> graph) {
        if (current != null && parent != null) {
            int cVal = current.val, pVal = parent.val;
            graph.putIfAbsent(cVal, new ArrayList<>());
            graph.putIfAbsent(pVal, new ArrayList<>());
            graph.get(cVal).add(pVal);
            graph.get(pVal).add(cVal);
        }
        if (current != null && current.left != null)
            buildGraph(current.left, current, graph);
        if (current != null && current.right != null)
            buildGraph(current.right, current, graph);
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] in = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] safe = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int node : graph[i]) {
                adj.get(node).add(i);
                in[i]++;
            }
        }

        for (int i = 0; i < n; i++)
            if (in[i] == 0)
                q.add(i);

        while (!q.isEmpty()) {
            int no = q.poll();
            safe[no] = true;
            for (int neighboring : adj.get(no)) {
                in[neighboring]--;
                if (in[neighboring] == 0)
                    q.offer(neighboring);
            }
        }
        for (int i = 0; i < n; i++)
            if (safe[i])
                res.add(i);

        return res;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0)
            return true;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(numCourses);
        int[] in = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            in[pre[0]]++;
        }
        for (int i = 0; i < numCourses; i++)
            if (in[i] == 0)
                q.offer(i);

        int visited = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            visited++;
            for (int integer : adj.get(node)) {
                in[integer]--;
                if (in[integer] == 0)
                    q.offer(integer);
            }
        }
        return visited == numCourses;
    }

    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        HashMap<Integer, Integer> dp = new HashMap<>(n);
        int answer = 1;
        for (int i = 0; i < n; i++) {
            dp.put(arr[i], dp.getOrDefault(arr[i] - difference, 0) + 1);
            answer = Math.max(answer, dp.get(arr[i]));
        }
        return answer;
    }

    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int[][] dp = new int[k + 1][n + 1];
        for (int i = n - 1; i >= 0; --i) {
            for (int c = 1; c <= k; c++) {
                dp[c][i] = Math.max(dp[c][i + 1], events[i][2] + dp[c - 1][binSearchRight(events, events[i][1])]);
            }
        }
        return dp[k][0];
    }

    private int binSearchRight(int[][] events, int i) {
        int l = 0, r = events.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (events[m][0] <= i) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = people.size(), m = req_skills.length;
        HashMap<String, Integer> skillId = new HashMap<>();
        long[] dp = new long[(int) Math.pow(2, m)];
        int skillMaskOfPerson[] = new int[n];

        for (int i = 0; i < m; i++)
            skillId.put(req_skills[i], i);

        for (int i = 0; i < n; i++)
            for (String skill : people.get(i))
                skillMaskOfPerson[i] |= 1 << skillId.get(skill);

        Arrays.fill(dp, (1L << n) - 1);
        dp[0] = 0;

        for (int mask = 1; mask < (1 << m); mask++) {
            for (int i = 0; i < n; i++) {
                int smaller = mask & ~skillMaskOfPerson[i];
                if (smaller != mask) {
                    long personMask = dp[smaller] | (1L << i);
                    if (Long.bitCount(personMask) < Long.bitCount(dp[mask]))
                        dp[mask] = personMask;
                }

            }
        }
        long ans = dp[(1 << m) - 1];
        int[] result = new int[Long.bitCount(ans)];
        int pointer = 0;
        for (int i = 0; i < n; i++)
            if (((ans >> i) & 1) == 1)
                result[pointer++] = i;

        return result;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        while (l1 != null) {
            a1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            a2.add(l2.val);
            l2 = l2.next;
        }
        int maxLength = Math.max(a1.size(), a2.size());
        ArrayList<Integer> summed = new ArrayList<>(maxLength);
        int i = 0;
        if (a1.size() > a2.size()) {
            for (i = 0; i < a1.size(); i++)
                summed.add(a1.get(i));
            for (int j = a2.size() - 1; j >= 0; j--) {
                int sum = summed.get(--i) + a2.get(j);
                summed.set(i, sum);
            }

        } else {
            for (i = 0; i < a2.size(); i++)
                summed.add(a2.get(i));
            for (int j = a1.size() - 1; j >= 0; j--) {
                int sum = summed.get(--i) + a1.get(j);
                summed.set(i, sum);
            }
        }
        int lead = 0;

        for (int j = summed.size() - 1; j >= 0; j--) {
            int val = summed.get(j) + lead;
            if (val >= 10) {
                lead = 0;
                do
                    lead++;
                while ((val = val - 10) >= 10);
            } else if (lead > 0)
                lead--;

            summed.set(j, val);
        }
        if (lead != 0)
            summed.add(0, lead);

        ListNode current = new ListNode();
        ListNode track = current;
        for (int j = 0; j < summed.size(); j++) {
            track.val = summed.get(j);
            if (j + 1 < summed.size()) {
                track.next = new ListNode();
                track = track.next;
            }
        }
        return current;
    }

    public int findNumberOfLIS(int[] numbs) {
        int n = numbs.length;
        int[] dp = new int[n];
        int[] ways = new int[n];
        int maxSofar = 0, result = 0;
        for (int i = 0; i < n; i++) {
            calculateDP(i, numbs, dp, ways);
            maxSofar = maxSofar > dp[i] ? maxSofar : dp[i];
        }
        for (int i = 0; i < n; i++)
            if (dp[i] == maxSofar)
                result += ways[i];
        return result;
    }

    private void calculateDP(int i, int[] numbs, int[] dp, int[] ways) {
        if (dp[i] != 0)
            return;
        dp[i] = 1;
        ways[i] = 1;
        for (int j = 0; j < i; j++) {
            if (numbs[j] < numbs[i]) {
                calculateDP(j, numbs, dp, ways);
                if (dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    ways[i] = 0;
                }
                if (dp[j] + 1 == dp[i]) {
                    ways[i] += ways[j];
                }
            }
        }
    }

    HashMap<Integer, List<TreeNode>> allPossibleFBTdp = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0)
            return new ArrayList<TreeNode>();
        if (n == 1)
            return Arrays.asList(new TreeNode());
        if (allPossibleFBTdp.containsKey(n))
            return allPossibleFBTdp.get(n);
        List<TreeNode> list = new ArrayList<>();
        for (int i = 1; i < n - 1; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i - 1);
            for (TreeNode l : left)
                for (TreeNode r : right)
                    list.add(new TreeNode(0, l, r));
        }
        allPossibleFBTdp.put(n, list);
        return list;
    }

    public double knightProbability(int n, int k, int row, int column) {
        double probability = 0;
        int[][] knightMoves = new int[][] { { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 } };
        double[][] prev = new double[n][n];
        double[][] curr = new double[n][n];

        prev[row][column] = 1;

        while (k-- > 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    curr[i][j] = 0;
                    for (int[] move : knightMoves) {
                        int newRow = i - move[0], newColumn = j - move[1];
                        if (newRow < n && newColumn < n && newRow >= 0 && newColumn >= 0) {
                            curr[i][j] += prev[newRow][newColumn] / 8;
                        }
                    }
                }
            }
            double[][] tmp = prev;
            prev = curr;
            curr = tmp;
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                probability += prev[i][j];

        return probability;
    }
}
